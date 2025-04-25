package src.model;

public abstract class Material {
    protected String codigoIdentificacion;
    protected String titulo;

    public Material() {
    }

    public Material(String codigoIdentificacion, String titulo) {
        this.codigoIdentificacion = codigoIdentificacion;
        this.titulo = titulo;
    }

    public String getCodigoIdentificacion() {
        return codigoIdentificacion;
    }

    public void setCodigoIdentificacion(String codigoIdentificacion) {
        this.codigoIdentificacion = codigoIdentificacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public abstract String generarCodigo();
}
