package controllers;

import dao.LoginDAO;
import model.Usuario;

public class LoginController {

    private final LoginDAO loginDAO = new LoginDAO();

    public void iniciarSesion(String usuarioInput, String contrasenaInput) {

        Usuario usuario = loginDAO.buscarPorUsuario(usuarioInput);

        if (usuario == null) {
            System.out.println("Usuario no encontrado o desactivado");
            return;
        }

        if (!loginDAO.validarCredenciales(contrasenaInput, usuario)) {
            System.out.println("Contraseña incorrecta");
            return;
        }

        usuario.redirect();
    }

}
