package org.aartaraz.patrones.decorator.decorator;

import org.aartaraz.patrones.decorator.Formateable;

public class ReversaDecador extends TextoDecorador {

    public ReversaDecador(Formateable texto) {
        super(texto);
    }

    @Override
    public String darFormato() {
        StringBuilder sb= new StringBuilder(texto.darFormato());
        return sb.reverse().toString();
    }
}
