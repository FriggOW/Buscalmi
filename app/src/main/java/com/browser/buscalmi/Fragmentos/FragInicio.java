package com.browser.buscalmi.Fragmentos;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import com.browser.buscalmi.AllSmartphones;
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
        //* TEST PRODUCTS

        productos.clear();
        productosTopVentas.clear();

        productos.add(new Producto(1,"Nintendo Switch", "300","300","300","300"));
        productos.add(new Producto(2,"Pokemon Sword", "60","300","300","300"));
        productos.add(new Producto(3,"Pokemon Shield", "60","300","300","300"));
        productos.add(new Producto(4,"Tarjeta de Google", "5","300","300","300"));
        productos.add(new Producto(5,"Overwatch", "20","300","300","300"));
        productos.add(new Producto(6,"The Witcher", "30","300","300","300"));


        //initializeProducts();

        //Esperando ala respuesta de la conexion de la BBDD
        SystemClock.sleep(5000);

        listTopVentas = view.findViewById(R.id.TopVentas);
        listTopVentas.setLayoutManager(new GridLayoutManager(getContext(), 3));
        productosTopVentas.addAll(productos);
        RecyclerAdapter b = new RecyclerAdapter(productosTopVentas, getContext());
        listTopVentas.setAdapter(b);

        return view;
    }

    private void initializeProducts() {

        MiApolloClient.getApolloClient().query(AllSmartphones.builder()
                .build())
                .enqueue(new ApolloCall.Callback<AllSmartphones.Data>() {

                    @Override
                    public void onResponse(@Nonnull Response<AllSmartphones.Data> response) {
                        for (int i = 0; i < response.data().browalmi_modelo().size(); i++){
                            productos.add(new Producto(
                                    response.data().browalmi_modelo().get(i).modelo_smartphone().modelo_id(),
                                    response.data().browalmi_modelo().get(i).name(),
                                    "" + response.data().browalmi_modelo().get(i).modelo_phoneinstance().get(0).precio(),
                                    response.data().browalmi_modelo().get(i).modelo_phoneinstance().get(0).url(),
                                    response.data().browalmi_modelo().get(i).modelo_smartphone().imagen(),
                                    "Amazon"
                            ));
                        }

                        if (response.data().browalmi_modelo().size() == 0){
                            initializeProducts();
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

