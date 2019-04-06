package com.browser.buscalmi.Adaptadores;


import android.content.Context;
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
        damViewHolder.precio.setText(item.getPrecio()+"€");
        //Glide.with(damViewHolder.image.getContext()).load(item.getFoto()).into(damViewHolder.image);

       /* damViewHolder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragItemShop frag = new FragItemShop();
                frag.setArgs(item);
                ((FragmentActivity)context).getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.entrada, R.anim.salida).replace(R.id.container_principal,frag).addToBackStack(null).commit();

            }
        });*/

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class DamViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView text;
        public  TextView precio;

        DamViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imgFoto);
            text = itemView.findViewById(R.id.imgTexto);
            precio = itemView.findViewById(R.id.imgPrecio);

        }


    }
}