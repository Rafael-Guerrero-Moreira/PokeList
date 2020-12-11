package com.example.pokelist.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Pokemon {
    private String numero;
    private String nombre;
    private String altura;
    private String peso;
    private String urlpoke;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getUrlpoke() {
        return urlpoke;
    }

    public void setUrlpoke(String urlpoke) {
        this.urlpoke = urlpoke;
    }

    public Pokemon(JSONObject a) throws JSONException {
        numero =  a.getString("num").toString();
        urlpoke = a.getString("img").toString();
        nombre =  a.getString("name").toString() ;
        altura =  a.getString("height").toString() ;
        peso = a.getString("weight").toString() ;


    }
    public static ArrayList<Pokemon> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Pokemon> pokemons = new ArrayList<>();

        for (int i = 0; i < datos.length(); i++) {
            pokemons.add(new Pokemon(datos.getJSONObject(i)));
        }
        return pokemons;
    }
}
