package src.controllers;

import src.model.DVD;
import src.dao.DVDDAO;
import java.util.List;

public class DVDController {

    private DVDDAO DvdDao = new DVDDAO();

    public boolean agregarDVD(DVD dvd) {
        return DvdDao.agregar(dvd);
    }

    public boolean actualizarDVD(DVD dvd) {
        return DvdDao.actualizar(dvd);
    }

    public boolean eliminarDVD(int id) {
        return DvdDao.eliminar(id);
    }

    public DVD buscarDVDPorID(String id) {
        return DvdDao.buscarPorID(id);
    }

    public List<DVD> listarTodosLosDVDs() {
        return DvdDao.listarTodos();
    }



}