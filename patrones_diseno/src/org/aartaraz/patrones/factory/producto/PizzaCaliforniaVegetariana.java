package org.aartaraz.patrones.factory.producto;

import org.aartaraz.patrones.factory.PizzaProducto;

public class PizzaCaliforniaVegetariana extends PizzaProducto {

    public PizzaCaliforniaVegetariana() {
        super();
        nombre="Pizza California Vegetariana";
        masa="Masa delgada Light";
        salsa="Salsa BBQ Light";
        ingredientes.add("Queso Mozzarella");
        ingredientes.add("Salsa BBQ Light");
        ingredientes.add("Aceituna");
        ingredientes.add("Espinaca");
        ingredientes.add("Cebolla");
        ingredientes.add("Berenjena");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando por 20min. a 180ªC");

    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en rebanadas rectangulares");
    }
}
