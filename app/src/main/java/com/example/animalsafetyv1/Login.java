package com.example.animalsafetyv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

import org.json.JSONObject;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import cz.msebera.android.httpclient.Header;

public class Login extends AppCompatActivity {
    Button ir_ingresar;
    Button ir_registro;
    EditText rut, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ir_ingresar = (Button) findViewById(R.id.btn_ingresar);
        ir_registro = (Button) findViewById(R.id.btn_ir_registro);
        rut = findViewById(R.id.Rut);
        password = findViewById(R.id.Contraseña);
        ir_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarLogin("http://192.168.0.7/conexion_as/LOGIN.php");
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

   /* void validarLogin() {
        AsyncHttpClient client = new AsyncHttpClient();
        String URL2 = http.ip + "/conexion_as/LOGIN.php?";
        String parametros = "userRut=" + rut.getText().toString() + "&password="
                + password.getText().toString();

        client.post(URL2 + parametros, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == 200) {
                    //Toast.makeText(getApplicationContext(), "OPERACIÓN EXITOSA", Toast.LENGTH_SHORT).show();
                    validarL("http://192.168.0.7/conexion_as/LOGIN.php");
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(getApplicationContext(), "FALLÓ", Toast.LENGTH_SHORT).show();
            }
        });

    }

    void validarL(String URL)
    {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (!response.isEmpty()) {
                    Intent siguiente1 = new Intent(getApplicationContext(), RegistroIntegrante.class);
                    startActivity(siguiente1);
                }else
                {
                    Toast.makeText(Login.this, "no se encuentra registro", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Login.this, error.toString(), Toast.LENGTH_SHORT).show();
            }

        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
*/

    void validarLogin(String URL) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    if(response.contentEquals("true"))
                    {
                      //  Toast.makeText(Login.this, "la resp -> " + response.toString(), Toast.LENGTH_SHORT).show();
                        Intent siguiente1 = new Intent(getApplicationContext(), RegistroIntegrante.class);
                        startActivity(siguiente1);
                    }else {
                        Toast.makeText(Login.this, "inexistente", Toast.LENGTH_SHORT).show();
                    }
                   // Toast.makeText(Login.this, "la resp -> " + response.toString(), Toast.LENGTH_SHORT).show();
                    //JSONObject jsonResponse = new JSONObject(response);
                    /*if(response == "true")
                    {
                        Intent siguiente1 = new Intent(getApplicationContext(), RegistroIntegrante.class);
                        startActivity(siguiente1);
                    }else
                    {
                        Toast.makeText(Login.this, "no se encuentra registro", Toast.LENGTH_SHORT).show();
                    }
                     */

                }catch (Exception e)
                {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Login.this, error.toString(), Toast.LENGTH_SHORT).show();
            }

        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros = new HashMap<String,String>();
                parametros.put("userRut",rut.getText().toString());
                parametros.put("password", password.getText().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
/*
void validarLogin(String URL) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if(success == true)
                    {
                        Intent siguiente1 = new Intent(getApplicationContext(), RegistroIntegrante.class);
                        startActivity(siguiente1);
                    }else
                    {
                        Toast.makeText(Login.this, "no se encuentra registro", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e)
                {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Login.this, error.toString(), Toast.LENGTH_SHORT).show();
            }

        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros = new HashMap<String,String>();
                parametros.put("userRut",rut.getText().toString());
                parametros.put("password", password.getText().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
 */