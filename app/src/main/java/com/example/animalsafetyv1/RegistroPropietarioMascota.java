package com.example.animalsafetyv1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import cz.msebera.android.httpclient.Header;

public class RegistroPropietarioMascota extends AppCompatActivity implements View.OnClickListener {
    Button sgt,cerrar,fecha;
    EditText rut, nombre, apellidos;
    int dia,mes,ano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_propietario_mascota);

        fecha = findViewById(R.id.Fechan_p);
        cerrar = (Button)findViewById(R.id.Cerrar_1);
        sgt = (Button)findViewById(R.id.Siguiente_1);

        rut = findViewById(R.id.Rut);
        nombre = findViewById(R.id.Nombre_p);
        apellidos = findViewById(R.id.Apellidos_p);


        fecha.setOnClickListener(this);
        sgt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //ejecutarServicio();
               Intent siguiente1 = new Intent(getApplicationContext(),RegistroPropietarioMascota2.class);
              startActivity(siguiente1);

            }
        });

        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cerrar = new Intent(getApplicationContext(),Login.class);
                startActivity(cerrar);
            }
        });
    }

    private void ejecutarServicio(){
        AsyncHttpClient client = new AsyncHttpClient();

        String URL2 = http.ip +"/conexion_as/insertDatosPropietarioMascota.php?";
        String parametros = "userRut=" + rut.getText().toString() + "&userNombre="
                + nombre.getText().toString() + "&userApellidos=" + apellidos.getText().toString()
                + "&userFechaNac=" + fecha.getText().toString();
        client.post(URL2 + parametros, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == 200)
                {
                    Toast.makeText(getApplicationContext(), "OPERACIÓN EXITOSA", Toast.LENGTH_SHORT).show();
                   Intent siguiente1 = new Intent(getApplicationContext(),RegistroPropietarioMascota2.class);
                    startActivity(siguiente1);
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(getApplicationContext(), "FALLÓ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v == fecha)
        {
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            ano = c.get(Calendar.YEAR);

DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        fecha.setText(year+"-"+(month+1)+"-"+dayOfMonth);

                 }
            }
            ,ano,mes,dia);
datePickerDialog.show();
        }
    }
}
