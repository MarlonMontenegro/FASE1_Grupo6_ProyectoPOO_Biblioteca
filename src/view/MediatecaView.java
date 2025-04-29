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

import java.util.List;

public class MediatecaView {
    private static final Logger logger = LogManager.getLogger(MediatecaView.class);
    
    private final JFrame frame;
    private JTextField titleText;
    private JTextField authorText; // Para libros
    private JTextField artistText; // Para CDs
    private JTextField directorText; // Para DVDs
    private JTextField editorialText; // Para revistas
    private JTextField unitsText;
    private JTextField durationText; // Para CDs y DVDs
    private JTextField pagesText; // Para libros
    private JTextField periodicityText; // Para revistas
    private JTextField publicationDateText; // Para revistas
    private JTextField idText; // Para buscar y eliminar por ID

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
        
        // Panel principal
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        
        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);
        
        // Agregar Material
        JLabel titleLabel = new JLabel("Título:");
        titleLabel.setBounds(10, 20, 80, 25);
        panel.add(titleLabel);
        
        titleText = new JTextField(20);
        titleText.setBounds(100, 20, 165, 25);
        panel.add(titleText);
        
        // Campos adicionales para libros, CDs, DVDs y revistas
        // Autor (para libros)
        JLabel authorLabel = new JLabel("Autor:");
        authorLabel.setBounds(10, 60, 80, 25);
        panel.add(authorLabel);
        
        authorText = new JTextField(20);
        authorText.setBounds(100, 60, 165, 25);
        panel.add(authorText);
        
        // Artista (para CDs)
        JLabel artistLabel = new JLabel("Artista:");
        artistLabel.setBounds(10, 100, 80, 25);
        panel.add(artistLabel);
        
        artistText = new JTextField(20);
        artistText.setBounds(100, 100, 165, 25);
        panel.add(artistText);
        
        // Director (para DVDs)
        JLabel directorLabel = new JLabel("Director:");
        directorLabel.setBounds(10, 140, 80, 25);
        panel.add(directorLabel);
        
        directorText = new JTextField(20);
        directorText.setBounds(100, 140, 165, 25);
        panel.add(directorText);
        
        // Editorial (para revistas)
        JLabel editorialLabel = new JLabel("Editorial:");
        editorialLabel.setBounds(10, 180, 80, 25);
        panel.add(editorialLabel);
        
        editorialText = new JTextField(20);
        editorialText.setBounds(100, 180, 165, 25);
        panel.add(editorialText);
        
        // Unidades disponibles
        JLabel unitsLabel = new JLabel("Unidades:");
        unitsLabel.setBounds(10, 220, 80, 25);
        panel.add(unitsLabel);
        
        unitsText = new JTextField(20);
        unitsText.setBounds(100, 220, 165, 25);
        panel.add(unitsText);
        
        // Duración (para CDs y DVDs)
        JLabel durationLabel = new JLabel("Duración:");
        durationLabel.setBounds(10, 260, 80, 25);
        panel.add(durationLabel);
        
        durationText = new JTextField(20);
        durationText.setBounds(100, 260, 165, 25);
        panel.add(durationText);
        
        // Número de páginas (para libros)
        JLabel pagesLabel = new JLabel("Páginas:");
        pagesLabel.setBounds(10, 300, 80, 25);
        panel.add(pagesLabel);
        
        pagesText = new JTextField(20);
        pagesText.setBounds(100, 300, 165, 25);
        panel.add(pagesText);
        
        // Periodicidad (para revistas)
        JLabel periodicityLabel = new JLabel("Periodicidad:");
        periodicityLabel.setBounds(10, 340, 100, 25);
        panel.add(periodicityLabel);
        
        periodicityText = new JTextField(20);
        periodicityText.setBounds(120, 340, 165, 25);
        panel.add(periodicityText);
        
        // Fecha de publicación (para revistas)
        JLabel publicationDateLabel = new JLabel("Fecha Pub:");
        publicationDateLabel.setBounds(10, 380, 100, 25);
        panel.add(publicationDateLabel);
        
        publicationDateText = new JTextField(20);
        publicationDateText.setBounds(120, 380, 165, 25);
        panel.add(publicationDateText);
        
        // ID para buscar y eliminar
        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(10, 420, 80, 25);
        panel.add(idLabel);
        
        idText = new JTextField(20);
        idText.setBounds(100, 420, 165, 25);
        panel.add(idText);
        
        // Botón Agregar
        JButton addButton = new JButton("Agregar");
        addButton.setBounds(10, 460, 150, 25);
        panel.add(addButton);
        
        addButton.addActionListener(e -> agregarMaterial());
        
        // Botón Modificar
        JButton modifyButton = new JButton("Modificar");
        modifyButton.setBounds(170, 460, 150, 25);
        panel.add(modifyButton);
        
        modifyButton.addActionListener(e -> modificarMaterial());
        
        // Botón Listar
        JButton listButton = new JButton("Listar");
        listButton.setBounds(330, 460, 150, 25);
        panel.add(listButton);
        
        listButton.addActionListener(e -> listarMateriales());
        
        // Botón Buscar
        JButton searchButton = new JButton("Buscar");
        searchButton.setBounds(490, 460, 150, 25);
        panel.add(searchButton);
        
        searchButton.addActionListener(e -> buscarMaterial());
        
        // Botón Eliminar
        JButton deleteButton = new JButton("Eliminar");
        deleteButton.setBounds(650, 460, 150, 25);
        panel.add(deleteButton);
        
        deleteButton.addActionListener(e -> eliminarMaterial());
    }

    private void agregarMaterial() {
        String title = titleText.getText();
        String author = authorText.getText();
        String artist = artistText.getText();
        String director = directorText.getText();
        String editorial = editorialText.getText();
        int units = Integer.parseInt(unitsText.getText());
        String duration = durationText.getText();
        int pages = Integer.parseInt(pagesText.getText());
        String periodicity = periodicityText.getText();
        String publicationDate = publicationDateText.getText();

        // Ejemplo para agregar un libro
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
        }
        // Ejemplo para agregar un CD
        else if (!title.isEmpty() && !artist.isEmpty()) {
            CDdeAudio cd = new CDdeAudio();
            cd.setTitulo(title);
            cd.setArtista(artist);
            cd.setUnidadesDisponibles(units);
            cd.setDuracion(duration);
            cdController.agregarCD(cd);
            logger.info("CD agregado: " + title);
            JOptionPane.showMessageDialog(frame, "CD agregado exitosamente.");
        }
        // Ejemplo para agregar un DVD
        else if (!title.isEmpty() && !director.isEmpty()) {
            DVD dvd = new DVD();
            dvd.setTitulo(title);
            dvd.setDirector(director);
            dvd.setUnidadesDisponibles(units);
            dvd.setDuracion(duration);
            dvdController.agregarDVD(dvd);
            logger.info("DVD agregado: " + title);
            JOptionPane.showMessageDialog(frame, "DVD agregado exitosamente.");
        }
        // Ejemplo para agregar una revista
        else if (!title.isEmpty() && !editorial.isEmpty() && !periodicity.isEmpty()) {
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
            logger.error("Error: Faltan datos para agregar el material.");
            JOptionPane.showMessageDialog(frame, "Error: Faltan datos para agregar el material.");
        }
    }

    private void modificarMaterial() {
        String id = idText.getText();
        String title = titleText.getText();
        String author = authorText.getText();
        String artist = artistText.getText();
        String director = directorText.getText();
        String editorial = editorialText.getText();
        int units = Integer.parseInt(unitsText.getText());
        String duration = durationText.getText();
        int pages = Integer.parseInt(pagesText.getText());
        String periodicity = periodicityText.getText();
        String publicationDate = publicationDateText.getText();

        // Ejemplo para modificar un libro
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
        }
        // Ejemplo para modificar un CD
        else if (!id.isEmpty() && !title.isEmpty() && !artist.isEmpty()) {
            CDdeAudio cd = new CDdeAudio();
            cd.setCodigoIdentificacion(id);
            cd.setTitulo(title);
            cd.setArtista(artist);
            cd.setUnidadesDisponibles(units);
            cd.setDuracion(duration);
            cdController.actualizarCD(cd);
            logger.info("CD modificado: " + title);
            JOptionPane.showMessageDialog(frame, "CD modificado exitosamente.");
        }
        // Ejemplo para modificar un DVD
        else if (!id.isEmpty() && !title.isEmpty() && !director.isEmpty()) {
            DVD dvd = new DVD();
            dvd.setCodigoIdentificacion(id);
            dvd.setTitulo(title);
            dvd.setDirector(director);
            dvd.setUnidadesDisponibles(units);
            dvd.setDuracion(duration);
            dvdController.actualizarDVD(dvd);
            logger.info("DVD modificado: " + title);
            JOptionPane.showMessageDialog(frame, "DVD modificado exitosamente.");
        }
        // Ejemplo para modificar una revista
        else if (!id.isEmpty() && !title.isEmpty() && !editorial.isEmpty() && !periodicity.isEmpty()) {
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
            logger.error("Error: Faltan datos para modificar el material.");
            JOptionPane.showMessageDialog(frame, "Error: Faltan datos para modificar el material.");
        }
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

    private void buscarMaterial() {
        String id = idText.getText();
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

    private void eliminarMaterial() {
        String id = idText.getText();
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
}