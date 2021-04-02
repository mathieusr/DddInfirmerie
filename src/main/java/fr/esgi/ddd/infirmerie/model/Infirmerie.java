package fr.esgi.ddd.infirmerie.model;

import java.util.ArrayList;
import java.util.UUID;

import fr.esgi.ddd.infirmerie.model.soins_internes.Medicament;
import fr.esgi.ddd.infirmerie.use_case.diagnostic.CapaciteDepasseException;
import fr.esgi.ddd.infirmerie.use_case.soins_internes.StockMedicamentVide;

public class Infirmerie {

    private final String id;
    public final ArrayList<Eleve> eleves = new ArrayList<>();
    private final int capacity;
    private final ArrayList<Medicament> stockMedicaments;

    public Infirmerie(int capacity){
        this.id = UUID.randomUUID().toString();
        this.capacity = capacity;
        this.stockMedicaments = new ArrayList<>();
    }

    public int getCapacity(){
        return this.capacity;
    }

    public void addEleve(Eleve eleve) throws CapaciteDepasseException {
        if (this.eleves.size() + 1 > this.capacity){
            throw new CapaciteDepasseException("La capacité de l'infirmerie a été dépassée.");
        }
        this.eleves.add(eleve);
    }

    public String getId() {
        return id;
    }

    public ArrayList<Eleve> getEleves() {
        return eleves;
    }

    public ArrayList<Medicament> getStockMedicaments() {
        return stockMedicaments;
    }

    public void addMedicament(Medicament medicament) {
        stockMedicaments.add(medicament);
    }

    public void preparerMedicament(String eleveId) throws Exception {
        if(this.stockMedicaments.size() == 0){
            throw new StockMedicamentVide("Le stock de medicament est vide");
        }

        Eleve findEleve = this.findEleve(eleveId);        

        findEleve.prendreMedicament();
        this.stockMedicaments.remove(0);
    }

    public Eleve findEleve(String eleveId) throws Exception {

        return this.eleves.stream().filter(eleve -> eleveId == eleve.id)
                                    .findFirst()
                                    .orElseThrow(() -> new Exception("Impossible de trouver l'élève"));
    }
};