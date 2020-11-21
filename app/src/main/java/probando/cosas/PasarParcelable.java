package probando.cosas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import probando.cosas.R;
import probando.cosas.manejo.datos.Plato;

public class PasarParcelable extends AppCompatActivity {
    TextView ver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasar_parcelable);
        ver = findViewById(R.id.ver_nombre);


        FlorParcelable flor = getIntent().getParcelableExtra("flor");
        String nombre = flor.getNombre();
        ver.setText(nombre);
        System.out.println(nombre);


    }

}