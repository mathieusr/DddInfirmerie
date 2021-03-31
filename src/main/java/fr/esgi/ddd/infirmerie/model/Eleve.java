package fr.esgi.ddd.infirmerie.model;

import java.util.ArrayList;

public class Eleve {

    public final ArrayList<EtatSante> antecedents;

    public Eleve(ArrayList<EtatSante> antecedents) {
        this.antecedents = antecedents;
    }

    public Eleve() {
        this.antecedents = new ArrayList<EtatSante>();
    }
};