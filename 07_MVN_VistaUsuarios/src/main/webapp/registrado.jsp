<%-- 
    Document   : registrado
    Created on : 21-feb-2019, 23:21:10
    Author     : IEUser
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.vn.appusuarios.modelo.Usuario"%>
<%@page import="com.vn.appusuarios.modelo.logica.ServicioUsuarios"%>
<%@include file="head.jsp"%>
<%
	// ServicioUsuarios servicioU = (ServicioUsuarios) request.getAttribute("servicioUsu");
%>
<html>
<body>
	<%=head()%>
	<%@include file="header.jsp"%>
	<h1>Registrado correctamente</h1>
	<%--         <h2 style="color: green;">
            <!-- Dentro del codigo Java tenemos el objeto session -->
            ID: <%= servicioU.leer(usuario.getEmail()).getId()%>
            <br/>
            Nombre: <%= servicioU.leer(usuario.getEmail()).getNombre()%>
        </h2> --%>

	<h2 style="color: green;">
		<!-- Dentro del codigo Java tenemos el objeto session -->
		ID:
		<c:out value="${usuario.id}"></c:out>
		<%-- 		<%=usuario.getId()%> --%>
		<br /> Nombre:
		<%-- 		<%=usuario.getNombre()%> --%>
		<c:out value="${usuario.nombre}"></c:out>
	</h2>
</body>
</html>
