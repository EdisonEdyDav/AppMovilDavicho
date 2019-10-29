package com.example.avherramientasappmovil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class PedidosActivity extends AppCompatActivity {

    Button btn_IngresoPedidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos);

        final Button btn_IngresoPedidos= (Button)findViewById(R.id.btn_IngresoPedidos);
        btn_IngresoPedidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(PedidosActivity.this, IngresoPedidosActivity.class);
                startActivity(intent);
            }
        });






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
