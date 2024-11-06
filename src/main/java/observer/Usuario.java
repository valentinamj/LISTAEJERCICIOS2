package observer;

public class Usuario implements Observer {

    private String nombre;
    private String email;

    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    // implementación del método actualizar
    @Override
    public void actualizar(String mensaje) {
        System.out.println("Notificación para " + nombre + ": " + mensaje);
    }

    // getters
    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }
}
