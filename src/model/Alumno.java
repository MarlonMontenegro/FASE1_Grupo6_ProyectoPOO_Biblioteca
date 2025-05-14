package model;

import javax.swing.*;

public class Alumno extends Usuario {

    public Alumno(int id, String usuario, String contrasena, RolUsuario rol) {
        super(id, usuario, contrasena, rol);
    }

    @Override
    public void redirect() {
            //TODO: Agregar la vista
    }
}
