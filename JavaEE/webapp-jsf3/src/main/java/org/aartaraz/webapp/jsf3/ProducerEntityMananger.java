package org.aartaraz.webapp.jsf3;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RequestScoped
public class ProducerEntityMananger {

    @PersistenceContext(name="ejemploJpa")
    private EntityManager em;

    @Produces
    @RequestScoped
    private EntityManager beanEntityMananger(){
        return em;
    }
}
