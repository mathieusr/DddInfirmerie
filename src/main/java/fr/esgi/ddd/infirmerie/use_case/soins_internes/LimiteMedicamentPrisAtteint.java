package fr.esgi.ddd.infirmerie.use_case.soins_internes;

public class LimiteMedicamentPrisAtteint extends Exception {

    private static final long serialVersionUID = 1L;
    

    public LimiteMedicamentPrisAtteint(String message) {
        super(message);
    }
}
