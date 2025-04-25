package src.dao;

import src.model.Revista;

import java.util.List;

public class RevistaDAO implements MaterialDAO<Revista> {
    @Override
    public boolean agregar(Revista material) {
        return false;
    }

    @Override
    public boolean actualizar(Revista material) {
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        return false;
    }

    @Override
    public Revista buscarPorID(String id) {
        return null;
    }

    @Override
    public List<Revista> listarTodos() {
        return List.of();
    }
}
