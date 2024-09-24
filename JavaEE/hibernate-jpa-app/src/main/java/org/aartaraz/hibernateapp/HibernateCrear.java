package org.aartaraz.hibernateapp;

import jakarta.persistence.EntityManager;
import org.aartaraz.hibernateapp.entity.Cliente;
import org.aartaraz.hibernateapp.util.JpaUtil;

import javax.swing.*;

public class HibernateCrear {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre:");
            String apellido = JOptionPane.showInputDialog("Ingrese el apellido:");
            String pago = JOptionPane.showInputDialog("Ingrese la forma de pago:");

            em.getTransaction().begin();

            Cliente c = new Cliente();
            c.setNombre(nombre);
            c.setApellido(apellido);
            c.setFormaPago(pago);
            em.persist(c);
            em.getTransaction().commit(); //insert
            System.out.println("El id del cliente registrado es " + c.getId());
            c = em.find(Cliente.class, c.getId()); //lo obtiene del cache del contexto del JPA
            System.out.println(c);
        } catch (Exception e) {
            em.getTransaction().rollback(); //en caso de error
            e.printStackTrace();
        } finally {
            em.close(); //siempre se cierra
        }
    }
}
