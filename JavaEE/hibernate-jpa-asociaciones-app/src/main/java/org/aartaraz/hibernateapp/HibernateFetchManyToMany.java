package org.aartaraz.hibernateapp;

import jakarta.persistence.EntityManager;
import org.aartaraz.hibernateapp.entity.Alumno;
import org.aartaraz.hibernateapp.util.JpaUtil;

import java.util.List;

public class HibernateFetchManyToMany {
    public static void main(String[] args) {

        EntityManager em= JpaUtil.getEntityManager();

        //left join para hacer consulta de alumnos que tengan o no cursos, si solo quisieses alumnos con relacion de cursos inner join. De esta forma solo te hace una consulta
        List<Alumno> alumnos = em.createQuery("select distinct a from Alumno a left outer join fetch a.cursos", Alumno.class).getResultList();
        alumnos.forEach(a-> System.out.println(a.getNombre() + ", cursos: " + a.getCursos()));
        em.close();
    }
}
