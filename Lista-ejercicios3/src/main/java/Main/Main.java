package Main;

import java.util.List;
import java.util.Scanner;
import listadeejercicio1.Libro;
import listadeejercicio1.RepositorioLibros;
import observer.LibroGestor;
import observer.Usuario;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author C2A601-19
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String generoIngresado=scanner.nextLine();
       
        Libro libro1=new Libro.Builder("La ciudad y los perros", "Mario Vargas Llosa")
                .setGenero("Novela")
                .build();
        Libro libro2=new Libro.Builder("Luna de Plutón", "Dross")
                .setGenero("Ciencia ficcion")
                .build();
        
        RepositorioLibros repositorioLibros=new RepositorioLibros();
        repositorioLibros.agregarLibro(libro1);
        repositorioLibros.agregarLibro(libro2);
        
        LibroGestor libroGestor = new LibroGestor();

        Usuario usuario1 = new Usuario("Mario TG", "ejemplo123@hotmail.com");
        Usuario usuario2 = new Usuario("Julio MH", "ejemplo456@hotmail.com");

        // subscribo los usuarios al gestor de libros
        libroGestor.suscribir(usuario1);
        libroGestor.suscribir(usuario2);

        // luego les notifico que un libro está disponible
        libroGestor.libroDisponible("Programación en Java");

        // luego desuscribo a un usuario y vuelvo a notificar
        libroGestor.desuscribir(usuario1);
        libroGestor.libroDisponible("Estructuras de Datos");

        repositorioLibros.buscarLibro(generoIngresado);
        
        scanner.close();
    }
}
