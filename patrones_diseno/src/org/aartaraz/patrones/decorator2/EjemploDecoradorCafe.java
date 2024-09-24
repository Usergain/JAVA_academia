package org.aartaraz.patrones.decorator2;

import org.aartaraz.patrones.decorator2.decorador.ConChocolateDecorador;
import org.aartaraz.patrones.decorator2.decorador.ConCremaDecorador;
import org.aartaraz.patrones.decorator2.decorador.ConLecheDecorador;

public class EjemploDecoradorCafe {
    public static void main(String[] args) {
        Configurable cafe = new Cafe("Cafe Mocha", 7);
        ConCremaDecorador conCrema=new ConCremaDecorador(cafe);
        ConLecheDecorador conLeche= new ConLecheDecorador(conCrema);
        ConChocolateDecorador conChocolate= new ConChocolateDecorador(conLeche);

        System.out.println("El precio del cafe moca es: " + conChocolate.getPrecioBase());
        System.out.println("Los ingredientes: " + conChocolate.getIngredientes());

        Configurable capuchino = new Cafe("Cafe Capuchino", 4);
        conCrema = new ConCremaDecorador(capuchino);
        conLeche = new ConLecheDecorador(conCrema);

        System.out.println("El precio del capuchino es: " + conLeche.getPrecioBase());
        System.out.println("Los ingredientes: " + conLeche.getIngredientes());

        Configurable espresso = new Cafe("Cafe Espresso", 3);
        System.out.println("El precio del cafe Espresso es:" + espresso.getPrecioBase());
        System.out.println("Los ingredientes del cafe Espresso es: " + espresso.getIngredientes());
    }
}
