<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.Date" %>
<%@ page import="controller.PrestamoController, ElementoController, UsuarioController" %>

<%-- Obtener los parámetros del formulario --%>
<%
int idUsuario = Integer.parseInt(request.getParameter("usuario"));
int idElemento = Integer.parseInt(request.getParameter("elemento"));
Date fechaPrestamo = Date.valueOf(request.getParameter("fechaPrestamo"));
Date fechaDevolucion = Date.valueOf(request.getParameter("fechaDevolucion"));

PrestamoController prestamoController = new PrestamoController();
prestamoController.agregarPrestamo(idUsuario, idElemento, fechaPrestamo, fechaDevolucion);
%>

<!DOCTYPE html>
<html>
<head>
    <title>Préstamo Agregado</title>
</head>
<body>
    <h1>Préstamo Agregado Exitosamente</h1>
    <a href="prestamo.jsp">Volver a la lista de préstamos</a>
</body>
</html>
