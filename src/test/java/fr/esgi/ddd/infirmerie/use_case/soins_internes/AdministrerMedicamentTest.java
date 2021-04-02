package fr.esgi.ddd.infirmerie.use_case.soins_internes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.esgi.ddd.infirmerie.model.Eleve;
import fr.esgi.ddd.infirmerie.model.IInfirmerie;
import fr.esgi.ddd.infirmerie.model.Infirmerie;
import fr.esgi.ddd.infirmerie.model.soins_internes.Medicament;
import fr.esgi.ddd.infirmerie.use_case.FakeInfirmerie;

public class AdministrerMedicamentTest {

    @Test
    public void administrer_medicament_should_append_correctly() throws Exception{

        Infirmerie infirmerie = new Infirmerie(2);
        Medicament medicament = new Medicament();
        IInfirmerie infirmerieRepo = new FakeInfirmerie();
        Eleve eleve = new Eleve();

        infirmerie.addMedicament(medicament);
        infirmerie.addEleve(eleve);

        AdministrerMedicament administrerMedicament = new AdministrerMedicament(infirmerieRepo, infirmerie);

        administrerMedicament.administrer(eleve.id);

        assertEquals(infirmerie.getStockMedicaments().size(), 0);
        assertEquals(infirmerie.findEleve(eleve.id).medicamentsAdministrer, 1);
    }

    @Test
    public void administrer_medicament_shoud_throw_exeption_not_enought_medicaments() throws Exception {

        Infirmerie infirmerie = new Infirmerie(2);
        IInfirmerie infirmerieRepo = new FakeInfirmerie();
        Eleve eleve = new Eleve();

        infirmerie.addEleve(eleve);

        AdministrerMedicament administrerMedicament = new AdministrerMedicament(infirmerieRepo, infirmerie);

        try {
            administrerMedicament.administrer(eleve.id);
        }catch(StockMedicamentVide e){
            assertEquals(infirmerie.getStockMedicaments().size(), 0);
            assertEquals(infirmerie.findEleve(eleve.id).medicamentsAdministrer, 0);
            return;
        }

        throw new Exception("administrer medicament should thrown an exception when no medicament is available");
    }

    @Test
    public void administrer_medicament_shoud_throw_exeption_eleve_take_too_much_medicament() throws Exception {
     
        Infirmerie infirmerie = new Infirmerie(2);
        IInfirmerie infirmerieRepo = new FakeInfirmerie();
        Eleve eleve = new Eleve();

        for(int i = 0; i < 8; i++){
            infirmerie.addMedicament(new Medicament());
        }

        infirmerie.addEleve(eleve);

        AdministrerMedicament administrerMedicament = new AdministrerMedicament(infirmerieRepo, infirmerie);

        for(int i = 0; i < 3; i++){
            administrerMedicament.administrer(eleve.id);
        }

        try {
            administrerMedicament.administrer(eleve.id);
        }catch(LimiteMedicamentPrisAtteint e){
            assertEquals(infirmerie.getStockMedicaments().size(), 5);
            assertEquals(infirmerie.findEleve(eleve.id).medicamentsAdministrer, 3);
            return;
        }

        fail("administrer medicament should thrown an exception when student want to take more than 3 medicaments");
    }
}
