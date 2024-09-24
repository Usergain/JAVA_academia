package org.aartaraz.patrones.factory.producto;

import org.aartaraz.patrones.factory.PizzaProducto;

public class PizzaCaliforniaPepperoni extends PizzaProducto {

    public PizzaCaliforniaPepperoni() {
        nombre="Pizza California Pepperoni";
        masa="Masa la piedra gruesa";
        ingredientes.add("Peperoni");
        ingredientes.add("Extra queso mozzarella");
        ingredientes.add("Aceitunas");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando a 350 min. a 55ªC");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en pequeños rectangulos");
    }
}
