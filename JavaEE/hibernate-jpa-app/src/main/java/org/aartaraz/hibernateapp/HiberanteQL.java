package org.aartaraz.hibernateapp;

import jakarta.persistence.EntityManager;
import org.aartaraz.hibernateapp.dominio.ClienteDto;
import org.aartaraz.hibernateapp.entity.Cliente;
import org.aartaraz.hibernateapp.util.JpaUtil;

import java.util.Arrays;
import java.util.List;

public class HiberanteQL {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        System.out.println("========== consulta todos ==========");
        List<Cliente> clientes = em.createQuery("select c from Cliente c", Cliente.class).getResultList();
        clientes.forEach(System.out::println);

        System.out.println("========== consulta por id ==========");
        Cliente cliente = em.createQuery("select c  from Cliente c where c.id=:id", Cliente.class).setParameter("id", 1L).getSingleResult();
        System.out.println(cliente);

        System.out.println("========== consulta solo el nombre por id ==========");
        String nombreCliente = em.createQuery("select c.nombre  from Cliente c where c.id=:id", String.class).setParameter("id", 2L).getSingleResult();
        System.out.println(nombreCliente);

        System.out.println("========== consulta por campos presonalizados ==========");
        Object[] objetoCliente = em.createQuery("select c.id, c.nombre, c.apellido  from Cliente c where c.id=:id", Object[].class).setParameter("id", 1L).getSingleResult();
        Long id = (Long) objetoCliente[0];
        String nombre = (String) objetoCliente[1];
        String apellido = (String) objetoCliente[2];
        System.out.println("id= " + id + " ,nombre= " + nombre + " ,apellido= " + apellido);

        System.out.println("========== consulta por campos presonalizados lista ==========");
        List<Object[]> registros = em.createQuery("select c.id, c.nombre, c.apellido  from Cliente c", Object[].class).getResultList();

        registros.forEach(reg -> {
            Long idCli = (Long) reg[0];
            String nombreCli = (String) reg[1];
            String apellidoCli = (String) reg[2];
            System.out.println("id= " + idCli + " ,nombre= " + nombreCli + " ,apellido= " + apellidoCli);

        });
        //Lo mismo que en el caso anterior reutilizando las variables anteriores
        /*for (Object[] reg : registros) {
            id = (Long) reg[0];
            nombre = (String) reg[1];
            apellido = (String) reg[2];
            System.out.println("id= " + id + " ,nombre= " + nombre + " ,apellido= " + apellido);
        }*/

        System.out.println("========== consulta por cliente y forma de pago ==========");
        registros = em.createQuery("select c, c.formaPago from Cliente c", Object[].class).getResultList();
        registros.forEach(reg -> {
            Cliente c = (Cliente) reg[0];
            String formaPago = (String) reg[1];
            System.out.println("formaPago= " + formaPago + ", " + c);
        });

        System.out.println("========== consulta que puebla y devuelve objeto de una clase personalizada ==========");
        clientes = em.createQuery("select new Cliente(c.nombre, c.apellido) from Cliente c", Cliente.class).getResultList();
        clientes.forEach(System.out::println);

        System.out.println("========== consulta que puebla y devuelve objeto DTO de una clase personalizada ==========");
        List<ClienteDto> clientesDto = em.createQuery("select new org.aartaraz.hibernateapp.dominio.ClienteDto(c.nombre, c.apellido) from Cliente c", ClienteDto.class).getResultList();
        clientesDto.forEach(System.out::println);

        System.out.println("========== consulta por nombre de clientes ==========");
        List<String> nombres = em.createQuery("select c.nombre from Cliente c", String.class).getResultList();
        nombres.forEach(System.out::println);

        System.out.println("========== consulta por nombre sin que se repitan de clientes ==========");
        nombres = em.createQuery("select distinct(c.nombre) from Cliente c", String.class).getResultList();
        nombres.forEach(System.out::println);

        System.out.println("========== consulta por forma de pago sin que se repitan de clientes ==========");
        List<String> formasPago = em.createQuery("select distinct(c.formaPago) from Cliente c", String.class).getResultList();
        formasPago.forEach(System.out::println);

        System.out.println("========== consulta con numero forma de pago ==========");
        Long totalFormasPago = em.createQuery("select count(distinct(c.formaPago)) from Cliente c", Long.class).getSingleResult();
        System.out.println(totalFormasPago);

        System.out.println("========== consulta con nombre y apellido concatenados ==========");

        /*nombres = em.createQuery("select concat(c.nombre, ' ',c.apellido) as nombreCompleto from Cliente c", String.class).getResultList();
        nombres.forEach(System.out::println);*/

        nombres = em.createQuery("select c.nombre || ' ' || c.apellido as nombreCompleto from Cliente c", String.class).getResultList();
        nombres.forEach(System.out::println);

