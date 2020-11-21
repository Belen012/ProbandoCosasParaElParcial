package probando.cosas.manejo.datos;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.Executor;

@Database(entities = {Plato.class}, version = 1)
public abstract class AppBaseDato extends RoomDatabase {
    public static Executor databaseWriteExecutor;

    public abstract PlatoDAO dishDAO();


    static AppBaseDato getInstance(final Context context) {
        return Room.databaseBuilder(context, AppBaseDato.class, "database-name").build();
    }
}
