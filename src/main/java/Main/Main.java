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
       
        RepositorioLibros repositorioLibros=new RepositorioLibros();
        Libro libro4=new Libro.Builder("100 años de soledad", "Gabriel García Marquez")
                .setGenero("Novela")
                .build();
        
        repositorioLibros.agregarLibro(libro4);
        
        System.out.println("Ingrese género:");
        String input=scanner.nextLine();
        repositorioLibros.buscarLibroPorGenero(input);
        
        System.out.println("Ingrese autor:");
        input=scanner.nextLine();
        repositorioLibros.buscarLibroPorAutor(input);
        
        scanner.close();
    }
}
