package EjemploInterfaz2;

public class Ropa {

    private char talla; //S, M y L
    private String composicion;
    private boolean limpiezaSeco;


    public Ropa() {
    }

    public Ropa(char talla, String composicion, boolean limpiezaSeco) {
        this.talla = talla;
        this.composicion = composicion;
        this.limpiezaSeco = limpiezaSeco;
    }

    public String getComposicion() {
        return composicion;
    }

    public void setComposicion(String composicion) {
        this.composicion = composicion;
    }

    public boolean isLimpiezaSeco() {
        return limpiezaSeco;
    }

    public void setLimpiezaSeco(boolean limpiezaSeco) {
        this.limpiezaSeco = limpiezaSeco;
    }

    public char getTalla() {
        return talla;
    }

    public void setTalla(char talla) {
        this.talla = talla;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ropa other = (Ropa) obj;
        if (this.talla != other.talla) {
            return false;
        }
        if ((this.composicion == null) ? (other.composicion != null) : !this.composicion.equals(other.composicion)) {
            return false;
        }
        if (this.limpiezaSeco != other.limpiezaSeco) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.talla;
        hash = 59 * hash + (this.composicion != null ? this.composicion.hashCode() : 0);
        return hash;
    }


    @Override
    public String toString() {
        return "Ropa{" + "talla=" + talla + "composicion=" + composicion + "limpiezaSeco=" + limpiezaSeco + '}';
    }

}
