package org.aartaraz.apiservlet.webapp.headers.services;

//Esta clase la implementamos para que la poder tratar la excepcion, recogerla en ProductoServiceJdbcImpl y pasarla a
// al ConexionFilter para que haga cerrar la BBDD y no casque error. Asi podremos hacer un rollback
public class ServiceJdbcException extends RuntimeException{

    public ServiceJdbcException(String message) {
        super(message);
    }

    public ServiceJdbcException(String message, Throwable cause) {
        super(message, cause);
    }
}
