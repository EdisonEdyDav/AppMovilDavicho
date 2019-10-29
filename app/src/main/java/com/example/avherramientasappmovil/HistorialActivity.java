package com.example.avherramientasappmovil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HistorialActivity extends AppCompatActivity {

    Button btnBuscarHistorial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);

        btnBuscarHistorial=(Button)findViewById(R.id.btnBuscarHistorial);

        btnBuscarHistorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(HistorialActivity.this, ResumenHistorialActivity.class);
                startActivity(intent);
            }
        });

    }
}
