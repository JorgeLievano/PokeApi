package com.example.pokeapi.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pokeapi.R;
import com.example.pokeapi.control.MainController;

public class MainActivity extends AppCompatActivity {

    private TextView pokeNameTV, pokeTypeTV,pokeHab1TV,pokeHab2TV,pokeHab3TV,pokeHab4TV,pokeSpeedTV,pokeAttackTV,pokeDefenseTV,pokeHpTV,myPokemonsTV;
    private EditText nameOrIdET;
    private Button catchBtn,searchBtn;
    private ImageView pokeImgIV;

    private MainController mainController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pokeImgIV=findViewById(R.id.pokeImgIV);

        pokeNameTV= findViewById(R.id.pokeNameTV);
        pokeTypeTV = findViewById(R.id.pokeTypeTV);
        pokeHab1TV=findViewById(R.id.pokeHab1TV);
        pokeHab2TV=findViewById(R.id.pokeHab2TV);
        pokeHab3TV=findViewById(R.id.pokeHab3TV);
        pokeHab4TV=findViewById(R.id.pokeHab4TV);
        pokeSpeedTV=findViewById(R.id.pokeSpeedTV);
        pokeAttackTV=findViewById(R.id.pokeAttackTV);
        pokeDefenseTV=findViewById(R.id.pokeDefenseTv);
        pokeHpTV=findViewById(R.id.pokeHpTV);
        myPokemonsTV=findViewById(R.id.myPokemonsTV);

        nameOrIdET=findViewById(R.id.nameOrIdET);

        catchBtn=findViewById(R.id.catchBtn);
        searchBtn=findViewById(R.id.searchBtn);

        mainController= new MainController(this);
    }

    public TextView getPokeNameTV() {
        return pokeNameTV;
    }

    public TextView getPokeTypeTV() {
        return pokeTypeTV;
    }

    public TextView getPokeHab1TV() {
        return pokeHab1TV;
    }

    public TextView getPokeHab2TV() {
        return pokeHab2TV;
    }

    public TextView getPokeHab3TV() {
        return pokeHab3TV;
    }

    public TextView getPokeHab4TV() {
        return pokeHab4TV;
    }

    public TextView getPokeSpeedTV() {
        return pokeSpeedTV;
    }

    public TextView getPokeAttackTV() {
        return pokeAttackTV;
    }

    public TextView getPokeDefenseTV() {
        return pokeDefenseTV;
    }

    public TextView getPokeHpTV() {
        return pokeHpTV;
    }

    public TextView getMyPokemonsTV() {
        return myPokemonsTV;
    }

    public EditText getNameOrIdET() {
        return nameOrIdET;
    }

    public Button getCatchBtn() {
        return catchBtn;
    }

    public Button getSearchBtn() {
        return searchBtn;
    }

    public ImageView getPokeImgIV() {
        return pokeImgIV;
    }
}
