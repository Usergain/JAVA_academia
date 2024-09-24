
public class Moderna extends Vacuna {

    private int dosis;

    public Moderna(int stock) {
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
