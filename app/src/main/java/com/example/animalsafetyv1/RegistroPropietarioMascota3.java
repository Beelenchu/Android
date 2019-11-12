package com.example.animalsafetyv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegistroPropietarioMascota3 extends AppCompatActivity {
    Button sgt,cerrar,atras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_propietario_mascota3);

        sgt = (Button)findViewById(R.id.Siguiente_3);
        cerrar = (Button)findViewById(R.id.Cerrar_3);
        atras = (Button)findViewById(R.id.Atras_2);
        sgt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siguiente3 = new Intent(getApplicationContext(),Login.class);
                startActivity(siguiente3);
            }
        });

        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cerrar = new Intent(getApplicationContext(),Login.class);
                startActivity(cerrar);
            }
        });

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent atras = new Intent(getApplicationContext(),RegistroPropietarioMascota2.class);
                startActivity(atras);
            }
        });
    }
}
