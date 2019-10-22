package com.example.avherramientasappmovil;


import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class viewHolder extends RecyclerView.ViewHolder {

    Button btn_historial;
    Button btn_añadir;
    TextView txtView_titulo_imagen;
    ImageView img_pedido;

    public viewHolder(View itemView) {
        super(itemView);

        btn_añadir=(Button) itemView.findViewById(R.id.btn_añadir);
        btn_historial=(Button) itemView.findViewById(R.id.btn_historial);
        img_pedido=(ImageView) itemView.findViewById(R.id.img_pedido);
        txtView_titulo_imagen=(TextView) itemView.findViewById(R.id.txtView_titulo_imagen);


        btn_historial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        btn_añadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });





    }
}
