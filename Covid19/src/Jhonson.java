
public class Jhonson extends Vacuna {

    private int dosis;

    public Jhonson(int stock) {
        super(stock);
        this.dosis = 1;
    }

    public int getDosis() {
        return dosis;
    }

    public void setDosis(int dosis) {
        this.dosis = dosis;
    }

}
