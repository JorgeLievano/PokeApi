package com.example.pokeapi.model;

public class Pokemon {

    private Form[] forms;
    private MoveContainer[] moves;
    private StatContainer[] stats;
    private TypeContainer[] types;
    private Sprite sprites;

    public Pokemon() {
    }

    public Pokemon(Form[] forms, MoveContainer[] moves, StatContainer[] stats, TypeContainer[] types, Sprite sprites) {
        this.forms = forms;
        this.moves = moves;
        this.stats = stats;
        this.types = types;
        this.sprites = sprites;
    }

    public Form[] getForms() {
        return forms;
    }

    public void setForms(Form[] forms) {
        this.forms = forms;
    }

    public MoveContainer[] getMoves() {
        return moves;
    }

    public void setMoves(MoveContainer[] moves) {
        this.moves = moves;
    }

    public StatContainer[] getStats() {
        return stats;
    }

    public void setStats(StatContainer[] stats) {
        this.stats = stats;
    }

    public TypeContainer[] getTypes() {
        return types;
    }

    public void setTypes(TypeContainer[] types) {
        this.types = types;
    }

    public Sprite getSprites() {
        return sprites;
    }

    public void setSprites(Sprite sprites) {
        this.sprites = sprites;
    }
}
