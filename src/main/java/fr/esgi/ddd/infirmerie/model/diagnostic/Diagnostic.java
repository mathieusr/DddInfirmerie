package fr.esgi.ddd.infirmerie.model.diagnostic;

import fr.esgi.ddd.infirmerie.model.EtatSante;

public class Diagnostic {
    
    private final String description;
    private final EtatSante etatSante;
    private Boolean isLinkedToAntecedents;

    public Diagnostic(String description, EtatSante etatSante) {
        this.description = description;
        this.etatSante = etatSante;
        this.isLinkedToAntecedents = false;
    }

    public Diagnostic(String description, EtatSante etatSante, Boolean isLinkedToAntecedents) {
        this.description = description;
        this.etatSante = etatSante;
        this.isLinkedToAntecedents = isLinkedToAntecedents;
    }

    public String getDescription() {
        return description;
    }

    public EtatSante getEtatSante() {
        return etatSante;
    }

    public Boolean isLinkedToAntecedants() {
        return isLinkedToAntecedents;
    }

    public void setAntecendents(Boolean antecendents) {
        this.isLinkedToAntecedents = antecendents;
    }


};