package com.example.pokeapi.model;

public class MoveContainer {
    private Move move;

    public MoveContainer() {
    }

    public MoveContainer(Move move) {
        this.move = move;
    }

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }
}
