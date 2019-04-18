package com.browser.buscalmi.Fragmentos;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.browser.buscalmi.Adaptadores.RecyclerAdapter;
import com.browser.buscalmi.Producto;
import com.browser.buscalmi.R;

import java.util.ArrayList;


public class FragInicio extends Fragment{

    private RecyclerView listTopVentas;
    private RecyclerView listTopPrecios;

    private ArrayList<Producto> productosTopVentas = new ArrayList<Producto>();
    private ArrayList<Producto> productosTopPrecio = new ArrayList<Producto>();


    public FragInicio() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_inicio, container, false);

        listTopVentas = view.findViewById(R.id.TopVentas);
        productosTopVentas.add(new Producto("Nintendo Switch", 300));
        productosTopVentas.add(new Producto("Pokemon Sword", 60));
        productosTopVentas.add(new Producto("Pokemon Shield", 60));
        productosTopVentas.add(new Producto("Tarjeta de Google", 5));
        productosTopVentas.add(new Producto("Overwatch", 20));
        productosTopVentas.add(new Producto("The Witcher", 30));
        listTopVentas.setLayoutManager(new GridLayoutManager(getContext(), 3));
        RecyclerAdapter b=new RecyclerAdapter(productosTopVentas, getContext());
        listTopVentas.setAdapter(b);

        listTopPrecios = view.findViewById(R.id.TopPrecios);
        productosTopPrecio.add(new Producto("Nintendo Switch", 300));
        productosTopPrecio.add(new Producto("Pokemon Sword", 60));
        productosTopPrecio.add(new Producto("Pokemon Shield", 60));
        productosTopPrecio.add(new Producto("Tarjeta de Google", 5));
        productosTopPrecio.add(new Producto("Overwatch", 20));
        productosTopPrecio.add(new Producto("The Witcher", 30));
        listTopPrecios.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        RecyclerAdapter c=new RecyclerAdapter(productosTopPrecio, getContext());
        listTopPrecios.setAdapter(c);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}

