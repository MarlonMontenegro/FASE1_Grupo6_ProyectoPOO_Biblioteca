package model;

import java.util.Calendar;
import java.util.Date;

public class Prestamo {

    private int idPrestamo;
    private int idUsuario;
    private Date fechaPrestamo;
    private Date fechaDevolucionEsperada;
    private Date fechaDevolucionReal;
    private final int DIAS_PRESTAMO = 6;

    public Prestamo() {
    }

    public Prestamo(int idPrestamo, int idUsuario, Date fechaPrestamo, Date fechaDevolucionReal) {
        this.idPrestamo = idPrestamo;
        this.idUsuario = idUsuario;
        this.fechaPrestamo = fechaPrestamo;
        calcularFechaDevolucionEsperada();
        this.fechaDevolucionReal = fechaDevolucionReal;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucionEsperada() {
        return fechaDevolucionEsperada;
    }

    public void setFechaDevolucionEsperada(Date fechaDevolucionEsperada) {
        this.fechaDevolucionEsperada = fechaDevolucionEsperada;
    }

    public Date getFechaDevolucionReal() {
        return fechaDevolucionReal;
    }

    public void setFechaDevolucionReal(Date fechaDevolucionReal) {
        this.fechaDevolucionReal = fechaDevolucionReal;
    }



    public void calcularFechaDevolucionEsperada() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaPrestamo);
        calendar.add(Calendar.DAY_OF_MONTH, DIAS_PRESTAMO);
        this.fechaDevolucionEsperada = calendar.getTime();
    }
}
