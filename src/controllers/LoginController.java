package src.controllers;

import src.dao.LoginDAO;
import src.model.Usuario;

public class LoginController {

    private final LoginDAO loginDAO = new LoginDAO();

    public void iniciarSesion(String usuarioInput, String contrasenaInput) {
        Usuario usuario = loginDAO.buscarPorUsuario(usuarioInput);

        if (usuario == null) {
            // Aquí irá JOptionPane en tu GUI
            System.out.println("❌ Usuario no encontrado o desactivado");
            return;
        }

        if (!loginDAO.validarCredenciales(contrasenaInput, usuario)) {
            // Aquí también irá mensaje en pantalla
            System.out.println("❌ Contraseña incorrecta");
            return;
        }

        // ✅ Si todo está bien, redirigir al tipo de usuario correspondiente
        System.out.println("✅ Login exitoso. Rol: " + usuario.getRol());

        // Aquí luego colocarás el JFrame de tu formulario de login
        usuario.redirect(null); // ← luego pasas el JFrame actual cuando tengas la vista lista
    }

}
