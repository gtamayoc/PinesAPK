package com.example.pines;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Inicio extends AppCompatActivity {

    TextView tvBienvenida,pp;
    Bundle extra;
    Intent intent;

    List<paquete> paquetes1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        Intent intent = this.getIntent();
        Bundle extra = intent.getExtras();
        pp=findViewById(R.id.nombrePin);
//        String miValor = extra.getString("nombreUsuario");
//        tvBienvenida=findViewById(R.id.textView);
//        tvBienvenida.setText("Bienvenido "+miValor);
        init();
    }


    public void init(){
        paquetes1 = new ArrayList<>();
        paquetes1.add(new paquete(0,R.drawable.netflix,"Netflix","Mejor Plataforma Para Streaming de video","4 Paquetes Disponibles"));
        paquetes1.add(new paquete(1,R.drawable.amazon_prime,"Amazon Prime","Mejor Plataforma Para Streaming de video","4 Paquetes Disponiblesaa"));
        paquetes1.add(new paquete(2,R.drawable.netflix,"HBO","Mejor Plataforma Para Streaming de video","4 Paquetes Disponiblesaas"));
        paquetes1.add(new paquete(3,R.drawable.amazon_prime,"Disney+","Mejor Plataforma Para Streaming de video","4 Paquetes Disponiblesaas"));
        paquetes1.add(new paquete(2,R.drawable.netflix,"Spotify","Mejor Plataforma Para Streaming de video","4 Paquetes Disponiblesaas"));
        paquetes1.add(new paquete(3,R.drawable.amazon_prime,"Youtube Premium","Mejor Plataforma Para Streaming de video","4 Paquetes Disponiblesaas"));


        ListAdaptador listAdaptador = new ListAdaptador(paquetes1, this);
        RecyclerView recyclerView = findViewById(R.id.recycleViewPines);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdaptador);

    }
}