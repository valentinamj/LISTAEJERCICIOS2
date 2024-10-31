package observer;

public class Main {

    public static void main(String[] args) {
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
    }
}
