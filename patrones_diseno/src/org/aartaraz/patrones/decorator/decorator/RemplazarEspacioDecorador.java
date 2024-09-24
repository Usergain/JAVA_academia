package org.aartaraz.patrones.decorator.decorator;

import org.aartaraz.patrones.decorator.Formateable;

public class RemplazarEspacioDecorador extends TextoDecorador{

    public RemplazarEspacioDecorador(Formateable texto) {
        super(texto);
    }

    @Override
    public String darFormato() {
        return texto.darFormato().replace(" ", "_");
    }
}
