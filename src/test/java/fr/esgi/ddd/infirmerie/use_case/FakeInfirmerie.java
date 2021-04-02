package fr.esgi.ddd.infirmerie.use_case;

import java.util.ArrayList;
import java.util.List;

import fr.esgi.ddd.infirmerie.model.IInfirmerie;
import fr.esgi.ddd.infirmerie.model.Infirmerie;

public class FakeInfirmerie implements IInfirmerie {

    private final List<Infirmerie> entrees = new ArrayList<>();

    @Override
    public Infirmerie save(Infirmerie entree) {
        this.entrees.add(entree);
        return entree;
    }
}
