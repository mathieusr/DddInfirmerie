package fr.esgi.ddd.infirmerie.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import fr.esgi.ddd.infirmerie.use_case.soins_internes.LimiteMedicamentPrisAtteint;

public class Eleve {

    public final ArrayList<EtatSante> antecedents;
    public int medicamentsAdministrer;
    public final String id;

    public Eleve(ArrayList<EtatSante> antecedents) {
        this.antecedents = antecedents;
        this.medicamentsAdministrer = 0;
        this.id = UUID.randomUUID().toString();
    }

    public Eleve() {
        this.antecedents = new ArrayList<EtatSante>();
        this.medicamentsAdministrer = 0;
        this.id = UUID.randomUUID().toString();
    }

    public void prendreMedicament() throws LimiteMedicamentPrisAtteint {

        if(this.medicamentsAdministrer >= 3) {
            throw new LimiteMedicamentPrisAtteint("L'élève à reçu trop de medicaments");
        }

        this.medicamentsAdministrer++;
    }
};