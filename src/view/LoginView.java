package view;

import controllers.LoginController;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {

    private final LoginController loginController = new LoginController();

    public LoginView() {
        setTitle("Login");
        setSize(400, 320);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JLabel lblTitulo = new JLabel("Iniciar Sesión");
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 22));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        // Usuario
        JTextField txtUsuario = new JTextField();
        txtUsuario.setFont(new Font("SansSerif", Font.PLAIN, 16));
        txtUsuario.setPreferredSize(new Dimension(200, 40));
        txtUsuario.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));

        // Contraseña
        JPasswordField txtContrasena = new JPasswordField();
        txtContrasena.setFont(new Font("SansSerif", Font.PLAIN, 16));
        txtContrasena.setPreferredSize(new Dimension(200, 40));
        txtContrasena.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));

        // Botón ingresar
        JButton btnIngresar = new JButton("Ingresar");
        btnIngresar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnIngresar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        btnIngresar.setBackground(new Color(52, 103, 255));
        btnIngresar.setForeground(Color.WHITE);
        btnIngresar.setFont(new Font("SansSerif", Font.BOLD, 14));

        // Enlace olvidar contraseña
        JButton btnOlvidaste = new JButton("¿Olvidaste tu contraseña?");
        btnOlvidaste.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnOlvidaste.setBorderPainted(false);
        btnOlvidaste.setFocusPainted(false);
        btnOlvidaste.setContentAreaFilled(false);
        btnOlvidaste.setForeground(Color.BLUE);
        btnOlvidaste.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnOlvidaste.setFont(new Font("SansSerif", Font.PLAIN, 12));

        // Acción botón ingresar
        btnIngresar.addActionListener(e -> {
            String usuario = txtUsuario.getText();
            String contrasena = new String(txtContrasena.getPassword());

            try {
                loginController.iniciarSesion(usuario, contrasena);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        "Error al iniciar sesión: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Acción recuperar contraseña
        btnOlvidaste.addActionListener(e -> JOptionPane.showMessageDialog(
                this,
                "Contacta al administrador para recuperar tu contraseña.",
                "Recuperar contraseña",
                JOptionPane.INFORMATION_MESSAGE));

        // Agregar al panel
        panel.add(lblTitulo);
        panel.add(txtUsuario);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(txtContrasena);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(btnIngresar);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btnOlvidaste);

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }
}