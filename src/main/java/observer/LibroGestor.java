package observer;

import java.util.ArrayList;
import java.util.List;

// clase para gestionar libros y notificar a los suscriptores
public class LibroGestor implements Observable {

    private List<Observer> suscriptores; // lista de observadores

    public LibroGestor() {
        suscriptores = new ArrayList<>();
    }

    // agrega un observador a la lista
    @Override
    public void suscribir(Observer observer) {
        suscriptores.add(observer);
    }

    // elimina un observador de la lista
    @Override
    public void desuscribir(Observer observer) {
        suscriptores.remove(observer);
    }

    // notifica a todos los observadores con un mensaje
    @Override
    public void notificar(String mensaje) {
        for (Observer observer : suscriptores) {
            observer.actualizar(mensaje);
        }
    }

    // ejemplo de método para notificar disponibilidad de un libro
    public void libroDisponible(String tituloLibro) {
        notificar("El libro '" + tituloLibro + "' ahora está disponible.");
    }
}
