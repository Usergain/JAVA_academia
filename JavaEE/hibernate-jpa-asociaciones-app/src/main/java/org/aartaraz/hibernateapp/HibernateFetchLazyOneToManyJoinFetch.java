package org.aartaraz.hibernateapp;

import jakarta.persistence.EntityManager;
import org.aartaraz.hibernateapp.entity.Cliente;
import org.aartaraz.hibernateapp.util.JpaUtil;
public class HibernateFetchLazyOneToManyJoinFetch {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        //fetch puebla datos en el join->Optimizando las consultas, en solo una consulta
        Cliente cliente = em.createQuery("select c from Cliente c left outer join fetch c.direcciones left join fetch c.detalle where  c.id=:id", Cliente.class).setParameter("id", 1L).getSingleResult();
        System.out.println(cliente.getNombre() + ", direcciones: " + cliente.getDirecciones());
        System.out.println(cliente.getNombre() + ", detalles: " + cliente.getDetalle());
        em.close();
    }
}
