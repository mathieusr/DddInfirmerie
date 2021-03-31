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

        FakeDiagnostics diagnostics = new FakeDiagnostics();

        FaireDiagnostic faireDiagnostic = new FaireDiagnostic(diagnostics);
        Diagnostic resultat = faireDiagnostic.diagnostiquer(eleve, EtatSante.BENIN);

        assertTrue("le résultat du diagnostic doit être être lié aux antécédents de l'élève.", resultat.isLinkedToAntecedants());
    }

    @Test
    public void should_diagnostic_student_with_harmless_symptoms(){
        Eleve eleve = new Eleve();

        FakeDiagnostics diagnostics = new FakeDiagnostics();

        FaireDiagnostic faireDiagnostic = new FaireDiagnostic(diagnostics);
        Diagnostic resultat = faireDiagnostic.diagnostiquer(eleve, EtatSante.BENIN);

        assertTrue("le résultat du diagnostic doit être bénin", resultat.getEtatSante() == EtatSante.BENIN);
    }

    @Test
    public void should_diagnostic_student_with_severe_symptoms(){
        Eleve eleve = new Eleve();

        FakeDiagnostics diagnostics = new FakeDiagnostics();

        FaireDiagnostic faireDiagnostic = new FaireDiagnostic(diagnostics);
        Diagnostic resultat = faireDiagnostic.diagnostiquer(eleve, EtatSante.GRAVE);

        assertTrue("le résultat du diagnostic doit être grave", resultat.getEtatSante() == EtatSante.GRAVE);
    }

    @Test
    public void should_diagnostic_student_with_psychological_symptoms(){
        Eleve eleve = new Eleve();

        FakeDiagnostics diagnostics = new FakeDiagnostics();

        FaireDiagnostic faireDiagnostic = new FaireDiagnostic(diagnostics);
        Diagnostic resultat = faireDiagnostic.diagnostiquer(eleve, EtatSante.PSYCHOLOGIQUE);

        assertTrue("Le résultat du diagnostic doit être psychologique", resultat.getEtatSante() == EtatSante.PSYCHOLOGIQUE);
    }
}
