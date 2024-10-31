
package listadeejercicio1;

import java.io.*;
import java.util.*;

public class RepositorioLibros {

    private List<Libro> libros;
    private final String archivo = "libros.txt";

    public RepositorioLibros() {
        libros = new ArrayList<>();
        cargarLibros();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
        guardarLibros();
    }

    public List<Libro> listarLibros() {
        return libros;
    }

    public void buscarLibro(String generoIngresado) {
        libros.stream()
                .filter(l -> l.getGenero().equalsIgnoreCase(generoIngresado))
                .map(Libro::getTitulo)
                .forEach(System.out::println);
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
