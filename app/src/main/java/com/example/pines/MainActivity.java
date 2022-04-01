package com.example.pines;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private DBTrabajadores DBTrabajadores;
    private Button botonRegistrar;
    private EditText editTextNombre, editTextApellido, editTextDocumento, editTextCorreo, editTextNombreUsuario, editTextContrasena, editTextContrasena1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNombre = findViewById(R.id.editTextNombre1);
        editTextApellido = findViewById(R.id.editTextApellido1);
        editTextDocumento = findViewById(R.id.editTextDocumento1);
        editTextCorreo = findViewById(R.id.editTextCorreo1);
        editTextNombreUsuario = findViewById(R.id.editTextNombreUsuario1);
        editTextContrasena = findViewById(R.id.editTextContrasena2);
        editTextContrasena1 = findViewById(R.id.editTextContrasena3);
        botonRegistrar = findViewById(R.id.buttonRegistrar2);
        DBTrabajadores = new DBTrabajadores(this);

        botonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Nombre = editTextNombre.getText().toString();
                String Apellido = editTextApellido.getText().toString();
                String Correo = editTextCorreo.getText().toString();
                String NombreUsuario = editTextNombreUsuario.getText().toString();
                String contrasena1 = editTextContrasena.getText().toString();
                String contrasena2 = editTextContrasena1.getText().toString();
                String documento = editTextDocumento.getText().toString();
                Trabajador trabajador = new Trabajador();
                trabajador.setNombre(Nombre);
                trabajador.setApellido(Apellido);
                trabajador.setDocumento(documento);
                trabajador.setCorreo(Correo);
                trabajador.setNombreUsuario(NombreUsuario);
                trabajador.setSaldo("1000000");
                trabajador.setContrasena(contrasena1);


                if (trabajador.isNull()) {
                    Toast.makeText(MainActivity.this, "Campos Vacios", Toast.LENGTH_SHORT).show();
                } else if (DBTrabajadores.insertarTrabajador(trabajador)) {

                    if (contrasena1.equals(contrasena2)) {
                        Toast.makeText(MainActivity.this, "Registro Exitoso", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getApplicationContext(), splash_screnn.class);
                        startActivity(i);
                        finish();
                    } else {
                        Toast.makeText(MainActivity.this, "Contraseñas Diferentes", Toast.LENGTH_SHORT).show();
                        editTextContrasena.setError("Contraseñas Diferentes");
                        editTextContrasena1.setError("Contraseñas Diferentes");
                    }

                } else {
                    Toast.makeText(MainActivity.this, "usuario registrado", Toast.LENGTH_LONG).show();
                }

            }
        });

    }


}