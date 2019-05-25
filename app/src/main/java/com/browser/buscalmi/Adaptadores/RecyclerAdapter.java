package com.browser.buscalmi.Adaptadores;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.browser.buscalmi.Producto;
import com.browser.buscalmi.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.DamViewHolder>{

    private List<Producto> items;
    private Context context;

    public RecyclerAdapter(List<Producto> items, Context context) {
        this.items = items;
        this.context = context;

    }

    @NonNull
    @Override
    public DamViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_top, viewGroup, false);

        return new DamViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DamViewHolder damViewHolder, int i) {
        final Producto item = items.get(i);

        damViewHolder.text.setText(item.getNombre());
        damViewHolder.precio.setText(item.getPrecio() + "€");
        Glide.with(damViewHolder.image.getContext()).load(item.getUrlImagen()).into(damViewHolder.image);

        damViewHolder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(item.getUrlTienda()));
                context.startActivity(intent);
            }
        });

        if (item.getTienda().equals("Amazon")){
            Glide.with(damViewHolder.tienda.getContext()).load(R.drawable.ic_amazon).into(damViewHolder.tienda);
        }else if (item.getTienda().equals("Ebay")){
            Glide.with(damViewHolder.tienda.getContext()).load(R.drawable.ic_ebay).into(damViewHolder.tienda);
        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class DamViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public ImageView tienda;
        public TextView text;
        public  TextView precio;

        DamViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imgFoto);
            text = itemView.findViewById(R.id.txtTexto);
            precio = itemView.findViewById(R.id.txtPrecio);
            tienda = itemView.findViewById(R.id.imgTienda);

        }
    }
}