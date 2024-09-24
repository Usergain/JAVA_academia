package org.aartaraz.patrones.factory;

import org.aartaraz.patrones.factory.producto.PizzaCaliforniaPepperoni;
import org.aartaraz.patrones.factory.producto.PizzaCaliforniaQueso;
import org.aartaraz.patrones.factory.producto.PizzaCaliforniaVegetariana;

import java.sql.SQLOutput;

public class PizzeriaCaliforniaFactory extends PizzeriaZonaAbstractFactory {

    @Override
    PizzaProducto crearPizza(String tipo) {
        PizzaProducto producto = null;
        switch (tipo) {
            case "queso":
                producto = new PizzaCaliforniaQueso();
                break;
            case "pepperoni":
                producto = new PizzaCaliforniaPepperoni();
                break;
            case "vegetariana":
                producto = new PizzaCaliforniaVegetariana();
                break;
        }
        return producto;
    }
}
