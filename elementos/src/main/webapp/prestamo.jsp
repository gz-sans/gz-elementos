<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Prestamo" %>
<%@ page import="controller.PrestamoController" %>

<%
PrestamoController prestamoController = new PrestamoController();
List<Prestamo> prestamos = prestamoController.obtenerTodosLosPrestamos();
request.setAttribute("prestamos", prestamos);
%>

<!DOCTYPE html>
<html>
<head>
    <title>Gestión de Préstamos</title>
</head>
<body>
    <h1>Lista de Préstamos</h1>

    <table border="1">
        <tr>
            <th>ID Préstamo</th>
            <th>ID Usuario</th>
            <th>ID Elemento</th>
            <th>Fecha Préstamo</th>
            <th>Fecha Devolución</th>
        </tr>
        <%
        for (Prestamo prestamo : prestamos) {
        %>
        <tr>
            <td><%= prestamo.getIdPrestamo() %></td>
            <td><%= prestamo.getIdUsuario() %></td>
            <td><%= prestamo.getIdElemento() %></td>
            <td><%= prestamo.getFechaPrestamo() %></td>
            <td><%= prestamo.getFechaDevolucion() %></td>
        </tr>
        <%
        }
        %>
    </table>

    <h1>Agregar Préstamo</h1>
    <form method="post" action="prestamo">
        <label for="usuario">ID Usuario:</label>
        <input type="text" name="usuario" required>
        <br>
        <label for="elemento">ID Elemento:</label>
        <input type="text" name="elemento" required>
        <br>
        <label for="fechaPrestamo">Fecha Préstamo:</label>
        <input type="date" name="fechaPrestamo" required>
        <br>
        <label for="fechaDevolucion">Fecha Devolución:</label>
        <input type="date" name="fechaDevolucion" required>
        <br>
        <input type="submit" value="Agregar Préstamo">
    </form>
</body>
</html>
