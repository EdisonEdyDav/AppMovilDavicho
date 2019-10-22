package com.example.avherramientasappmovil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class PedidosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos);


        ArrayList<Fuente>lista= new ArrayList<Fuente>();

        lista.add(new Fuente ("Imagen Numero 1", R.drawable.imag_ejemplo,0));
        lista.add(new Fuente ("Imagen Numero 2", R.drawable.imag_ejemplo,0));
        lista.add(new Fuente ("Imagen Numero 3", R.drawable.imag_ejemplo,0));
        lista.add(new Fuente ("Imagen Numero 4", R.drawable.imag_ejemplo,0));
        lista.add(new Fuente ("Imagen Numero 5", R.drawable.imag_ejemplo,0));
        lista.add(new Fuente ("Imagen Numero 6", R.drawable.imag_ejemplo,0));
        lista.add(new Fuente ("Imagen Numero 7", R.drawable.imag_ejemplo,0));

        RecyclerView contenedor=(RecyclerView)findViewById(R.id.contenedor);
        contenedor.setHasFixedSize(true);
        LinearLayoutManager layout = new LinearLayoutManager(getApplicationContext());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        contenedor.setAdapter(new Adaptador(lista));
        contenedor.setLayoutManager(layout);
    }
}
