package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AdminView extends JFrame {

    private JTable tablaUsuarios;
    private JTextField campoBusqueda;
    private JButton btnAgregar;

    public AdminView() {
        setTitle("Panel de Usuarios");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(20, 20));

        // ======= Panel superior con título =======
        JLabel lblTitulo = new JLabel("Panel de Usuarios");
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 20));
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 0));

        // ======= Panel de búsqueda y botón =======
        JPanel panelSuperior = new JPanel(new BorderLayout(10, 10));
        campoBusqueda = new JTextField("Buscar usuarios...");
        btnAgregar = new JButton("Agregar Usuario");
        btnAgregar.setBackground(Color.BLACK);
        btnAgregar.setForeground(Color.WHITE);
        btnAgregar.setFocusPainted(false);

        panelSuperior.add(campoBusqueda, BorderLayout.CENTER);
        panelSuperior.add(btnAgregar, BorderLayout.EAST);
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));

        // ======= Tabla de usuarios =======
        String[] columnas = {"Usuario", "Rol", "Estado", "Acciones"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 2 || column == 3; // Solo Estado y Acciones editables
            }
        };

        tablaUsuarios = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tablaUsuarios);
        scroll.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));

        // ======= Agregar datos de prueba =======
        modelo.addRow(new Object[]{"Alex Johnson", "Admin", "Activo", "..."});
        modelo.addRow(new Object[]{"Sarah Williams", "Editor", "Activo", "..."});
        modelo.addRow(new Object[]{"Michael Brown", "Viewer", "Inactivo", "..."});

        // ======= Ensamblar layout =======
        add(lblTitulo, BorderLayout.NORTH);
        add(panelSuperior, BorderLayout.PAGE_START);
        add(scroll, BorderLayout.CENTER);

        setVisible(true);
    }
}