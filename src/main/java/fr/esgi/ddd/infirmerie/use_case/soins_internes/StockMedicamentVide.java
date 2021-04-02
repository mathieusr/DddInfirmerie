package fr.esgi.ddd.infirmerie.use_case.soins_internes;

public class StockMedicamentVide extends Exception {
    
    private static final long serialVersionUID = 1L;

    public StockMedicamentVide(String message){
        super(message);
    }
}
