package model;

public class PrestamoDetalle {

    private int idDetalle;
    private int idPrestamo;
    private String idMaterial;
    private int cantidad;
    private boolean devuelto;


    public PrestamoDetalle() {
    }


    public PrestamoDetalle(int idPrestamo, String idMaterial, int cantidad, boolean devuelto) {
        this.idPrestamo = idPrestamo;
        this.idMaterial = idMaterial;
        this.cantidad = cantidad;
        this.devuelto = devuelto;
    }


    public PrestamoDetalle(int idDetalle, int idPrestamo, String idMaterial, int cantidad, boolean devuelto) {
        this.idDetalle = idDetalle;
        this.idPrestamo = idPrestamo;
        this.idMaterial = idMaterial;
        this.cantidad = cantidad;
        this.devuelto = devuelto;
    }


    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public String getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(String idMaterial) {
        this.idMaterial = idMaterial;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero.");
        }
        this.cantidad = cantidad;
    }

    public boolean isDevuelto() {
        return devuelto;
    }

    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }
}
