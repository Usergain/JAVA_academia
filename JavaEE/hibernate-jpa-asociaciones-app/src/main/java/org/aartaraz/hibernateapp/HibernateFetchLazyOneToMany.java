package org.aartaraz.hibernateapp;

import jakarta.persistence.EntityManager;
import jdk.swing.interop.SwingInterOpUtils;
import org.aartaraz.hibernateapp.entity.Cliente;
import org.aartaraz.hibernateapp.util.JpaUtil;

import java.sql.SQLOutput;

public class HibernateFetchLazyOneToMany {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        Cliente cliente = em.find(Cliente.class, 1L);
        System.out.println(cliente.getNombre() + ", direcciones: " + cliente.getDirecciones());
        em.close();
    }
}
