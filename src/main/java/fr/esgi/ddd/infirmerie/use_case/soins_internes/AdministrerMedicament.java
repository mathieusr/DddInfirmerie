package fr.esgi.ddd.infirmerie.use_case.soins_internes;

import fr.esgi.ddd.infirmerie.model.IInfirmerie;
import fr.esgi.ddd.infirmerie.model.Infirmerie;

public class AdministrerMedicament {

    private final Infirmerie infirmerie;
    private final IInfirmerie infirmerieRepo;

    public AdministrerMedicament(IInfirmerie infirmerieRepo, Infirmerie infirmerie) {
        this.infirmerie = infirmerie;
        this.infirmerieRepo = infirmerieRepo;
    }

    public void administrer(String eleveId) throws Exception {
        this.infirmerie.preparerMedicament(eleveId);
        this.infirmerieRepo.save(infirmerie);
    };
}