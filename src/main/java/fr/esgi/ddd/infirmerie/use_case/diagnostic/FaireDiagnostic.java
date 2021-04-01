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
        
        Diagnostic diagnostic = new Diagnostic(etat, eleve);
        
        return this.diagnostics.save(diagnostic);
    }

};