package fr.esgi.ddd.infirmerie.use_case.diagnostic;

import fr.esgi.ddd.infirmerie.model.Eleve;
import fr.esgi.ddd.infirmerie.model.EtatSante;
import fr.esgi.ddd.infirmerie.model.diagnostic.Diagnostic;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FaireDiagnosticTest {

    @Test()
    public void should_diagnostic_student_with_antecendent(){
        
        ArrayList<EtatSante> antecedents = new ArrayList<EtatSante>();
        antecedents.add(EtatSante.BENIN);
        
        Eleve eleve = new Eleve(antecedents);

        FakeDiagnostics diagnostics = new FakeDiagnostics();

        FaireDiagnostic faireDiagnostic = new FaireDiagnostic(diagnostics);
        Diagnostic resultat = faireDiagnostic.diagnostiquer(eleve, EtatSante.BENIN);

        assertTrue("le résultat du diagnostic doit être être lié aux antécédents de l'élève.", resultat.isLinkedToAntecedants());
    }

    @Test
    public void should_diagnostic_student_with_corresponding_symptom(){

        List<EtatSante> etats = new ArrayList<>();
        etats.add(EtatSante.GRAVE);
        etats.add(EtatSante.BENIN);
        etats.add(EtatSante.PSYCHOLOGIQUE);
        etats.add(EtatSante.URGENT);
        
        Eleve eleve = new Eleve();

        for (EtatSante etat: etats){
            
            FakeDiagnostics diagnostics = new FakeDiagnostics();

            FaireDiagnostic faireDiagnostic = new FaireDiagnostic(diagnostics);
            Diagnostic resultat = faireDiagnostic.diagnostiquer(eleve, etat);

            assertTrue(String.format("le résultat du diagnostic doit être %s", etat), resultat.getEtatSante() == etat);
        }
    }
}
