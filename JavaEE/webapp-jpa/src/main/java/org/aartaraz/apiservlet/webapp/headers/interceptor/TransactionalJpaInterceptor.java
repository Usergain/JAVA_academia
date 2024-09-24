package org.aartaraz.apiservlet.webapp.headers.interceptor;

import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import jakarta.persistence.EntityManager;
import org.aartaraz.apiservlet.webapp.headers.services.ServiceJdbcException;

import java.util.logging.Logger;


@TransactionalJpa
@Interceptor
public class TransactionalJpaInterceptor {

    @Inject
    private EntityManager em;

    @Inject
    private Logger log;

    @AroundInvoke
    public Object transactional(InvocationContext invocation) throws Exception {

        try {
            log.info(" ------> iniciando transacción " + invocation.getMethod().getName() +
                    " de la clase " + invocation.getMethod().getDeclaringClass());
            em.getTransaction().begin();
            Object resultado = invocation.proceed();
            em.getTransaction().commit();
            log.info(" ------> iniciando transacción " + invocation.getMethod().getName() +
                    " de la clase " + invocation.getMethod().getDeclaringClass());
            return resultado;
        } catch (ServiceJdbcException e) {
            em.getTransaction().rollback();
            throw e;
        }
    }
}
