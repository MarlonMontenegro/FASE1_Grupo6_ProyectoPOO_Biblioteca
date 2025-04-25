package src.dao;

import src.model.CDdeAudio;

import java.util.List;

public class CDDAO implements MaterialDAO<CDdeAudio> {


    @Override
    public boolean agregar(CDdeAudio material) {
        return false;
    }

    @Override
    public boolean actualizar(CDdeAudio material) {
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        return false;
    }

    @Override
    public CDdeAudio buscarPorID(String id) {
        return null;
    }

    @Override
    public List<CDdeAudio> listarTodos() {
        return List.of();
    }
}
