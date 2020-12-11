package com.example.pokelist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.pokelist.Adapter.AdaptadorPokemon;
import com.example.pokelist.model.Pokemon;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RequestQueue request;
    private StringRequest stringr;
    private ListView pokemons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pokemons = (ListView)findViewById(R.id.lstListaPokemon);

        View header = getLayoutInflater().inflate(R.layout.ly_header, null);

        pokemons.addHeaderView(header);
        btnenviar();
    }
    public void btnenviar()
    {


        request = Volley.newRequestQueue(MainActivity.this);
        String URL = "https://raw.githubusercontent.com/Biuni/PokemonGO-Pokedex/master/pokedex.json";

        stringr = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>()  {
            @Override
            public void onResponse(String response) {
                ArrayList<Pokemon> pokemon = new ArrayList<Pokemon>();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("pokemon");
                    pokemon = Pokemon.JsonObjectsBuild(jsonArray);

                    AdaptadorPokemon adaptadorPokemon = new AdaptadorPokemon(MainActivity.this,pokemon);
                    pokemons.setAdapter(adaptadorPokemon);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Sucedió un error en la consulta. Intente nuevamente. \n Detalle del error: "+error.getMessage() , Toast.LENGTH_LONG).show();
            }
        });
        request.add(stringr);
    }
}