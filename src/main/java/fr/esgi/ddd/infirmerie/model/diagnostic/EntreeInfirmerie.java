package fr.esgi.ddd.infirmerie.model.diagnostic;

import java.util.UUID;

import fr.esgi.ddd.infirmerie.model.Eleve;
import fr.esgi.ddd.infirmerie.model.Infirmerie;

public class EntreeInfirmerie {
    
    private final String id;
    private final Eleve eleve;
    private final Infirmerie infirmerie;

    public EntreeInfirmerie(Infirmerie infirmerie, Eleve eleve){
        this.id = UUID.randomUUID().toString();
        this.eleve = eleve;
        this.infirmerie = infirmerie;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public Infirmerie getInfirmerie() {
        return infirmerie;
    }

    public String getId() {
        return id;
    }

}
