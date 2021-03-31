package fr.esgi.ddd.infirmerie.model.diagnostic;

import fr.esgi.ddd.infirmerie.model.EtatSante;

public class Diagnostic {
    public final String description;
    public final EtatSante etatSante;
    public final Boolean antecendents;

    public Diagnostic(String description, EtatSante etatSante, Boolean estAntecendents) {
        this.description = description;
        this.etatSante = etatSante;
        this.antecendents = estAntecendents;
    }


};