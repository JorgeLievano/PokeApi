package com.example.pokeapi.model;

public class StatContainer {

    private Stat stat;
    private int base_stat,effort;

    public StatContainer() {
    }

    public StatContainer(Stat stat, int base_stat, int effort) {
        this.stat = stat;
        this.base_stat = base_stat;
        this.effort = effort;
    }

    public Stat getStat() {
        return stat;
    }

    public void setStat(Stat stat) {
        this.stat = stat;
    }

    public int getBase_stat() {
        return base_stat;
    }

    public void setBase_stat(int base_stat) {
        this.base_stat = base_stat;
    }

    public int getEffort() {
        return effort;
    }

    public void setEffort(int effort) {
        this.effort = effort;
    }
}
