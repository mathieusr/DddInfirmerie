package fr.esgi.ddd.infirmerie.use_case.diagnostic;

import fr.esgi.ddd.infirmerie.model.Eleve;
import fr.esgi.ddd.infirmerie.model.Infirmerie;
import fr.esgi.ddd.infirmerie.model.diagnostic.EntreeInfirmerie;
import fr.esgi.ddd.infirmerie.model.diagnostic.IEntreesInfirmerie;

public class AllerInfirmerie {

    private final Infirmerie infirmerie;
    private final IEntreesInfirmerie entreesInfirmerie;

    public AllerInfirmerie (Infirmerie infirmerie, IEntreesInfirmerie entreesInfirmerie){
        this.entreesInfirmerie = entreesInfirmerie;
        this.infirmerie = infirmerie;
    }

    public EntreeInfirmerie aller(Eleve eleve) throws CapaciteDepasseException {
        
        if (this.infirmerie.eleves.size() + 1 > this.infirmerie.getCapacity()){
            throw new CapaciteDepasseException("La capacité de l'infirmerie a été dépassée.");
        }
        
        this.infirmerie.addEleves(eleve);
        
        EntreeInfirmerie entree = new EntreeInfirmerie(this.infirmerie, eleve);
        return this.entreesInfirmerie.save(entree);
    }
};