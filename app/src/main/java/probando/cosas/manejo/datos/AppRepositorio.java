package probando.cosas.manejo.datos;

import android.app.Application;


import java.util.List;

public class AppRepositorio {
    private PlatoDAO platoDao;

    public AppRepositorio(Application application){
        AppBaseDato db = AppBaseDato.getInstance(application);
        platoDao = db.dishDAO();
    }

    public void insertar(final Plato plato){
        AppBaseDato.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                platoDao.insertar(plato);
            }
        });
    };

    public void buscarTodos(Callback<String> callback) {
        new BuscarPlatos(this.platoDao, callback).execute();
    };


}
