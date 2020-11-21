package probando.cosas.manejo.datos;

import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

public class BuscarPlatos extends AsyncTask<String, Void, List<Plato>> {
    private PlatoDAO dao;
    private Callback<String> callback;

    public BuscarPlatos(PlatoDAO dao, Callback<String> callback) {
        this.dao = dao;
        this.callback = callback;
    }

    @Override
    protected List<Plato> doInBackground(String... strings) {
        List<Plato> platos = dao.buscarTodos();
        Log.i("Info","Platos encontrados" + platos.toString());
        return platos;
    }

    protected void onPostExecute(List<Plato> platos) {
        super.onPostExecute(platos);
        callback.onCallback(platos.toString());
    }
}
