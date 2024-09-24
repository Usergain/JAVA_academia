package org.aartaraz.hibernateapp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.aartaraz.hibernateapp.entity.Cliente;
import org.aartaraz.hibernateapp.util.JpaUtil;

import java.util.List;
import java.util.Scanner;

public class HibernatePorId {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.println("Ingrese el id: ");
        Long id = s.nextLong();
        EntityManager em = JpaUtil.getEntityManager();
        Cliente cliente = em.find(Cliente.class, id); //find solo valdría para la PK, los demás campos con where como en la otra clase
        System.out.println(cliente);

        //Queda en el cache, no realizaria otra consulta, si fuese la misma consulta claro
        Cliente cliente2 = em.find(Cliente.class, id);
        System.out.println(cliente2);

        Cliente cliente3 = em.find(Cliente.class, 2L);
        System.out.println(cliente3);

        em.close();
    }
}
