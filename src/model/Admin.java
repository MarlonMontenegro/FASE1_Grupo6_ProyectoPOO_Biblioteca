package model;

import view.AdminView;

import javax.swing.*;

public class Admin extends Usuario {

    public Admin(int id, String usuario, String contrasena, RolUsuario rol) {
        super(id, usuario, contrasena, rol);
    }

    @Override
    public void redirect() {
        new AdminView().setVisible(true);
    }
}
