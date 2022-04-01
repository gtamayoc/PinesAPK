package com.example.pines;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class splash_screnn extends AppCompatActivity {

    private DBTrabajadores DBTrabajadores;
    private Button botonLoguearse,botonRegistrarse;
    private EditText editTextLoginNombreUsuario, editTextLoginContrasena;
    BDConexion conn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screnn);
        botonLoguearse=findViewById(R.id.buttonLoguear);
        botonRegistrarse=findViewById(R.id.buttonRegistrar);
        editTextLoginNombreUsuario=findViewById(R.id.editTextLoginNombreUsuario1);
        editTextLoginContrasena=findViewById(R.id.editTextLoginContrasena1);
        DBTrabajadores = new DBTrabajadores(this);
        conn=new BDConexion(getApplicationContext(),"BDPines", null,1);

        botonRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        botonLoguearse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreUsuario = editTextLoginNombreUsuario.getText().toString();
                String contrasena = editTextLoginContrasena.getText().toString();

                if(nombreUsuario.equals("")||contrasena.equals("")){
                    Toast.makeText(splash_screnn .this, "Error: Campos Vacios", Toast.LENGTH_SHORT).show();
                }else if(DBTrabajadores.login(nombreUsuario,contrasena)==1){
                    Toast.makeText(splash_screnn .this, nombreUsuario, Toast.LENGTH_SHORT).show();
                    Toast.makeText(splash_screnn .this, contrasena, Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(splash_screnn .this, "Errologin", Toast.LENGTH_SHORT).show();
                    Toast.makeText(splash_screnn .this, nombreUsuario, Toast.LENGTH_SHORT).show();
                    Toast.makeText(splash_screnn .this, contrasena, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}