        System.out.println("========== consulta con nombre y apellido concatenados en mayuscula ==========");
        nombres = em.createQuery("select upper(concat(c.nombre, ' ',c.apellido)) as nombreCompleto from Cliente c", String.class).getResultList();
        nombres.forEach(System.out::println);

        System.out.println("========== consulta para buscar por nombre ==========");
        String param = "and";
        clientes = em.createQuery("select c from Cliente c where c.nombre like:parametro", Cliente.class).setParameter("parametro", "%" + param + "%").getResultList();
        clientes.forEach(System.out::println);

        System.out.println("========== consulta por rangos ==========");
        clientes = em.createQuery("select c from Cliente c where c.nombre between 'J' and 'Q'", Cliente.class).getResultList();
        clientes.forEach(System.out::println);
        System.out.println("------------------------------------------");
        clientes = em.createQuery("select c from Cliente c where c.id between 2 and 5", Cliente.class).getResultList();
        clientes.forEach(System.out::println);

        System.out.println("========== consulta por orden ==========");
        clientes = em.createQuery("select c from Cliente c order by c.nombre asc", Cliente.class).getResultList();
        clientes.forEach(System.out::println);
        System.out.println("------------------------------------------");
        clientes = em.createQuery("select c from Cliente c order by c.nombre desc", Cliente.class).getResultList();
        clientes.forEach(System.out::println);
        System.out.println("------------------------------------------");
        clientes = em.createQuery("select c from Cliente c order by c.nombre asc, c.apellido desc ", Cliente.class).getResultList();
        clientes.forEach(System.out::println);

        System.out.println("========== consulta con total de registros de la tabla ==========");
        Long total = em.createQuery("select count(c) as total from Cliente c", Long.class).getSingleResult();
        System.out.println(total);

        System.out.println("========== consulta con valor minimo del id ==========");
        Long minId = em.createQuery("select min(c.id) as minimo from Cliente c", Long.class).getSingleResult();
        System.out.println(minId);

        System.out.println("========== consulta con valor ultimo del id ==========");
        Long maxId = em.createQuery("select max(c.id) as maximo from Cliente c", Long.class).getSingleResult();
        System.out.println(maxId);

        System.out.println("========== consulta del nombre y su largo ==========");
        registros = em.createQuery("select c.nombre, length(c.nombre) from Cliente c", Object[].class).getResultList();
        registros.forEach(reg -> {
            String nom = (String) reg[0];
            Integer largo = (Integer) reg[1];
            System.out.println("nombre= " + nom + " ,largo= " + largo);
        });

        System.out.println("========== consulta del nombre mas corto ==========");
        Integer minLargoNombre = em.createQuery("select min(length(c.nombre)) from Cliente c", Integer.class).getSingleResult();
        System.out.println(minLargoNombre);

        System.out.println("========== consulta del nombre mas largo ==========");
        Integer maxLargoNombre = em.createQuery("select max(length(c.nombre)) from Cliente c", Integer.class).getSingleResult();
        System.out.println(maxLargoNombre);

        System.out.println("========== consulta resumen funciones agregaciones count min max avg sum ==========");
        Object[] estadisticas = em.createQuery("select min(c.id), max(c.id), sum(c.id), count(c.id), avg(length(c.nombre) ) from Cliente c", Object[].class).getSingleResult();
        Long min = (Long) estadisticas[0];
        Long max = (Long) estadisticas[1];
        Long sum = (Long) estadisticas[2];
        Long count = (Long) estadisticas[3];
        Double avg = (Double) estadisticas[4];
        System.out.println("min= " + min + " ,max=" + max + " ,sum=" + sum + " , count= " + count + " ,avg=" + avg);

        System.out.println("========== subQuery: ==========");

        System.out.println("========== consulta por nombre mas corto y su longitud ==========");
        registros = em.createQuery("select c.nombre, length(c.nombre) from Cliente c where length(c.nombre)=(select min(length(c.nombre))from Cliente c)", Object[].class).getResultList();
        registros.forEach(reg -> {
            String nom = (String) reg[0];
            Integer largo = (Integer) reg[1];
            System.out.println("nombre= " + nom + " ,largo= " + largo);
        });

        System.out.println("========== consulta para obtener el último registro ==========");
        Cliente ultimoCliente = em.createQuery("select c from Cliente c where c.id=(select max(c.id) from Cliente c)", Cliente.class).getSingleResult();
        System.out.println(ultimoCliente);

        System.out.println("========== consulta where in ==========");
        clientes = em.createQuery("select c from Cliente c where c.id in :ids", Cliente.class).setParameter("ids", Arrays.asList(1L, 2L, 10L, 5L)).getResultList();
        clientes.forEach(System.out::println);

        em.close();
    }
}
