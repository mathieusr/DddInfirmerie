package fr.esgi.ddd.infirmerie.use_case.diagnostic;

public class CapaciteDepasseException extends Exception {

    private static final long serialVersionUID = -7198437537568734750L;

    public CapaciteDepasseException (String message){
        super(message);
    }
    
}