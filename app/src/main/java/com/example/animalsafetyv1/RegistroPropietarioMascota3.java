package com.example.animalsafetyv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import cz.msebera.android.httpclient.Header;

public class RegistroPropietarioMascota3 extends AppCompatActivity {
    Button sgt,cerrar,atras;
    EditText email, celu, password1, password2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_propietario_mascota3);

        sgt = (Button)findViewById(R.id.Siguiente_3);
        cerrar = (Button)findViewById(R.id.Cerrar_3);
        atras = (Button)findViewById(R.id.Atras_2);

        email = findViewById(R.id.Email);
        celu = findViewById(R.id.Celular);
        password1 = findViewById(R.id.Contraseña_1);
        password2 = findViewById(R.id.Contraseña_2);


        sgt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ejecutarServicio();
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
        //recibirDato();

    }
    /*
    void recibirDato()
    {
        Bundle extra = getIntent().getExtras();
        String d1 = extra.getString("dato2");
        Toast.makeText(this, "rut: " + d1, Toast.LENGTH_SHORT).show();
    }
     */
    private void ejecutarServicio(){
        AsyncHttpClient client = new AsyncHttpClient();
        Bundle extra = getIntent().getExtras();
        String d1 = extra.getString("dato2");
        String URL2 = http.ip +"/conexion_as/registro3.php?";
        String parametros = "userCorreo=" + email.getText().toString() + "&userNumeroContacto="
                + celu.getText().toString() + "&password=" + password1.getText().toString() + "&userRut=" + d1;

        client.post(URL2 + parametros, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == 200)
                {
                    Toast.makeText(getApplicationContext(), "OPERACIÓN EXITOSA", Toast.LENGTH_SHORT).show();
                    Intent cerrar = new Intent(getApplicationContext(),Login.class);
                    startActivity(cerrar);
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(getApplicationContext(), "FALLÓ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
