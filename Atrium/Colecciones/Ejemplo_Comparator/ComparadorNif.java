package Ejemplo_Comparator;

import java.util.Comparator;

public class ComparadorNif implements Comparator{

	@Override
    public int compare(Object o1, Object o2) {
        return (((ClienteSimple)o1).getNif().compareTo(((ClienteSimple)o2).getNif()) );
    }

}
