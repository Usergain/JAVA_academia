package org.aartaraz.hibernateapp;

import jakarta.persistence.EntityManager;
import org.aartaraz.hibernateapp.entity.Cliente;
import org.aartaraz.hibernateapp.entity.Direccion;
import org.aartaraz.hibernateapp.util.JpaUtil;

public class HibernateAsociacionesOneToManyFind {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Cliente cliente = em.find(Cliente.class, 2L);

            Direccion d1 = new Direccion("el vergel", 123);
            Direccion d2 = new Direccion("Elcano", 456);

            cliente.getDirecciones().add(d1);
            cliente.getDirecciones().add(d2);
            em.merge(cliente);

            em.getTransaction().commit();

            System.out.println(cliente);

            em.getTransaction().begin();
            d1=em.find(Direccion.class, 1L);
            cliente.getDirecciones().remove(d1);
            em.getTransaction().commit();
            System.out.println(cliente);
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
