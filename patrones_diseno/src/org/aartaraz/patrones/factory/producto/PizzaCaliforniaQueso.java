package org.aartaraz.patrones.factory.producto;

import org.aartaraz.patrones.factory.PizzaProducto;

public class PizzaCaliforniaQueso extends PizzaProducto {

    public PizzaCaliforniaQueso() {
        nombre="Pizza California Queso";
        masa="Masa la piedra delgada";
        salsa="Salsa de tomate rucula";
        ingredientes.add("Extra queso Mozzarella");
        ingredientes.add("Cebolla");
        ingredientes.add("Queso azul");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando a 35 min. a 100ªC");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en pequeños triangulos");
    }
}
