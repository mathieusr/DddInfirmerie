package fr.esgi.ddd.infirmerie.model;

import java.util.ArrayList;
import java.util.UUID;

public class Infirmerie {

    private final String id;
    public ArrayList<Eleve> eleves = new ArrayList<>();
    private int capacity;

    public Infirmerie(int capacity){
        this.id = UUID.randomUUID().toString();
        this.capacity = capacity;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public void addEleves (Eleve eleve){
        this.eleves.add(eleve);
    }

    public String getId() {
        return id;
    }

    public ArrayList<Eleve> getEleves() {
        return eleves;
    }

    public void setEleves(ArrayList<Eleve> eleves) {
        this.eleves = eleves;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
};