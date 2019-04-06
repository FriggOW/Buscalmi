package com.browser.buscalmi.Fragmentos;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_inicio, container, false);

        listTopVentas = view.findViewById(R.id.TopVentas);

        productosTopVentas.add(new Producto("Test 1", 54));
        productosTopVentas.add(new Producto("Test 2", 100));
        productosTopVentas.add(new Producto("Test 3", 20));
        productosTopVentas.add(new Producto("Test 4", 5));

        listTopVentas.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        RecyclerAdapter b=new RecyclerAdapter(productosTopVentas, getContext());
        listTopVentas.setAdapter(b);



        listTopPrecios = view.findViewById(R.id.TopPrecios);

        productosTopPrecio.add(new Producto("Test 5", 200));
        productosTopPrecio.add(new Producto("Test 6", 20));
        productosTopPrecio.add(new Producto("Test 7", 40));
        productosTopPrecio.add(new Producto("Test 8", 10));

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

