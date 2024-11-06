
package listadeejercicio1;

import java.io.*;
import java.util.*;
import observer.LibroGestor;
import observer.Usuario;

public class RepositorioLibros {

    private List<Libro> libros;
    private final String archivo = "libros.txt";
    LibroGestor libroGestor;

    public RepositorioLibros() {
        libros = new ArrayList<>();
        cargarLibros();
        
        libroGestor = new LibroGestor();

        Usuario usuario1 = new Usuario("Mario TG", "ejemplo123@hotmail.com");
        Usuario usuario2 = new Usuario("Julio MH", "ejemplo456@hotmail.com");

        // subscribo los usuarios al gestor de libros
        libroGestor.suscribir(usuario1);
        libroGestor.suscribir(usuario2);

    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
        guardarLibros();
        
        libroGestor.libroDisponible(libro.getTitulo());

    }

    public List<Libro> listarLibros() {
        return libros;
    }

    public void buscarLibroPorGenero(String generoIngresado) {
        libros.stream()
                .filter(l -> l.getGenero().equalsIgnoreCase(generoIngresado))
                .forEach(libro ->{
                    if(libro.getEstadoPrestamo()==Libro.EstadoPrestamo.LIBRE)
                        System.out.println("Título: "+libro.getTitulo()+" - Estado: "+libro.getEstadoPrestamo());
                    else if(libro.getEstadoPrestamo()==Libro.EstadoPrestamo.OCUPADO)
                        System.out.println("Título: "+libro.getTitulo()+" - Estado: "+libro.getEstadoPrestamo()+
                        " - Fecha de liberación: "+libro.getFechaLiberacion());
                });
    }
    
    public void buscarLibroPorAutor(String autorIngresado) {
        libros.stream()
                .filter(l -> l.getAutor().equalsIgnoreCase(autorIngresado))
                .forEach(libro ->{
                    if(libro.getEstadoPrestamo()==Libro.EstadoPrestamo.LIBRE)
                        System.out.println("Título: "+libro.getTitulo()+" - Estado: "+libro.getEstadoPrestamo());
                    else if(libro.getEstadoPrestamo()==Libro.EstadoPrestamo.OCUPADO)
                        System.out.println("Título: "+libro.getTitulo()+" - Estado: "+libro.getEstadoPrestamo()+
                        " - Fecha de liberación: "+libro.getFechaLiberacion());
                });
    }

    public void eliminarLibro(String titulo) {
        libros.removeIf(libro -> libro.getTitulo().equalsIgnoreCase(titulo));
        guardarLibros();
    }

    private void cargarLibros() {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length >= 8) {
                    Libro libro = new Libro.Builder(partes[0], partes[1]) // Título y autor son obligatorios
                            .setAnoPublicacion(Integer.parseInt(partes[2]))
                            .setGenero(partes[3])
                            .setNumeroPaginas(Integer.parseInt(partes[4]))
                            .setEstadoPrestamo(Libro.EstadoPrestamo.valueOf(partes[5])) // Convertir el String a EstadoPrestamo
                            .setNumeroCapitulos(Integer.parseInt(partes[6]))
                            .setFechaLiberacion(partes[7])
                            .build();
                    libros.add(libro);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.err.println("Estado de préstamo no válido en el archivo: " + e.getMessage());
        }
    }

    private void guardarLibros() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Libro libro : libros) {
                bw.write(libro.getTitulo() + "," + 
                         libro.getAutor() + "," + 
                         libro.getAnoPublicacion() + "," + 
                         libro.getGenero() + "," + 
                         libro.getNumeroPaginas() + "," + 
                         libro.getEstadoPrestamo().name() + "," + // Usar name() para obtener el String del enum
                         libro.getNumeroCapitulos() + "," + 
                         libro.getFechaLiberacion());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
