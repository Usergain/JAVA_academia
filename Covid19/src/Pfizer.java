public class Pfizer extends Vacuna {
     
    private int dosis;
    
    public Pfizer(int stock) {
        super(stock);
        this.dosis = 2;
    }

    public int getDosis() {
        return dosis;
    }

    public void setDosis(int dosis) {
        this.dosis = dosis;
    }
    
    
    
}

