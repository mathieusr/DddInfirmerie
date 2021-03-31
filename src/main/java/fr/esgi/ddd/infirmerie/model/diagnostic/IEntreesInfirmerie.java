package fr.esgi.ddd.infirmerie.model.diagnostic;

import java.util.List;
import fr.esgi.ddd.infirmerie.model.Infirmerie;

public interface IEntreesInfirmerie {
    public EntreeInfirmerie save(EntreeInfirmerie entree);
    public List<EntreeInfirmerie> getAllForInfirmerie(Infirmerie infirmerie);
}
