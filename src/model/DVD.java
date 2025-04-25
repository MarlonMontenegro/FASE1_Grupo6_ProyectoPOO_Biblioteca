package src.model;

public class DVD extends MaterialAudiovisual{
    private int director;

    public DVD() {
    }

    public DVD(String codigoIdentificacion, String titulo, String genero, String duracion, int director) {
        super(codigoIdentificacion, titulo, genero, duracion);
        this.director = director;
    }

    public int getDirector() {


        return director;
    }

    public void setDirector(int director) {
        this.director = director;
    }

    @Override
    public String generarCodigo() {
        return "DVD" + String.format("%05d", (int) (Math.random() * 100000));
    }
}
