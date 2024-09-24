package org.aartaraz.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//Es un request nuevo de otro ya existente
@WebServlet("/redirigir")
public class RedirigirServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.setHeader("Location", req.getContextPath() + "/productos.html");
        //resp.setStatus(HttpServletResponse.SC_FOUND);
        resp.sendRedirect(req.getContextPath() + "/productos.html");
    }
}
