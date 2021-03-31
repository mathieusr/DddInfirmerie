package fr.esgi.ddd.infirmerie.use_case.diagnostic;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import fr.esgi.ddd.infirmerie.model.*;
import fr.esgi.ddd.infirmerie.model.diagnostic.EntreeInfirmerie;

import org.junit.Test;

public class AllerInfirmerieTest {

    @Test
    public void should_create_an_infirmary_entry_when_capacity_is_not_overwhelmed() throws CapaciteDepasseException {

        FakeEntreesInfirmerie entrees = new FakeEntreesInfirmerie();

        Eleve eleve = new Eleve();
        Infirmerie infirmerie = new Infirmerie(10);

        AllerInfirmerie allerInfirmerie = new AllerInfirmerie(infirmerie, entrees);
        EntreeInfirmerie entree = allerInfirmerie.aller(eleve);
        assertTrue("use case returns an EntreeInfirmerie", entree instanceof EntreeInfirmerie);
    }

    @Test
    public void should_throw_an_capactiy_depasse_exception_when_capacity_is_overwhelmed()
            throws Exception {

        FakeEntreesInfirmerie entrees = new FakeEntreesInfirmerie();

        Infirmerie infirmerie = new Infirmerie(1);
        AllerInfirmerie allerInfirmerie = new AllerInfirmerie(infirmerie, entrees);
        List<Eleve> eleves = new ArrayList<Eleve>();
        eleves.add(new Eleve());
        eleves.add(new Eleve());

        try {
            for (Eleve eleve : eleves) {
                allerInfirmerie.aller(eleve);
            }
        } catch (CapaciteDepasseException e) {
            return;
        }

        throw new Exception("use case must throw an exception when capacity is overwhelmed.");
    }
}
