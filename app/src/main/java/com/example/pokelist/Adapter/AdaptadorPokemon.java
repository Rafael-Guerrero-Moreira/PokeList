package com.example.pokelist.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.pokelist.R;
import com.example.pokelist.model.Pokemon;

import java.util.ArrayList;

public class AdaptadorPokemon extends ArrayAdapter<Pokemon> {
    public AdaptadorPokemon(Context context, ArrayList<Pokemon> datos) {
        super(context, R.layout.ly_item, datos);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.ly_item, null);

        TextView lblnumero = (TextView)item.findViewById(R.id.lblnumero);
        TextView lblnombre = (TextView)item.findViewById(R.id.lblnombre);
        TextView lblaltura = (TextView)item.findViewById(R.id.lblaltura);
        TextView lblpeso = (TextView)item.findViewById(R.id.lblpeso);

        ImageView imageView = (ImageView) item.findViewById(R.id.imgpok);

        //Glide.with(this.getContext()).load(getItem(position).getUrlpoke()).into(imageView);

        Glide.with(this.getContext()).load(getItem(position).getUrlpoke()).into(imageView);

        lblnumero.setText("Número: "+getItem(position).getNumero());
        lblnombre.setText("Nombre: "+getItem(position).getNombre());
        lblaltura.setText("Altura: "+getItem(position).getAltura());
        lblpeso.setText("Peso: "+getItem(position).getPeso());


        return(item);
    }
}
