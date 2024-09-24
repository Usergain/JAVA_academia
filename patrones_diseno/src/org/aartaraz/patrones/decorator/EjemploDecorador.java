package org.aartaraz.patrones.decorator;

import org.aartaraz.patrones.decorator.Formateable;
import org.aartaraz.patrones.decorator.decorator.MayusculaDecorador;
import org.aartaraz.patrones.decorator.decorator.RemplazarEspacioDecorador;
import org.aartaraz.patrones.decorator.decorator.ReversaDecador;
import org.aartaraz.patrones.decorator.decorator.SubrayadoDecorador;

public class EjemploDecorador {
    public static void main(String[] args) {
        Formateable texto = new Texto("Hola que tal Arkaitz");

        MayusculaDecorador mayuscula = new MayusculaDecorador(texto);
        ReversaDecador reverso = new ReversaDecador(mayuscula);
        SubrayadoDecorador subrayar = new SubrayadoDecorador(reverso);
        RemplazarEspacioDecorador remplazar = new RemplazarEspacioDecorador(subrayar);

        System.out.println(remplazar.darFormato());
    }
}
