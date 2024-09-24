package org.aartaraz.appmockito.ejemplos.repositories;

import org.aartaraz.appmockito.ejemplos.models.Examen;

import java.beans.IntrospectionException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ExamenRepositoryOtro implements ExamenRepository {

    @Override
    public Examen guardar(Examen examen) {
        return null;
    }

    @Override
    public List<Examen> findAll()  {

        try {
            System.out.println("ExamenRepositoryOtro"); //no se imprime, se simula en mockito
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
