<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="model.ElementosDao" %>
<%@ page import="model.ElementosVo" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/Listas.css">
    <link rel="icon" href="assets/source/ventana.png">
    <title>Consultas</title>
</head>
<body>
    <header class="presen">
        <a href="index.jsp">Volver</a>
        <!-- Encabezado del header -->
    </header>
    <article class="contenedor">
        <div class="search-bar">
            <form action="elemento" method="GET">
                <input type="text" name="placa" placeholder="Buscar por N° de placa">
                <button type="submit" name="accion" value="buscar_elementos">Buscar</button>
            </form>
            <form action="elemento" method="GET">
                <select class="desp" name="TipoElemento" id="TipoElemento">
                    <option disabled selected value="">Seleccionar el tipo</option>
                    <option>Consumo</option>
                    <option>Desechable</option>
                </select>
                <button type="submit" name="accion" value="buscar_tipo">Buscar</button>
            </form>
        </div>
        <div class="subCont">
            <table class="tabla">
                <thead>
                    <tr id="cabecera">
                        <th>Nombre</th>
                        <th>N° placa</th>
                        <th>Cantidad</th>
                        <th>Costo</th>
                        <th>Tipo</th>
                        <th>Fecha de Ingreso</th>
                        <th>Categoría</th>
                        <th>N° aula</th>
                        <th>Descripción</th>
                        <th>Estado</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                    ElementosDao elementosDao = new ElementosDao();
                    List<ElementosVo> elementos;
                    String placa = request.getParameter("placa");
                    if (placa != null && !placa.isEmpty()) {
                        elementos = elementosDao.buscarPorNumeroPlaca(placa);
                    } else {
                        String tipo = request.getParameter("TipoElemento");
                        if (tipo != null && !tipo.isEmpty()) {
                            elementos = elementosDao.buscarPorTipo(tipo);
                        } else {
                            elementos = elementosDao.listar();
                        }
                    }
                    for (ElementosVo elemento : elementos) {
                    %>
                    <tr id="campo">
                        <td><%= elemento.getNombre()%></td>
                        <td><%= elemento.getNumeroPlaca()%></td>
                        <td><%= elemento.getCantidad()%></td>
                        <td><%= elemento.getCosto()%></td>
                        <td><%= elemento.getTipo()%></td>
                        <td><%= elemento.getFechaIngreso()%></td>
                        <td><%= elemento.getCategoria()%></td>
                        <td><%= elemento.getNumeroAula()%></td>
                        <td><%= elemento.getDescripcion()%></td>
                        <td><%= elemento.getEstado()%></td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </article>
    <footer class="end0">
        <!-- Pie de página -->
    </footer>
</body>
</html>
