package src.model;

public class CDdeAudio extends MaterialAudiovisual{
    private String artista;
    private int numeroCanciones;
    private int unidadesDisponibles;

    public CDdeAudio() {
    }

    public CDdeAudio(String codigoIdentificacion, String titulo, String genero, String duracion, String artista, int numeroCanciones, int unidadesDisponibles) {
        super(codigoIdentificacion, titulo, genero, duracion);
        this.artista = artista;
        this.numeroCanciones = numeroCanciones;
        this.unidadesDisponibles = unidadesDisponibles;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getNumeroCanciones() {
        return numeroCanciones;
    }

    public void setNumeroCanciones(int numeroCanciones) {
        this.numeroCanciones = numeroCanciones;
    }

    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    public void setUnidadesDisponibles(int unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }
    @Override
    public String generarCodigo() {
        return "CDA" + String.format("%05d", (int) (Math.random() * 100000));
    }
}
