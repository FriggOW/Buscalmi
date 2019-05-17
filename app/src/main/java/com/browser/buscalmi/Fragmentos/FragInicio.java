package com.browser.buscalmi.Fragmentos;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.browser.buscalmi.Adaptadores.RecyclerAdapter;
import com.browser.buscalmi.AllProductos;
import com.browser.buscalmi.Apollo.MiApolloClient;
import com.browser.buscalmi.Producto;
import com.browser.buscalmi.R;

import java.util.ArrayList;

import javax.annotation.Nonnull;


public class FragInicio extends Fragment {

    private RecyclerView listTopVentas;
    private RecyclerView listTopPrecios;

    private static ArrayList<Producto> productos = new ArrayList<Producto>();

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_inicio, container, false);
        /* TEST PRODUCTS
        productos.add(new Producto("Nintendo Switch", 300));
        productos.add(new Producto("Pokemon Sword", 60));
        productos.add(new Producto("Pokemon Shield", 60));
        productos.add(new Producto("Tarjeta de Google", 5));
        productos.add(new Producto("Overwatch", 20));
        productos.add(new Producto("The Witcher", 30));
        */

        initializeProducts();

        //Esperando ala respuesta de la conexion de la BBDD
        SystemClock.sleep(1000);

        listTopVentas = view.findViewById(R.id.TopVentas);
        listTopVentas.setLayoutManager(new GridLayoutManager(getContext(), 3));
        productosTopVentas.addAll(productos);
        RecyclerAdapter b = new RecyclerAdapter(productosTopVentas, getContext());
        listTopVentas.setAdapter(b);

        listTopPrecios = view.findViewById(R.id.TopPrecios);
        listTopPrecios.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        productosTopPrecio.addAll(productos);
        RecyclerAdapter c = new RecyclerAdapter(productosTopPrecio, getContext());
        listTopPrecios.setAdapter(c);

        return view;
    }

    private void initializeProducts() {

        MiApolloClient.getApolloClient().query(AllProductos.builder()
                .build())
                .enqueue(new ApolloCall.Callback<AllProductos.Data>() {

                    @Override
                    public void onResponse(@Nonnull Response<AllProductos.Data> response) {

                        for (int i = 0; i < response.data().productos().size(); i++){

                            productos.add(new Producto(
                                    response.data().productos().get(i).nombre(),
                                    Integer.valueOf(""+response.data().productos().get(i).precio()))
                            );
                        }
                    }

                    @Override
                    public void onFailure(@Nonnull ApolloException e) {

                    }
                });


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
            productosTopPrecio.clear();

            for (int i = 0; i < productos.size();i++){
                if (productos.get(i).getNombre().toLowerCase().contains(newText.toLowerCase())){
                    productosTopVentas.add(productos.get(i));
                    productosTopPrecio.add(productos.get(i));
                }
            }

        } else {
            productosTopVentas.addAll(productos);
            productosTopPrecio.addAll(productos);
        }

        RecyclerAdapter b=new RecyclerAdapter(productosTopVentas, getContext());
        listTopVentas.setAdapter(b);

        RecyclerAdapter c=new RecyclerAdapter(productosTopPrecio, getContext());
        listTopPrecios.setAdapter(c);
    }
}

