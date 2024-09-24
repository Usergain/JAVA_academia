package org.aartaraz.patrones.factory.producto;

import org.aartaraz.patrones.factory.PizzaProducto;

public class PizzaNewYorkPepperoni extends PizzaProducto {

    public PizzaNewYorkPepperoni() {
        super();
        nombre="Pizza Pepperoni New York";
        masa="Masa delgada a la piedra";
        salsa="Salsa de tomate";
        ingredientes.add("Queso mozzarella");
        ingredientes.add("Extra pepperoni");
        ingredientes.add("Aceiturnas");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando por 40 min. a 90ºC");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en triangulos");
    }
}
