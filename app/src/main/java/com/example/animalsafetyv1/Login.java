package com.example.animalsafetyv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    Button ir_ingresar;
    Button ir_registro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ir_ingresar=(Button)findViewById(R.id.btn_ingresar);
        ir_registro=(Button)findViewById(R.id.btn_ir_registro);

        ir_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ingresar = new Intent(getApplicationContext(),AsociarUsuario.class);
                startActivity(ingresar);
            }
        });
        ir_registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registro = new Intent(getApplicationContext(), RegistroPropietarioMascota.class);
                startActivity(registro);
            }
        });
    }
}
