

package qantuw.listadeejercicio1;

public class Libro {
   private final String titulo;
    private final String autor;
    private final int anioPublicacion;
    private final String genero;
    private final int numeroPaginas;
    private final String estadoPrestamo;
    private final int numeroCapitulos;
    private final String fechaLiberacion;

    private Libro(BuilderLibro builder) {
        this.titulo = builder.titulo;
        this.autor = builder.autor;
        this.anioPublicacion = builder.anioPublicacion;
        this.genero = builder.genero;
        this.numeroPaginas = builder.numeroPaginas;
        this.estadoPrestamo = builder.estadoPrestamo;
        this.numeroCapitulos = builder.numeroCapitulos;
        this.fechaLiberacion = builder.fechaLiberacion;
    }

    public static class BuilderLibro {
        private String titulo;
        private String autor;
        private int anioPublicacion;
        private String genero;
        private int numeroPaginas;
        private String estadoPrestamo;
        private int numeroCapitulos;
        private String fechaLiberacion;

        // Métodos de configuración para cada atributo

        public BuilderLibro titulo(String titulo) {
            this.titulo = titulo;
            return this;
        }

        public BuilderLibro autor(String autor) {
            this.autor = autor;
            return this;
        }

        public BuilderLibro anioPublicacion(int anioPublicacion) {
            this.anioPublicacion = anioPublicacion;
            return this;
        }

        public BuilderLibro genero(String genero) {
            this.genero = genero;
            return this;
        }

        public BuilderLibro numeroPaginas(int numeroPaginas) {
            this.numeroPaginas = numeroPaginas;
            return this;
        }

        public BuilderLibro estadoPrestamo(String estadoPrestamo) {
            this.estadoPrestamo = estadoPrestamo;
            return this;
        }

        public BuilderLibro numeroCapitulos(int numeroCapitulos) {
            this.numeroCapitulos = numeroCapitulos;
            return this;
        }

        public BuilderLibro fechaLiberacion(String fechaLiberacion) {
            this.fechaLiberacion = fechaLiberacion;
            return this;
        }

        public Libro build() {
            return new Libro(this);
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public String getGenero() {
        return genero;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getEstadoPrestamo() {
        return estadoPrestamo;
    }

    public int getNumeroCapitulos() {
        return numeroCapitulos;
    }

    public String getFechaLiberacion() {
        return fechaLiberacion;
    }
    
    @Override
    public String toString() {
    return "Libro {" +
           "Título='" + titulo + '\'' +
           ", Autor='" + autor + '\'' +
           ", Año de Publicación=" + anioPublicacion +
           ", Género='" + genero + '\'' +
           ", Número de Páginas=" + numeroPaginas +
           ", Estado de Préstamo='" + estadoPrestamo + '\'' +
           ", Número de Capítulos=" + numeroCapitulos +
           ", Fecha de Liberación='" + fechaLiberacion + '\'' +
           '}';
}

 
}

 