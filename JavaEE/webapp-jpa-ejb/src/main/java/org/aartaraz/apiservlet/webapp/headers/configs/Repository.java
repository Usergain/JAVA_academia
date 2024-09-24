package org.aartaraz.apiservlet.webapp.headers.configs;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Stereotype;
import jakarta.inject.Named;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

//@Transactional -> Asi no haría falta pasar las transacciones por el filtro, de momento nada
@RequestScoped
@Named
@Stereotype
@Retention(RUNTIME)
@Target(ElementType.TYPE)
public @interface Repository {
}
