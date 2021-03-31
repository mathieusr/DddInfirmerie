package fr.esgi.ddd.infirmerie.model;

import java.util.ArrayList;

public class Infirmerie {

    public ArrayList<Eleve> eleves = new ArrayList<>();
    private int capacity;

    public Infirmerie(int capacity){
        this.capacity = capacity;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public void addEleves (Eleve eleve){
        this.eleves.add(eleve);
    }
};