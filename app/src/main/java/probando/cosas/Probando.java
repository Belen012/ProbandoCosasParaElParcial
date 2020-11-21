package probando.cosas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class Probando extends AppCompatActivity {
    Context contexto = this;
    Button button_notificacion;
    Button intent_implicito;
    Button button_DatoParcelable;
    Button hilo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_probando);

        String [] datos = new String[]{"Seleccionar Opcion","Santa fe", "Esperanza","Margarita"};
        Adapter adapter;
        Spinner spinner;
        spinner = findViewById(R.id.spinner);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,datos);
        ((ArrayAdapter) adapter).setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter((SpinnerAdapter) adapter);

        button_notificacion = findViewById(R.id.button_noti);
        button_notificacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(contexto, MostrarNotificacion1.class));
            }
        });

        intent_implicito = findViewById(R.id.Intent_implicito);
        intent_implicito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("tel:3483400662")));
            }
        });

        button_DatoParcelable = findViewById(R.id.button_DatoParcelable);
        button_DatoParcelable.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {

                FlorParcelable flor = new FlorParcelable("Margarita");

                Intent pasarParcelable = new Intent(contexto, PasarParcelable.class);
                pasarParcelable.putExtra("flor", flor);
                //System.out.println("PROBANDO  "+flor.getNombre());
                contexto.startActivity(pasarParcelable);
            }
        });


        hilo = findViewById(R.id.hilos);
        hilo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pantallaHilo = new Intent(contexto, Hilos.class);
                startActivity(pantallaHilo);
            }
        });



    }
}