package src.view;

import javax.swing.*;
import src.controllers.LibroController;
import src.controllers.CDController;
import src.controllers.DVDController;
import src.controllers.RevistaController;
import src.model.Libro;
import src.model.CDdeAudio;
import src.model.DVD;
import src.model.Revista;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MediatecaView {
    private static final Logger logger = LogManager.getLogger(MediatecaView.class);

    private final JFrame frame;
    private final JTabbedPane tabbedPane;

    // Controladores
    private final LibroController libroController;
    private final CDController cdController;
    private final DVDController dvdController;
    private final RevistaController revistaController;

    public MediatecaView() {
        // Inicializar DAOs y Controladores
        libroController = new LibroController();
        cdController = new CDController();
        dvdController = new DVDController();
        revistaController = new RevistaController();

        // Configurar la ventana
        frame = new JFrame("Gestión de Mediateca");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Crear el JTabbedPane
        tabbedPane = new JTabbedPane();
        frame.add(tabbedPane);

        // Agregar pestañas
        tabbedPane.addTab("Libros", createLibroPanel());
        tabbedPane.addTab("CDs", createCDPanel());
        tabbedPane.addTab("DVDs", createDVDPanel());
        tabbedPane.addTab("Revistas", createRevistaPanel());

        frame.setVisible(true);
    }

    private JPanel createLibroPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Campos para libros
        JLabel titleLabel = new JLabel("Título:");
        titleLabel.setBounds(10, 20, 80, 25);
        panel.add(titleLabel);

        JTextField titleText = new JTextField(20);
        titleText.setBounds(100, 20, 165, 25);
        panel.add(titleText);

        JLabel authorLabel = new JLabel("Autor:");
        authorLabel.setBounds(10, 60, 80, 25);
        panel.add(authorLabel);

        JTextField authorText = new JTextField(20);
        authorText.setBounds(100, 60, 165, 25);
        panel.add(authorText);

        JLabel pagesLabel = new JLabel("Páginas:");
        pagesLabel.setBounds(10, 100, 80, 25);
        panel.add(pagesLabel);

        JTextField pagesText = new JTextField(20);
        pagesText.setBounds(100, 100, 165, 25);
        panel.add(pagesText);

        JLabel editorialLabel = new JLabel("Editorial:");
        editorialLabel.setBounds(10, 140, 80, 25);
        panel.add(editorialLabel);

        JTextField editorialText = new JTextField(20);
        editorialText.setBounds(100, 140, 165, 25);
        panel.add(editorialText);

        JLabel unitsLabel = new JLabel("Unidades:");
        unitsLabel.setBounds(10, 180, 80, 25);
        panel.add(unitsLabel);

        JTextField unitsText = new JTextField(20);
        unitsText.setBounds(100, 180, 165, 25);
        panel.add(unitsText);

        // ID para buscar y modificar
        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(10, 220, 80, 25);
        panel.add(idLabel);

        JTextField idText = new JTextField(20);
        idText.setBounds(100, 220, 165, 25);
        panel.add(idText);

        // Botones para libros
        JButton addButton = new JButton("Agregar");
        addButton.setBounds(10, 260, 150, 25);
        panel.add(addButton);

        addButton.addActionListener(e -> {
            String title = titleText.getText();
            String author = authorText.getText();
            int units = Integer.parseInt(unitsText.getText());
            int pages = Integer.parseInt(pagesText.getText());
            String editorial = editorialText.getText();

            if (!title.isEmpty() && !author.isEmpty()) {
                Libro libro = new Libro();
                libro.setTitulo(title);
                libro.setAutor(author);
                libro.setUnidadesDisponibles(units);
                libro.setNumeroPaginas(pages);
                libro.setEditorial(editorial);
                libroController.agregarLibro(libro);
                logger.info("Libro agregado: " + title);
                JOptionPane.showMessageDialog(frame, "Libro agregado exitosamente.");
            } else {
                logger.error("Error: Faltan datos para agregar el libro.");
                JOptionPane.showMessageDialog(frame, "Error: Faltan datos para agregar el libro.");
            }
        });

        JButton modifyButton = new JButton("Modificar");
        modifyButton.setBounds(170, 260, 150, 25);
        panel.add(modifyButton);

        modifyButton.addActionListener(e -> {
            String id = idText.getText();
            String title = titleText.getText();
            String author = authorText.getText();
            int units = Integer.parseInt(unitsText.getText());
            int pages = Integer.parseInt(pagesText.getText());
            String editorial = editorialText.getText();

            if (!id.isEmpty() && !title.isEmpty() && !author.isEmpty()) {
                Libro libro = new Libro();
                libro.setCodigoIdentificacion(id);
                libro.setTitulo(title);
                libro.setAutor(author);
                libro.setUnidadesDisponibles(units);
                libro.setNumeroPaginas(pages);
                libro.setEditorial(editorial);
                libroController.actualizarLibro(libro);
                logger.info("Libro modificado: " + title);
                JOptionPane.showMessageDialog(frame, "Libro modificado exitosamente.");
            } else {
                logger.error("Error: Faltan datos para modificar el libro.");
                JOptionPane.showMessageDialog(frame, "Error: Faltan datos para modificar el libro.");
            }
        });

        JButton listButton = new JButton("Listar");
        listButton.setBounds(10, 300, 150, 25);
        panel.add(listButton);

        listButton.addActionListener(e -> listarMateriales());

        JButton searchButton = new JButton("Buscar");
        searchButton.setBounds(170, 300, 150, 25);
        panel.add(searchButton);

        searchButton.addActionListener(e -> buscarMaterial(idText.getText()));

        JButton deleteButton = new JButton("Eliminar");
        deleteButton.setBounds(10, 340, 150, 25);
        panel.add(deleteButton);

        deleteButton.addActionListener(e -> eliminarMaterial(idText.getText()));

        return panel;
    }

    private JPanel createCDPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Campos para CDs
        JLabel titleLabel = new JLabel("Título:");
        titleLabel.setBounds(10, 20, 80, 25);
        panel.add(titleLabel);

        JTextField titleText = new JTextField(20);
        titleText.setBounds(100, 20, 165, 25);
        panel.add(titleText);

        JLabel artistLabel = new JLabel("Artista:");
        artistLabel.setBounds(10, 60, 80, 25);
        panel.add(artistLabel);

        JTextField artistText = new JTextField(20);
        artistText.setBounds(100, 60, 165, 25);
        panel.add(artistText);

        JLabel durationLabel = new JLabel("Duración:");
        durationLabel.setBounds(10, 100, 80, 25);
        panel.add(durationLabel);

        JTextField durationText = new JTextField(20);
        durationText.setBounds(100, 100, 165, 25);
        panel.add(durationText);

        JLabel unitsLabel = new JLabel("Unidades:");
        unitsLabel.setBounds(10, 140, 80, 25);
        panel.add(unitsLabel);

        JTextField unitsText = new JTextField(20);
        unitsText.setBounds(100, 140, 165, 25);
        panel.add(unitsText);

        // ID para buscar y modificar
        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(10, 180, 80, 25);
        panel.add(idLabel);

        JTextField idText = new JTextField(20);
        idText.setBounds(100, 180, 165, 25);
        panel.add(idText);

        // Botones para CDs
        JButton addButton = new JButton("Agregar");
        addButton.setBounds(10, 220, 150, 25);
        panel.add(addButton);

        addButton.addActionListener(e -> {
            String title = titleText.getText();
            String artist = artistText.getText();
            int units = Integer.parseInt(unitsText.getText());
            String duration = durationText.getText();

            if (!title.isEmpty() && !artist.isEmpty()) {
                CDdeAudio cd = new CDdeAudio();
                cd.setTitulo(title);
                cd.setArtista(artist);
                cd.setUnidadesDisponibles(units);
                cd.setDuracion(duration);
                cdController.agregarCD(cd);
                logger.info("CD agregado: " + title);
                JOptionPane.showMessageDialog(frame, "CD agregado exitosamente.");
            } else {
                logger.error("Error: Faltan datos para agregar el CD.");
                JOptionPane.showMessageDialog(frame, "Error: Faltan datos para agregar el CD.");
            }
        });

        JButton modifyButton = new JButton("Modificar");
        modifyButton.setBounds(170, 220, 150, 25);
        panel.add(modifyButton);

        modifyButton.addActionListener(e -> {
            String id = idText.getText();
            String title = titleText.getText();
            String artist = artistText.getText();
            int units = Integer.parseInt(unitsText.getText());
            String duration = durationText.getText();

            if (!id.isEmpty() && !title.isEmpty() && !artist.isEmpty()) {
                CDdeAudio cd = new CDdeAudio();
                cd.setCodigoIdentificacion(id);
                cd.setTitulo(title);
                cd.setArtista(artist);
                cd.setUnidadesDisponibles(units);
                cd.setDuracion(duration);
                cdController.actualizarCD(cd);
                logger.info("CD modificado: " + title);
                JOptionPane.showMessageDialog(frame, "CD modificado exitosamente.");
            } else {
                logger.error("Error: Faltan datos para modificar el CD.");
                JOptionPane.showMessageDialog(frame, "Error: Faltan datos para modificar el CD.");
            }
        });

        JButton listButton = new JButton("Listar");
        listButton.setBounds(10, 260, 150, 25);
        panel.add(listButton);

        listButton.addActionListener(e -> listarMateriales());

        JButton searchButton = new JButton("Buscar");
        searchButton.setBounds(170, 260, 150, 25);
        panel.add(searchButton);

        searchButton.addActionListener(e -> buscarMaterial(idText.getText()));

        JButton deleteButton = new JButton("Eliminar");
        deleteButton.setBounds(10, 300, 150, 25);
        panel.add(deleteButton);

        deleteButton.addActionListener(e -> eliminarMaterial(idText.getText()));

        return panel;
    }

    private JPanel createDVDPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Campos para DVDs
        JLabel titleLabel = new JLabel("Título:");
        titleLabel.setBounds(10, 20, 80, 25);
        panel.add(titleLabel);

        JTextField titleText = new JTextField(20);
        titleText.setBounds(100, 20, 165, 25);
        panel.add(titleText);

        JLabel directorLabel = new JLabel("Director:");
        directorLabel.setBounds(10, 60, 80, 25);
        panel.add(directorLabel);

        JTextField directorText = new JTextField(20);
        directorText.setBounds(100, 60, 165, 25);
        panel.add(directorText);

        JLabel durationLabel = new JLabel("Duración:");
        durationLabel.setBounds(10, 100, 80, 25);
        panel.add(durationLabel);

        JTextField durationText = new JTextField(20);
        durationText.setBounds(100, 100, 165, 25);
        panel.add(durationText);

        JLabel unitsLabel = new JLabel("Unidades:");
        unitsLabel.setBounds(10, 140, 80, 25);
        panel.add(unitsLabel);

        JTextField unitsText = new JTextField(20);
        unitsText.setBounds(100, 140, 165, 25);
        panel.add(unitsText);

        // ID para buscar y modificar
        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(10, 180, 80, 25);
        panel.add(idLabel);

        JTextField idText = new JTextField(20);
        idText.setBounds(100, 180, 165, 25);
        panel.add(idText);

        // Botones para DVDs
        JButton addButton = new JButton("Agregar");
        addButton.setBounds(10, 220, 150, 25);
        panel.add(addButton);

        addButton.addActionListener(e -> {
            String title = titleText.getText();
            String director = directorText.getText();
            int units = Integer.parseInt(unitsText.getText());
            String duration = durationText.getText();

            if (!title.isEmpty() && !director.isEmpty()) {
                DVD dvd = new DVD();
                dvd.setTitulo(title);
                dvd.setDirector(director);
                dvd.setUnidadesDisponibles(units);
                dvd.setDuracion(duration);
                dvdController.agregarDVD(dvd);
                logger.info("DVD agregado: " + title);
                JOptionPane.showMessageDialog(frame, "DVD agregado exitosamente.");
            } else {
                logger.error("Error: Faltan datos para agregar el DVD.");
                JOptionPane.showMessageDialog(frame, "Error: Faltan datos para agregar el DVD.");
            }
        });

        JButton modifyButton = new JButton("Modificar");
        modifyButton.setBounds(170, 220, 150, 25);
        panel.add(modifyButton);

        modifyButton.addActionListener(e -> {
            String id = idText.getText();
            String title = titleText.getText();
            String director = directorText.getText();
            int units = Integer.parseInt(unitsText.getText());
            String duration = durationText.getText();

            if (!id.isEmpty() && !title.isEmpty() && !director.isEmpty()) {
                DVD dvd = new DVD();
                dvd.setCodigoIdentificacion(id);
                dvd.setTitulo(title);
                dvd.setDirector(director);
                dvd.setUnidadesDisponibles(units);
                dvd.setDuracion(duration);
                dvdController.actualizarDVD(dvd);
                logger.info("DVD modificado: " + title);
                JOptionPane.showMessageDialog(frame, "DVD modificado exitosamente.");
            } else {
                logger.error("Error: Faltan datos para modificar el DVD.");
                JOptionPane.showMessageDialog(frame, "Error: Faltan datos para modificar el DVD.");
            }
        });

        JButton listButton = new JButton("Listar");
        listButton.setBounds(10, 260, 150, 25);
        panel.add(listButton);

        listButton.addActionListener(e -> listarMateriales());

        JButton searchButton = new JButton("Buscar");
        searchButton.setBounds(170, 260, 150, 25);
        panel.add(searchButton);

        searchButton.addActionListener(e -> buscarMaterial(idText.getText()));

        JButton deleteButton = new JButton("Eliminar");
        deleteButton.setBounds(10, 300, 150, 25);
        panel.add(deleteButton);

        deleteButton.addActionListener(e -> eliminarMaterial(idText.getText()));

        return panel;
    }

    private JPanel createRevistaPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Campos para revistas
        JLabel titleLabel = new JLabel("Título:");
        titleLabel.setBounds(10, 20, 80, 25);
        panel.add(titleLabel);

        JTextField titleText = new JTextField(20);
        titleText.setBounds(100, 20, 165, 25);
        panel.add(titleText);

        JLabel editorialLabel = new JLabel("Editorial:");
        editorialLabel.setBounds(10, 60, 80, 25);
        panel.add(editorialLabel);

        JTextField editorialText = new JTextField(20);
        editorialText.setBounds(100, 60, 165, 25);
        panel.add(editorialText);

        JLabel periodicityLabel = new JLabel("Periodicidad:");
        periodicityLabel.setBounds(10, 100, 100, 25);
        panel.add(periodicityLabel);

        JTextField periodicityText = new JTextField(20);
        periodicityText.setBounds(120, 100, 165, 25);
        panel.add(periodicityText);

        JLabel publicationDateLabel = new JLabel("Fecha Pub:");
        publicationDateLabel.setBounds(10, 140, 100, 25);
        panel.add(publicationDateLabel);

        JTextField publicationDateText = new JTextField(20);
        publicationDateText.setBounds(120, 140, 165, 25);
        panel.add(publicationDateText);

        JLabel unitsLabel = new JLabel("Unidades:");
        unitsLabel.setBounds(10, 180, 80, 25);
        panel.add(unitsLabel);

        JTextField unitsText = new JTextField(20);
        unitsText.setBounds(100, 180, 165, 25);
        panel.add(unitsText);

        // ID para buscar y modificar
        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(10, 220, 80, 25);
        panel.add(idLabel);

        JTextField idText = new JTextField(20);
        idText.setBounds(100, 220, 165, 25);
        panel.add(idText);

        // Botones para revistas
        JButton addButton = new JButton("Agregar");
        addButton.setBounds(10, 260, 150, 25);
        panel.add(addButton);

        addButton.addActionListener(e -> {
            String title = titleText.getText();
            String editorial = editorialText.getText();
            String periodicity = periodicityText.getText();
            String publicationDate = publicationDateText.getText();
            int units = Integer.parseInt(unitsText.getText());

            if (!title.isEmpty() && !editorial.isEmpty() && !periodicity.isEmpty()) {
                Revista revista = new Revista();
                revista.setTitulo(title);
                revista.setEditorial(editorial);
                revista.setPeriodicidad(periodicity);
                revista.setUnidadesDisponibles(units);
                revista.setFechaPublicacion(publicationDate);
                revistaController.agregarRevista(revista);
                logger.info("Revista agregada: " + title);
                JOptionPane.showMessageDialog(frame, "Revista agregada exitosamente.");
            } else {
                logger.error("Error: Faltan datos para agregar la revista.");
                JOptionPane.showMessageDialog(frame, "Error: Faltan datos para agregar la revista.");
            }
        });

        JButton modifyButton = new JButton("Modificar");
        modifyButton.setBounds(170, 260, 150, 25);
        panel.add(modifyButton);

        modifyButton.addActionListener(e -> {
            String id = idText.getText();
            String title = titleText.getText();
            String editorial = editorialText.getText();
            String periodicity = periodicityText.getText();
            String publicationDate = publicationDateText.getText();
            int units = Integer.parseInt(unitsText.getText());

            if (!id.isEmpty() && !title.isEmpty() && !editorial.isEmpty() && !periodicity.isEmpty()) {
                Revista revista = new Revista();
                revista.setCodigoIdentificacion(id);
                revista.setTitulo(title);
                revista.setEditorial(editorial);
                revista.setPeriodicidad(periodicity);
                revista.setUnidadesDisponibles(units);
                revista.setFechaPublicacion(publicationDate);
                revistaController.actualizarRevista(revista);
                logger.info("Revista modificada: " + title);
                JOptionPane.showMessageDialog(frame, "Revista modificada exitosamente.");
            } else {
                logger.error("Error: Faltan datos para modificar la revista.");
                JOptionPane.showMessageDialog(frame, "Error: Faltan datos para modificar la revista.");
            }
        });

        JButton listButton = new JButton("Listar");
        listButton.setBounds(10, 300, 150, 25);
        panel.add(listButton);

        listButton.addActionListener(e -> listarMateriales());

        JButton searchButton = new JButton("Buscar");
        searchButton.setBounds(170, 300, 150, 25);
        panel.add(searchButton);

        searchButton.addActionListener(e -> buscarMaterial(idText.getText()));

        JButton deleteButton = new JButton("Eliminar");
        deleteButton.setBounds(10, 340, 150, 25);
        panel.add(deleteButton);

        deleteButton.addActionListener(e -> eliminarMaterial(idText.getText()));

        return panel;
    }

    private void listarMateriales() {
        // Listar libros
        List<Libro> libros = libroController.listarTodosLoslibros();
        StringBuilder libroList = new StringBuilder("Libros:\n");
        for (Libro libro : libros) {
            libroList.append(libro.getTitulo()).append(" - ").append(libro.getAutor()).append("\n");
        }

        // Listar CDs
        List<CDdeAudio> cds = cdController.listarTodosLosCDs();
        StringBuilder cdList = new StringBuilder("CDs:\n");
        for (CDdeAudio cd : cds) {
            cdList.append(cd.getTitulo()).append(" - ").append(cd.getArtista()).append("\n");
        }

        // Listar DVDs
        List<DVD> dvds = dvdController.listarTodosLosDVDs();
        StringBuilder dvdList = new StringBuilder("DVDs:\n");
        for (DVD dvd : dvds) {
            dvdList.append(dvd.getTitulo()).append(" - ").append(dvd.getDirector()).append("\n");
        }

        // Listar revistas
        List<Revista> revistas = revistaController.listarTodosLasRevistas();
        StringBuilder revistaList = new StringBuilder("Revistas:\n");
        for (Revista revista : revistas) {
            revistaList.append(revista.getTitulo()).append(" - ").append(revista.getEditorial()).append("\n");
        }

        // Mostrar todos los materiales
        JOptionPane.showMessageDialog(frame, libroList.toString() + "\n" + cdList.toString() + "\n" + dvdList.toString() + "\n" + revistaList.toString());
    }

    private void buscarMaterial(String id) {
        if (!id.isEmpty()) {
            // Buscar libro
            Libro libro = libroController.buscarLibroPorID(id);
            if (libro != null) {
                JOptionPane.showMessageDialog(frame, "Libro encontrado: " + libro.getTitulo());
                return;
            }

            // Buscar CD
            CDdeAudio cd = cdController.buscarCDPorID(id);
            if (cd != null) {
                JOptionPane.showMessageDialog(frame, "CD encontrado: " + cd.getTitulo());
                return;
            }

            // Buscar DVD
            DVD dvd = dvdController.buscarDVDPorID(id);
            if (dvd != null) {
                JOptionPane.showMessageDialog(frame, "DVD encontrado: " + dvd.getTitulo());
                return;
            }

            // Buscar revista
            Revista revista = revistaController.buscarRevistaPorID(id);
            if (revista != null) {
                JOptionPane.showMessageDialog(frame, "Revista encontrada: " + revista.getTitulo());
                return;
            }

            JOptionPane.showMessageDialog(frame, "Material no encontrado con ID: " + id);
        } else {
            JOptionPane.showMessageDialog(frame, "Error: El ID no puede estar vacío.");
        }
    }

    private void eliminarMaterial(String id) {
        if (!id.isEmpty()) {
            // Eliminar libro
            if (libroController.eliminarLibro(Integer.parseInt(id))) {
                JOptionPane.showMessageDialog(frame, "Libro eliminado con ID: " + id);
                return;
            }

            // Eliminar CD
            if (cdController.eliminarCD(Integer.parseInt(id))) {
                JOptionPane.showMessageDialog(frame, "CD eliminado con ID: " + id);
                return;
            }

            // Eliminar DVD
            if (dvdController.eliminarDVD(Integer.parseInt(id))) {
                JOptionPane.showMessageDialog(frame, "DVD eliminado con ID: " + id);
                return;
            }

            // Eliminar revista
            if (revistaController.eliminarRevista(Integer.parseInt(id))) {
                JOptionPane.showMessageDialog(frame, "Revista eliminada con ID: " + id);
                return;
            }

            JOptionPane.showMessageDialog(frame, "Material no encontrado con ID: " + id);
        } else {
            JOptionPane.showMessageDialog(frame, "Error: El ID no puede estar vacío.");
        }
    }

    public static void main(String[] args) {
        new MediatecaView();
    }
}