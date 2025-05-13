package model;

import view.AdminView;

import javax.swing.*;

public class Admin extends Usuario {

    public Admin(int id, String usuario, String contrasena, RolUsuario rol) {
        super(id, usuario, contrasena, rol);
    }

    @Override
    public void redirect(JFrame ventana) {
        new AdminView(); // Abre la vista del panel de administración
        if (ventana != null) {
            ventana.dispose(); // Cierra la ventana anterior (login)
        }
    }
}
