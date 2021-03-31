package fr.esgi.ddd.infirmerie.use_case.diagnostic;

import fr.esgi.ddd.infirmerie.model.EtatSante;
import fr.esgi.ddd.infirmerie.model.Eleve;
import fr.esgi.ddd.infirmerie.model.diagnostic.Diagnostic;
import fr.esgi.ddd.infirmerie.model.diagnostic.IDiagnostics;

public class FaireDiagnostic {

    private final Eleve eleve;
    public FaireDiagnostic(Eleve eleve) {
        this.eleve = eleve;
    }

    public Diagnostic diagnostiquer(Eleve eleve, EtatSante symptome) {
        boolean estAntecedent = false;
        if(eleve.antecedents.contains(symptome)) {
            estAntecedent = true;
        }
        switch (symptome) {
            case BENIN:
                return new Diagnostic("Léger troubles", symptome, estAntecedent);
            case GRAVE:
                return new Diagnostic("Problème de santé grave", symptome, estAntecedent);
            case URGENT:
                return new Diagnostic("", symptome, estAntecedent);
            case PSYCHOLOGIQUE:
                return new Diagnostic("", symptome, estAntecedent);
            default:
                return new Diagnostic("Impossible de diagnostiquer l'élève", symptome, false);
        }
    }

};