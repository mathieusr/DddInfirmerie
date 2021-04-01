package fr.esgi.ddd.infirmerie.model.diagnostic;

import fr.esgi.ddd.infirmerie.model.Eleve;
import fr.esgi.ddd.infirmerie.model.EtatSante;

public class Diagnostic {
    
    private final String description;
    private final EtatSante etatSante;
    private final Boolean linkedToAntecedents;
    private final Eleve eleve;

    public Diagnostic(EtatSante etatSante, Eleve eleve) {
        this.description = this.getDescriptionFromEtat(etatSante);
        this.etatSante = etatSante;
        this.eleve = eleve;
        this.linkedToAntecedents = eleve.antecedents.contains(etatSante);
    }

    public String getDescription() {
        return description;
    }

    public EtatSante getEtatSante() {
        return etatSante;
    }

    public Boolean isLinkedToAntecedants() {
        return linkedToAntecedents;
    }

    public Boolean getLinkedToAntecedents() {
        return linkedToAntecedents;
    }

    public Eleve getEleve() {
        return eleve;
    }

    private String getDescriptionFromEtat(EtatSante etat){
        
        switch (etat) {
            case BENIN:
                return "Léger troubles";
            case GRAVE:
                return "Problème de santé grave";
            case URGENT:
                return "Problème de santé urgent";
            case PSYCHOLOGIQUE:
                return "Problème de nature psychologique";
            default:
                return "Impossible de diagnostiquer l'élève";
        }
    }

};