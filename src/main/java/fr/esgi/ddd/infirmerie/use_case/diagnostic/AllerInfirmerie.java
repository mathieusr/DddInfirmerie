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
        
        this.infirmerie.addEleve(eleve);
        
        EntreeInfirmerie entree = new EntreeInfirmerie(this.infirmerie, eleve);
        return this.entreesInfirmerie.save(entree);
    }
};