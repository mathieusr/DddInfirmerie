package fr.esgi.ddd.infirmerie.use_case.diagnostic;

import fr.esgi.ddd.infirmerie.model.Eleve;
import fr.esgi.ddd.infirmerie.model.EtatSante;
import fr.esgi.ddd.infirmerie.model.diagnostic.Diagnostic;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class FaireDiagnosticTest {

    @Test()
    public void should_diagnostic_student_with_antecendent(){
        ArrayList<EtatSante> antecedents = new ArrayList<EtatSante>();
        antecedents.add(EtatSante.BENIN);
        Eleve eleve = new Eleve(antecedents);

        FaireDiagnostic faireDiagnostic = new FaireDiagnostic(eleve);
        Diagnostic resultat = faireDiagnostic.diagnostiquer(eleve, EtatSante.BENIN);

        assertTrue("le résultat du diagnostic doit être être lié aux antécédents de l'élève.", resultat.antecendents);
    }
}
