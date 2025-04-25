package src.dao;

import src.model.DVD;

import java.util.List;

public class DVDDAO implements MaterialDAO<DVD> {
    @Override
    public boolean agregar(DVD material) {
        return false;
    }

    @Override
    public boolean actualizar(DVD material) {
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        return false;
    }

    @Override
    public DVD buscarPorID(String id) {
        return null;
    }

    @Override
    public List<DVD> listarTodos() {
        return List.of();
    }
}
