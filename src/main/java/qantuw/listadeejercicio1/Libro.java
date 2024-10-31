

package qantuw.listadeejercicio1;

public class Libro {
    private String titulo;
    private String autor;
    private int anoPublicacion;
    private String genero;
    private int numeroPaginas;
    private EstadoPrestamo estadoPrestamo;
    private int numeroCapitulos;
    private String fechaLiberacion; 

    
    private Libro(Builder builder) {
        this.titulo = builder.titulo;
        this.autor = builder.autor;
        this.anoPublicacion = builder.anoPublicacion;
        this.genero = builder.genero;
        this.numeroPaginas = builder.numeroPaginas;
        this.estadoPrestamo = builder.estadoPrestamo;
        this.numeroCapitulos = builder.numeroCapitulos;
        this.fechaLiberacion = builder.fechaLiberacion;
    }

   
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getAnoPublicacion() { return anoPublicacion; }
    public String getGenero() { return genero; }
    public int getNumeroPaginas() { return numeroPaginas; }
    public EstadoPrestamo getEstadoPrestamo() { return estadoPrestamo; }
    public int getNumeroCapitulos() { return numeroCapitulos; }
    public String getFechaLiberacion() { return fechaLiberacion; }

    
    public enum EstadoPrestamo {
        OCUPADO,
        LIBRE,
        NO_EXISTE
    }

    
    public static class Builder {
        private String titulo;
        private String autor;
        private int anoPublicacion;
        private String genero;
        private int numeroPaginas;
        private EstadoPrestamo estadoPrestamo = EstadoPrestamo.LIBRE; 
        private int numeroCapitulos;
        private String fechaLiberacion;

        public Builder(String titulo, String autor) {
            this.titulo = titulo;
            this.autor = autor;
        }

        public Builder setAnoPublicacion(int anoPublicacion) {
            this.anoPublicacion = anoPublicacion;
            return this;
        }

        public Builder setGenero(String genero) {
            this.genero = genero;
            return this;
        }

        public Builder setNumeroPaginas(int numeroPaginas) {
            this.numeroPaginas = numeroPaginas;
            return this;
        }

        public Builder setEstadoPrestamo(EstadoPrestamo estadoPrestamo) {
            this.estadoPrestamo = estadoPrestamo;
            return this;
        }

        public Builder setNumeroCapitulos(int numeroCapitulos) {
            this.numeroCapitulos = numeroCapitulos;
            return this;
        }

        public Builder setFechaLiberacion(String fechaLiberacion) {
            this.fechaLiberacion = fechaLiberacion;
            return this;
        }

        public Libro build() {
            return new Libro(this);
        }
    }
}

 
