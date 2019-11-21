package com.example.animalsafetyv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.*;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class RegistroPropietarioMascota2 extends AppCompatActivity {
    Button sgt,cerrar,atras;
    Spinner sppais, spregion, spciudad;
    ArrayList<String>selecione = new ArrayList<String>();
    ArrayList<String>datos = new ArrayList<String>();
    ArrayList<String>d2 = new ArrayList<String>();
    ArrayList<Pais> listap = new ArrayList<Pais>();
    ArrayList<Comuna>listac = new ArrayList<Comuna>();
    long idpaisspiner;
    long idregionspiner;
    long idciudadspiner;
    Pais p = new Pais();
    Comuna c = new Comuna();
    EditText pobla, calle, num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_propietario_mascota2);

        sgt = (Button)findViewById(R.id.Siguiente_2);
        cerrar = (Button)findViewById(R.id.Cerrar_2);
        atras = (Button)findViewById(R.id.Atras_1);

        llenarSpinner();
        sppais = findViewById(R.id.Pais);
        spregion = findViewById(R.id.Region);
        spciudad = findViewById(R.id.Ciudad);

        pobla = findViewById(R.id.R_poblacion_p);
        calle = findViewById(R.id.R_Calle_p);
        num = findViewById(R.id.R_Numero_p);

        //recibirDato();
        sppais.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0)
                {
                    Toast.makeText(RegistroPropietarioMascota2.this, "id = " + id, Toast.LENGTH_SHORT).show();
                }else {
                    idpaisspiner = id;
                    Toast.makeText(RegistroPropietarioMascota2.this, "id = " + id, Toast.LENGTH_SHORT).show();
                    llenarSpinner2();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spregion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0)
                {
                    idregionspiner= id;
                    Toast.makeText(RegistroPropietarioMascota2.this, "id = " + id, Toast.LENGTH_SHORT).show();
                    llenarSpinner3();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        sgt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //ejecutar();
                mandarDatos();
                 //Intent siguiente1 = new Intent(getApplicationContext(),RegistroPropietarioMascota2.class);
                //startActivity(siguiente1);

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
                Intent atras = new Intent(getApplicationContext(),RegistroPropietarioMascota.class);
                startActivity(atras);
            }
        });
    }


    /*
    void ejecutar()
    {
        AsyncHttpClient cliente2;
        cliente2 = new AsyncHttpClient();
        int d = 1;
        String url2 = http.ip +"/conexion_as/obtenerRegion.php?";
        String param = "idp=" + p.getIdP();
        cliente2.post(url2 + param, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == 200)
                {
                    Toast.makeText(getApplicationContext(),
                            "id->" + p.getIdP(), Toast.LENGTH_SHORT).show();
                    //Toast.makeText(getApplicationContext(), "OPERACIÓN EXITOSA", Toast.LENGTH_SHORT).show();
                    Intent siguiente1 = new Intent(getApplicationContext(),Login.class);
                    startActivity(siguiente1);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(getApplicationContext(), "FALLÓ", Toast.LENGTH_SHORT).show();
            }
        });

    }
     */
void llenarSpinner(){
    AsyncHttpClient cliente;
    cliente = new AsyncHttpClient();

        String url = http.ip +"/conexion_as/obtenerPais.php";
        cliente.post(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if(statusCode == 200)
                {
                    cargarSpinner(new String(responseBody));
                    //Intent siguiente1 = new Intent(getApplicationContext(),RegistroPropietarioMascota2.class);
                    //startActivity(siguiente1);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(RegistroPropietarioMascota2.this, "fallosa", Toast.LENGTH_SHORT).show();
            }
        });
}



