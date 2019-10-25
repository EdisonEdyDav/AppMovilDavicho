package com.example.avherramientasappmovil;


import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    Button btn_reserva;
    Button btn_añadir;
    TextView txtView_titulo_imagen;
    ImageView img_pedido;
    List<Fuente> ListaObjeto;
    public viewHolder(View itemView, List<Fuente> datos) {
        super(itemView);

        btn_añadir = (Button) itemView.findViewById(R.id.btn_añadir);
        btn_reserva = (Button) itemView.findViewById(R.id.btn_reserva);
        img_pedido = (ImageView) itemView.findViewById(R.id.img_pedido);
        txtView_titulo_imagen=(TextView) itemView.findViewById(R.id.txtView_titulo_imagen);
        ListaObjeto=datos;


        btn_reserva.setOnClickListener(this);
        btn_añadir.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        int position=getAdapterPosition();
        Fuente objeto=ListaObjeto.get(position);

        if (view.getId() == btn_reserva.getId()){


            Toast.makeText(btn_reserva.getContext(),"Apreto la opcion 1",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(btn_añadir.getContext(),"Apreto la opcion 2",Toast.LENGTH_SHORT).show();

        }




    }
}

