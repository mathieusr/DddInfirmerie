package fr.esgi.ddd.infirmerie.use_case.diagnostic;

import fr.esgi.ddd.infirmerie.model.EtatSante;
import fr.esgi.ddd.infirmerie.model.Eleve;
import fr.esgi.ddd.infirmerie.model.diagnostic.Diagnostic;
import fr.esgi.ddd.infirmerie.model.diagnostic.IDiagnostics;

public class FaireDiagnostic {

    private final IDiagnostics diagnostics;
    
    public FaireDiagnostic(IDiagnostics diagnostics) {
        this.diagnostics = diagnostics;
    }

    public Diagnostic diagnostiquer(Eleve eleve, EtatSante etat) {
        
        Diagnostic diagnostic = this.getDiagnosticFromEtat(etat);
        diagnostic.setAntecendents(eleve.antecedents.contains(etat));

        return this.diagnostics.save(diagnostic);
    }

    private Diagnostic getDiagnosticFromEtat(EtatSante etat){
        
        switch (etat) {
            case BENIN:
                return new Diagnostic("Léger troubles", etat);
            case GRAVE:
                return new Diagnostic("Problème de santé grave", etat);
            case URGENT:
                return new Diagnostic("Problème de santé urgent", etat);
            case PSYCHOLOGIQUE:
                return new Diagnostic("Problème de nature psychologique", etat);
            default:
                return new Diagnostic("Impossible de diagnostiquer l'élève", etat);
        }
    }

};