void cargarSpinner(String respuesta){

    try {
        JSONArray jsonArreglo = new JSONArray(respuesta);
        for (int i=0; i<jsonArreglo.length(); i++)
        {

           //p.setIdP(jsonArreglo.getJSONObject(i).getInt("idPais"));
           p.setNombre(jsonArreglo.getJSONObject(i).getString("paisNombre"));
            listap.add(p);

        }
        selecione = new ArrayList<String>();
        selecione.add("Seleccione");

        for (int i=0;i<listap.size();i++){
            selecione.add(listap.get(i).getNombre());
        }
        ArrayAdapter<CharSequence> adaptador = new ArrayAdapter(this,R.layout.spinner_item_color,selecione);
        sppais.setAdapter(adaptador);

    }catch (Exception e){
        e.printStackTrace();
    }
}

    void llenarSpinner2(){
        AsyncHttpClient cliente;
        cliente = new AsyncHttpClient();
        String url = http.ip +"/conexion_as/obtenerRegion.php?idPais="+idpaisspiner;


        cliente.get(url, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {

                if (statusCode == 200)
                {
                    Gson gson = new Gson();
                    ArrayList<Region> lista = new ArrayList<Region>();

                    lista = gson.fromJson(response.toString(), new TypeToken<List<Region>>(){
                    }.getType());

                    if(lista.size()>0){

                        selecione = new ArrayList<String>();
                        selecione.add("Seleccione");

                        for (int i=0;i<lista.size();i++){
                            selecione.add(lista.get(i).regionNombre);
                        }

                        ArrayAdapter<String> a = new ArrayAdapter<String>(RegistroPropietarioMascota2.this, R.layout.spinner_item_color,selecione);
                      //  a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spregion.setAdapter(a);
                    }
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

                Toast.makeText(RegistroPropietarioMascota2.this, "fallospinner2", Toast.LENGTH_SHORT).show();
            }
        });

    }




void llenarSpinner3(){
    AsyncHttpClient cliente;
    cliente = new AsyncHttpClient();
    String url = http.ip +"/conexion_as/obtenerCiudad.php?idRegion="+idregionspiner;
    cliente.get(url, new JsonHttpResponseHandler(){
        @Override
        public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
            JSONArray jsonArreglo = new JSONArray();
            int x;
                if (statusCode == 200)
                {

                    Gson gson = new Gson();

                    ArrayList<Comuna> lista = new ArrayList<Comuna>();
                    lista = gson.fromJson(response.toString(), new TypeToken<List<Comuna>>(){
                    }.getType());
                    if(lista.size()>0) {

                        datos = new ArrayList<String>();
                        datos.add("Seleccione");

                        for (int i = 0; i < lista.size(); i++) {
                            //p.setIdP(jsonArreglo.getJSONObject(i).getInt("idPais"));
                            // listap.add(p);
                            //c.setIdComuna(lista.get(i).idComuna);
                             //c.setIdComuna(jsonArreglo.getClass();
                            //listac.add(c);
                              x = lista.get(i).idComuna;
                            datos.add(lista.get(i).comunaNombre);

                        }

                        ArrayAdapter<String> a = new ArrayAdapter<String>(RegistroPropietarioMascota2.this, R.layout.spinner_item_color, datos);
                        spciudad.setAdapter(a);

                    }
                }
        }

        @Override
        public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
            Toast.makeText(RegistroPropietarioMascota2.this, "fallospinner3", Toast.LENGTH_SHORT).show();
        }
    });
}
    void recibirDato()
    {
        Bundle extra = getIntent().getExtras();
        String d1 = extra.getString("dato1");
        Toast.makeText(this, "rut: " + d1, Toast.LENGTH_SHORT).show();
    }

    private void mandarDatos(){
        AsyncHttpClient client = new AsyncHttpClient();



        String URL2 = http.ip +"/conexion_as/subirResidencia.php?";
        String parametros = "comunaNombre=" + spciudad.getSelectedItem().toString() + "&resPoblacion=" + pobla.getText().toString()
                + "&resCalle=" + calle.getText().toString() + "&resNumero=" + num.getText().toString();

        client.post(URL2 + parametros, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == 200)
                {
                    Bundle extra = getIntent().getExtras();
                    String d1 = extra.getString("dato1");
                    Toast.makeText(getApplicationContext(), "OPERACIÓN EXITOSA ddxf", Toast.LENGTH_SHORT).show();
                     Intent siguiente1 = new Intent(getApplicationContext(),RegistroPropietarioMascota3.class);
                     siguiente1.putExtra("dato2",d1);
                    startActivity(siguiente1);
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(getApplicationContext(), "FALLÓ", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
