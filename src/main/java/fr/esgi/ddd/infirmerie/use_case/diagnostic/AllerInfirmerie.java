package fr.esgi.ddd.infirmerie.use_case.diagnostic;

import fr.esgi.ddd.infirmerie.model.Eleve;
import fr.esgi.ddd.infirmerie.model.Infirmerie;

public class AllerInfirmerie {

    private final Infirmerie infirmerie;

    public AllerInfirmerie (Infirmerie infirmerie){
        this.infirmerie = infirmerie;
    }

    public void aller(Eleve eleve) throws CapaciteDepasseException {
        if (this.infirmerie.eleves.size() + 1 > this.infirmerie.getCapacity()){
            throw new CapaciteDepasseException("La capacité de l'infirmerie a été dépassée.");
        }
        this.infirmerie.addEleves(eleve);
    }
};