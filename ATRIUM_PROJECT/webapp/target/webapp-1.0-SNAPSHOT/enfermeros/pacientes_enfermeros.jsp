<%@page import="org.aartaraz.webapp.entidades.Persona" %>
<%@page import="org.aartaraz.webapp.consultas.PersonasDAO" %>
<%@page import="org.aartaraz.webapp.entidades.Roles" %>
<%@page import="org.aartaraz.webapp.consultas.RolesDAO" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Pacientes por Enfermero</title>
    <%@include file="../comunes/css.jsp" %>

</head>
<body>

<%@include file="../comunes/menu.jsp" %>

<%
    Persona enfermero = PersonasDAO.obtener_persona_id(Integer.parseInt(request.getParameter("id")));
    ArrayList<Persona> pacientes = PersonasDAO.pacientes_enfermero(enfermero.getId());
    ArrayList<Persona> pacientes_no_asignados = PersonasDAO.pacientes_no_asignados();
%>

<div class="container">

    <div class="row mb-5">
        <div class="col-lg-12 text-center mt-3">
            <h1 class="text-center">Enfermero: <%=enfermero.getNombre()%>
            </h1>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-3 mt-3">
            <h3 class="text-center">Asignados</h3>
            <% for (int i = 0; i < pacientes.size(); i++) { %>
            <div class="row text-center mb-3">
                <div class="col-lg-12">
                    <div class="card">
                        <i class="fa fa-user fa-4x text-center mt-3 text-danger"></i>
                        <div class="card-body">
                            <h5 class="card-title"><%=pacientes.get(i).getNombre() %>
                                <b>(<%=pacientes.get(i).getEdad() %>)</b></h5>
                            <p class="card-text"><%=pacientes.get(i).getDireccion() %>
                            </p>
                            <p class="card-text"><%=pacientes.get(i).getEmail() %>
                            </p>
                            <a href="eliminar_enfermero_paciente?id_paciente=<%=pacientes.get(i).getId()%>&id_enfermero=<%=enfermero.getId()%>"
                               class="btn btn-danger">Eliminar</a>
                        </div>
                    </div>
                </div>
            </div>
            <%
                }
            %>
        </div>
        <div class="col-lg-9">
            <div class="row">
                <div class="col-lg-12 mt-3">
                    <h3 class="text-center">No asignados</h3>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12 mt-3">
                    <% if (pacientes.size() < 3) { %>
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>DNI</th>
                            <th>Teléfono</th>
                            <th>Email</th>
                            <th>Edad</th>
                            <th>Direccion</th>
                            <th>Opciones</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            for (int i = 0; i < pacientes_no_asignados.size(); i++) {
                        %>
                        <tr>
                            <td><%=pacientes_no_asignados.get(i).getId()%>
                            </td>
                            <td><%=pacientes_no_asignados.get(i).getNombre()%>
                            </td>
                            <td><%=pacientes_no_asignados.get(i).getDni()%>
                            </td>
                            <td><%=pacientes_no_asignados.get(i).getTelefono()%>
                            </td>
                            <td><%=pacientes_no_asignados.get(i).getEmail()%>
                            </td>
                            <td><%=pacientes_no_asignados.get(i).getEdad()%>
                            </td>
                            <td><%=pacientes_no_asignados.get(i).getDireccion()%>
                            </td>
                            <td>
                                <a href="asignar_enfermero_paciente?id_paciente=<%=pacientes_no_asignados.get(i).getId()%>&id_enfermero=<%=enfermero.getId()%>"
                                   class="btn btn-primary text-white"><i
                                        class="fa fa-plus"></i></a></td>
                        </tr>
                        <%
                            }
                        %>
                        </tbody>
                    </table>
                    <% } %>
                </div>
            </div>
        </div>
    </div>

</div>

<%@include file="../comunes/js.jsp" %>
</body>
</html>
