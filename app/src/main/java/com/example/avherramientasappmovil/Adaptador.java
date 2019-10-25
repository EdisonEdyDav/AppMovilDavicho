package com.example.avherramientasappmovil;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import java.util.List;

public class Adaptador extends RecyclerView.Adapter<viewHolder> {

    List<Fuente> ListaObjeto;

    public Adaptador(List<Fuente> listaObjeto) {
        ListaObjeto = listaObjeto;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vista= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_pedidos, parent, false);
        return new viewHolder(vista, ListaObjeto);
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {

        holder.txtView_titulo_imagen.setText(ListaObjeto.get(position).getTitulo());
        holder.img_pedido.setImageResource(ListaObjeto.get(position).getImagen());

    }

    @Override
    public int getItemCount() {
        return ListaObjeto.size();
    }
}
