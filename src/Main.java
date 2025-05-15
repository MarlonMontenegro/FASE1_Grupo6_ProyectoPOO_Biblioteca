
import controllers.PrestamoController;
import model.Prestamo;

import java.util.Date;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        PrestamoController controller = new PrestamoController();

        // Crear préstamo
        Prestamo prestamo = new Prestamo();
        prestamo.setIdUsuario(1); // Asegúrate que este usuario exista
        prestamo.setIdMaterial("LIB00001"); // Asegúrate que este material exista
        prestamo.setFechaPrestamo(new Date());
        prestamo.calcularFechaDevolucionEsperada(); // calcula automáticamente
        prestamo.setDevuelto(false);
        prestamo.setDiasMora(0);
        prestamo.setMoraCalculada(null);

        boolean exito = controller.crearPrestamo(prestamo);
        System.out.println("¿Préstamo creado?: " + exito);

        // Registrar devolución (simula devolución del préstamo ID 1)
        boolean devuelto = controller.devolverPrestamo(3, new Date());
        System.out.println("¿Préstamo devuelto?: " + devuelto);
        // Listar todos los préstamos
        List<Prestamo> prestamos = controller.listarPrestamos();
        System.out.println("----- LISTA DE PRÉSTAMOS -----");
        for (Prestamo p : prestamos) {
            System.out.println("ID: " + p.getIdPrestamo()
                    + " | Usuario: " + p.getIdUsuario()
                    + " | Material: " + p.getIdMaterial()
                    + " | Devuelto: " + p.isDevuelto()
                    + " | Mora: $" + p.getMoraCalculada());
        }
    }
}