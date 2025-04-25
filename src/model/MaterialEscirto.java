package src.model;

public abstract class MaterialEscirto extends Material {
    protected String editorial;
    protected int unidadesDisponibles;

    public MaterialEscirto() {
    }

    public MaterialEscirto(String codigoIdentificacion, String titulo, String editorial, int unidadesDisponibles) {
        super(codigoIdentificacion, titulo);
        this.editorial = editorial;
        this.unidadesDisponibles = unidadesDisponibles;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    public void setUnidadesDisponibles(int unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }


}


