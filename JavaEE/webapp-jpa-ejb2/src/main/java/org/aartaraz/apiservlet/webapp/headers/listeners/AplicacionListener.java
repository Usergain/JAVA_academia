package org.aartaraz.apiservlet.webapp.headers.listeners;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class AplicacionListener implements ServletContextListener, ServletRequestListener, HttpSessionListener {
    private ServletContext servletContext;

    // De manera global
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().log("Inicializando la aplicación!");
        servletContext = sce.getServletContext();
        servletContext.setAttribute("mensaje", "algún valor global de la app!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        servletContext.log("Destruyendo la aplicación!");
    }

    // De manera individual
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        sre.getServletContext().log("Destruyendo el request!");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        servletContext.log("Inicializando el request!");
        sre.getServletRequest().setAttribute("mensaje", "guardando valor pare el request");
        sre.getServletRequest().setAttribute("title", "Catálogo Servlet");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        servletContext.log("Inicializando la sesión http");
        //Carro carro = new Carro();
        //HttpSession session = se.getSession();
        //session.setAttribute("carro", carro);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        servletContext.log("Destruyendo la sesión http");
    }
}
