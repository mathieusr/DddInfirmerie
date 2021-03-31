package fr.esgi.ddd.infirmerie.use_case.diagnostic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import fr.esgi.ddd.infirmerie.model.Eleve;
import fr.esgi.ddd.infirmerie.model.Infirmerie;
import fr.esgi.ddd.infirmerie.model.diagnostic.EntreeInfirmerie;
import fr.esgi.ddd.infirmerie.model.diagnostic.IEntreesInfirmerie;

public class FakeEntreesInfirmerie implements IEntreesInfirmerie {

    private final List<EntreeInfirmerie> entrees = new ArrayList<>();

    @Override
    public EntreeInfirmerie save(EntreeInfirmerie entree) {
        this.entrees.add(entree);
        return entree;
    }

    @Override
    public List<EntreeInfirmerie> getAllForInfirmerie(Infirmerie infirmerie) {
        return this.entrees.stream()
            .filter(entree -> {
                return entree.getInfirmerie().getId().equals(infirmerie.getId());
            })
            .collect(Collectors.toList());
    }
    
}
