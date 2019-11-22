<%-- 
    Document   : lista_bbdd
    Created on : 22-nov-2019, 11:24:12
    Author     : pc
--%>

<%@page import="com.vn.appweb.modelo.ConsultaSQL"%>
<%@page import="java.util.List"%>
<%@page import="com.vn.appweb.modelo.DatosPersona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado JSP con DerbyDB</title>
    </head>
    <body>
        <h1>Listado JSP con DerbyDB</h1>
        <%
            out.println("<p>Hola desde Java en URL " + request.getContextPath() + "</p>");
        %>
        <br/>
        <ol>
            <%
                for (int i = 1; i <= 3; i++) {
            %>
            <li> Número <%=i%></li>
                <% } %>
        </ol>

        <form action="./lista_bbdd.jsp" method="POST">
            <label>Busqueda:</label>
            <input type="text" name="busq" placeholder="Patrón" size="20"/>
            <input type="submit" value="jsp_submit"/>
        </form>
        
        <%
            ConsultaSQL conSQL = new ConsultaSQL();
            String parametro = request.getParameter("busq");
            List<DatosPersona> listaPer = conSQL.leerTabla(parametro);
        %>

        <table>
            <thead>
                <tr>
                    <th>Nombre</th><th>Email</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (DatosPersona dp : listaPer) {
                %>
                <tr>
                    <td><%=dp.getNombre()%></td><td><%=dp.getEmail()%></td>
                </tr>
                <% }%>
            </tbody>
        </table>
    </body>
</html>
