package com.example.pokeapi.control;

import android.view.View;

import com.bumptech.glide.Glide;
import com.example.pokeapi.R;
import com.example.pokeapi.model.Pokemon;
import com.example.pokeapi.util.Constants;
import com.example.pokeapi.util.HTTPSWebUtilDomi;
import com.example.pokeapi.view.MainActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;

public class MainController implements View.OnClickListener , HTTPSWebUtilDomi.OnResponseListener{

    private MainActivity mainActivity;
    private  HTTPSWebUtilDomi httpsWebUtilDomi;
    private Pokemon pokemon;

    public MainController(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        this.httpsWebUtilDomi= new HTTPSWebUtilDomi();
        this.httpsWebUtilDomi.setListener(this);
        this.mainActivity.getSearchBtn().setOnClickListener(this);
        this.mainActivity.getCatchBtn().setOnClickListener(this);
        loadMyPokemons();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.searchBtn:

                String idOrName= mainActivity.getNameOrIdET().getText().toString();

                new Thread(
                        ()-> httpsWebUtilDomi.GETrequest(Constants.SEARCH_CALLBACK,"https://pokeapi.co/api/v2/pokemon/"+idOrName)
                ).start();
                break;
            case R.id.catchBtn:
                new Thread(
                        ()->{
                            Gson gson = new Gson();
                            String json=gson.toJson(pokemon);
                            httpsWebUtilDomi.POSTrequest(Constants.CATCH_CALLBACK,"https://pokeapi-1f7e4.firebaseio.com/pokemons.json",json);
                        }
                ).start();

                break;
        }
    }

    @Override
    public void onResponse(int callbackID, String response) {
        switch (callbackID){
            case Constants.SEARCH_CALLBACK:
                Gson gson=new Gson();
                pokemon=gson.fromJson(response, Pokemon.class);
                mainActivity.runOnUiThread(
                        ()->{
                            mainActivity.getPokeNameTV().setText(pokemon.getForms()[0].getName());
                            mainActivity.getPokeTypeTV().setText(pokemon.getTypes()[0].getType().getName());

                            mainActivity.getPokeHab1TV().setText(pokemon.getMoves()[0].getMove().getName());
                            mainActivity.getPokeHab2TV().setText(pokemon.getMoves()[1].getMove().getName());
                            mainActivity.getPokeHab3TV().setText(pokemon.getMoves()[2].getMove().getName());
                            mainActivity.getPokeHab4TV().setText(pokemon.getMoves()[3].getMove().getName());

                            mainActivity.getPokeSpeedTV().setText(String.format("speed: %d", pokemon.getStats()[0].getBase_stat()));
                            mainActivity.getPokeDefenseTV().setText(String.format("defense: %d", pokemon.getStats()[3].getBase_stat()));
                            mainActivity.getPokeAttackTV().setText(String.format("attack: %d", pokemon.getStats()[4].getBase_stat()));
                            mainActivity.getPokeHpTV().setText(String.format("HP: %d", pokemon.getStats()[5].getBase_stat()));

                            Glide.with(mainActivity).load(pokemon.getSprites().getFront_default()).centerCrop().into(mainActivity.getPokeImgIV());
                        }
                );
                break;
            case Constants.CATCH_CALLBACK:
                loadMyPokemons();

                break;
            case Constants.GET_MY_POKEMONS:
                Gson g= new Gson();
                Type type = new TypeToken<HashMap<String,Pokemon>>(){}.getType();
                HashMap<String,Pokemon> mypokemons= g.fromJson(response,type);

                mainActivity.runOnUiThread(
                        ()->{
                            mainActivity.getMyPokemonsTV().setText("");
                            for(String key : mypokemons.keySet()){
                                Pokemon poke= mypokemons.get(key);
                                mainActivity.getMyPokemonsTV().append(String.format("%s\n", poke.getForms()[0].getName()));
                            }
                        }
                );
                break;
        }
    }

    private void loadMyPokemons() {
       new Thread(
               ()-> httpsWebUtilDomi.GETrequest(Constants.GET_MY_POKEMONS,"https://pokeapi-1f7e4.firebaseio.com/pokemons.json")
       ).start();

    }
}
