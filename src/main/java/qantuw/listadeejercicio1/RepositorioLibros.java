package qantuw.listadeejercicio1;

import java.io.*;
import java.util.*;
import qantuw.listadeejercicio1.Libro;

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


    public Optional<Libro> buscarLibro(String titulo) {
        return libros.stream()
                .filter(libro -> libro.getTitulo().equalsIgnoreCase(titulo))
                .findFirst();
    }

    // Eliminar un libro por título
    public void eliminarLibro(String titulo) {
        libros.removeIf(libro -> libro.getTitulo().equalsIgnoreCase(titulo));
        guardarLibros();
    }

    // Cargar libros desde un archivo
    private void cargarLibros() {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length >= 8) {  // Validar que todos los atributos estén presentes
                    Libro libro = new Libro.BuilderLibro()
                            .titulo(partes[0])
                            .autor(partes[1])
                            .anioPublicacion(Integer.parseInt(partes[2]))
                            .genero(partes[3])
                            .numeroPaginas(Integer.parseInt(partes[4]))
                            .estadoPrestamo(partes[5])
                            .numeroCapitulos(Integer.parseInt(partes[6]))
                            .fechaLiberacion(partes[7])
                            .build();
                    libros.add(libro);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Guardar libros en un archivo
    private void guardarLibros() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Libro libro : libros) {
                bw.write(libro.getTitulo() + "," + 
                         libro.getAutor() + "," + 
                         libro.getAnioPublicacion() + "," + 
                         libro.getGenero() + "," + 
                         libro.getNumeroPaginas() + "," + 
                         libro.getEstadoPrestamo() + "," + 
                         libro.getNumeroCapitulos() + "," + 
                         libro.getFechaLiberacion());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}