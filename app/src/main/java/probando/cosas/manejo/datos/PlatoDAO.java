package probando.cosas.manejo.datos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PlatoDAO {
    @Insert
    void insertar(Plato plato);

    @Delete
    void borrar(Plato plato);

    @Update
    void actualizar(Plato plato);

    @Query("SELECT * FROM Plato WHERE id = :id LIMIT 1")
    Plato buscar(String id);

    @Query("SELECT * FROM Plato")
    List<Plato> buscarTodos();
}
