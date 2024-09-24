package org.aartaraz.patrones.factory.ejemplo;

import org.aartaraz.patrones.factory.PizzaProducto;
import org.aartaraz.patrones.factory.PizzeriaCaliforniaFactory;
import org.aartaraz.patrones.factory.PizzeriaNewYorkFactory;
import org.aartaraz.patrones.factory.PizzeriaZonaAbstractFactory;

public class EjemploFactory {
    public static void main(String[] args) {
        PizzeriaZonaAbstractFactory ny = new PizzeriaNewYorkFactory();
        PizzeriaZonaAbstractFactory california = new PizzeriaCaliforniaFactory();

        PizzaProducto pizza = california.ordenarPizza("queso");
        System.out.println("Bruce ordena la pizzaa " + pizza.getNombre());

        pizza = ny.ordenarPizza("pepperoni");
        System.out.println("Arkaitz ordena una " + pizza.getNombre());

        pizza =california.ordenarPizza("vegetariana");
        System.out.println("Linus ordena la pizza " + pizza.getNombre());

        pizza = ny.ordenarPizza("vegetariana");
        System.out.println("James ordena una " + pizza.getNombre());

        pizza =california.ordenarPizza("pepperoni");
        System.out.println("John ordena la pizza " + pizza.getNombre());

        System.out.println("pizza = " + pizza);
    }
}
