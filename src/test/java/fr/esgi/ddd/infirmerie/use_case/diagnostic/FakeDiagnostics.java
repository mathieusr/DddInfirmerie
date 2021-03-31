package fr.esgi.ddd.infirmerie.use_case.diagnostic;

import java.util.ArrayList;
import java.util.List;

import fr.esgi.ddd.infirmerie.model.diagnostic.Diagnostic;
import fr.esgi.ddd.infirmerie.model.diagnostic.IDiagnostics;

public class FakeDiagnostics implements IDiagnostics {

    private final List<Diagnostic> diagnostics = new ArrayList<>();

    @Override
    public Diagnostic save(Diagnostic diagnostic) {
        this.diagnostics.add(diagnostic);
        return diagnostic;
    }
    
}
