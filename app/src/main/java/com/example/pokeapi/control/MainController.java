package com.example.pokeapi.control;

import android.util.Log;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.pokeapi.R;
import com.example.pokeapi.model.Pokemon;
import com.example.pokeapi.util.Constants;
import com.example.pokeapi.util.HTTPSWebUtilDomi;
import com.example.pokeapi.view.MainActivity;
import com.google.gson.Gson;

public class MainController implements View.OnClickListener , HTTPSWebUtilDomi.OnResponseListener{

    private MainActivity mainActivity;
    private  HTTPSWebUtilDomi httpsWebUtilDomi;

    public MainController(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        this.httpsWebUtilDomi= new HTTPSWebUtilDomi();
        this.httpsWebUtilDomi.setListener(this);
        this.mainActivity.getSearchBtn().setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.searchBtn:

                String idOrName= mainActivity.getNameOrIdET().getText().toString();

                new Thread(
                        ()->{
                            httpsWebUtilDomi.GETrequest(Constants.SEARCH_CALLBACK,"https://pokeapi.co/api/v2/pokemon/"+idOrName);
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
                Pokemon pokemon=gson.fromJson(response, Pokemon.class);
                mainActivity.runOnUiThread(
                        ()->{
                            mainActivity.getPokeNameTV().setText(pokemon.getForms()[0].getName());
                            mainActivity.getPokeTypeTV().setText(pokemon.getTypes()[0].getType().getName());

                            mainActivity.getPokeHab1TV().setText(pokemon.getMoves()[0].getMove().getName());
                            mainActivity.getPokeHab2TV().setText(pokemon.getMoves()[1].getMove().getName());
                            mainActivity.getPokeHab3TV().setText(pokemon.getMoves()[2].getMove().getName());
                            mainActivity.getPokeHab4TV().setText(pokemon.getMoves()[3].getMove().getName());

                            mainActivity.getPokeSpeedTV().setText("speed: "+pokemon.getStats()[0].getBase_stat());
                            mainActivity.getPokeDefenseTV().setText("defense: "+pokemon.getStats()[3].getBase_stat());
                            mainActivity.getPokeAttackTV().setText("attack: "+pokemon.getStats()[4].getBase_stat());
                            mainActivity.getPokeHpTV().setText("HP: "+pokemon.getStats()[5].getBase_stat());

                            Glide.with(mainActivity).load(pokemon.getSprites().getFront_default()).centerCrop().into(mainActivity.getPokeImgIV());
                        }
                );
                break;
        }
    }
}
