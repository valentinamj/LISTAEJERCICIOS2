package observer;

public interface Observable {

    void suscribir(Observer observer); // agrega un observador

    void desuscribir(Observer observer); // elimina un observador

    void notificar(String mensaje); // notifica a todos los observadores
}
