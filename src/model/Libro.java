package src.model;

public class Libro extends MaterialEscirto {

    private String autor;
    private int numeroPaginas;
    private String isbn;
    private String anioPublicacion;


    public Libro() {
    }


    public Libro(String codigoIdentificacion, String titulo, String editorial, int unidadesDisponibles, String autor, int numeroPaginas, String isbn, String anioPublicacion) {
        super(codigoIdentificacion, titulo, editorial, unidadesDisponibles);
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.anioPublicacion = anioPublicacion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(String anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    @Override
    public String generarCodigo() {
        return "LIB" + String.format("%05d", (int) (Math.random() * 100000));
    }

}
