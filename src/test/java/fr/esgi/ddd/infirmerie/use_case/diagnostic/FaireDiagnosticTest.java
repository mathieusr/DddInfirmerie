package fr.esgi.ddd.infirmerie.use_case.diagnostic;

import fr.esgi.ddd.infirmerie.model.Eleve;
import fr.esgi.ddd.infirmerie.model.EtatSante;
import fr.esgi.ddd.infirmerie.model.diagnostic.Diagnostic;

import java.util.ArrayList;

public class FaireDiagnosticTest {

    public void should_diagnostic_student_with_antecendent() throws Exception {
        ArrayList<EtatSante> antecedents = new ArrayList<EtatSante>();
        antecedents.add(EtatSante.BENIN);
        Eleve eleve = new Eleve(antecedents);

        FaireDiagnostic faireDiagnostic = new FaireDiagnostic(eleve);
        Diagnostic resultat = faireDiagnostic.diagnostiquer(eleve, EtatSante.BENIN);

        if(resultat.antecendents == false) {
            throw new Exception("Use case must throw exception when student has antecedent diagnosed");
        }
    }
}
