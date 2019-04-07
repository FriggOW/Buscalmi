package com.browser.buscalmi.Fragmentos;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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

    private  RecyclerView listTopVentas;
    private RecyclerView listTopPrecios;

    //LISTA DE PRODUCTOS
    public static final Producto P1 = new Producto("Test 1", 54);
    public static final Producto P2 = new Producto("Test 2", 100);
    public static final Producto P3 = new Producto("Test 3", 20);
    public static final Producto P4 = new Producto("Test 4", 5);
    public static final Producto P5 = new Producto("Test 5", 200);
    public static final Producto P6 = new Producto("Test 6", 20);
    public static final Producto P7 = new Producto("Test 7", 40);
    public static final Producto P8 = new Producto("Test 8", 10);

    public static ArrayList<Producto> productos = new ArrayList<Producto>();
    private static ArrayList<Producto> productosTopVentas = new ArrayList<Producto>();
    private static ArrayList<Producto> productosTopPrecio = new ArrayList<Producto>();


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

        productos.add(P1);
        productos.add(P2);
        productos.add(P3);
        productos.add(P4);
        productos.add(P5);
        productos.add(P6);
        productos.add(P7);
        productos.add(P8);

        listTopVentas = view.findViewById(R.id.TopVentas);

        productosTopVentas.addAll(productos);

        listTopVentas.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        RecyclerAdapter b=new RecyclerAdapter(productosTopVentas, getContext());
        listTopVentas.setAdapter(b);

        listTopPrecios = view.findViewById(R.id.TopPrecios);

        productosTopPrecio.addAll(productos);

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


    public void Filter(String newText) {

        if (newText != "") {

            productosTopVentas.clear();
            for (int i = 0; i < productos.size();i++){
                if (productos.get(i).getNombre().toLowerCase().contains(newText.toLowerCase())){
                    productosTopVentas.add(productos.get(i));
                }
            }

        } else {

            productosTopVentas.addAll(productos);
        }

        RecyclerAdapter c=new RecyclerAdapter(productosTopVentas, getContext());
        listTopVentas.setAdapter(c);
    }
}

