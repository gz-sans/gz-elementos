<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="model.ElementosDao" %>
<%@ page import="model.ElementosVo" %>
<%@ page import="model.CategoriaDao" %>
<%@ page import="model.CategoriaVo" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/shady.css">
    <link rel="icon" href="assets/source/ventana.png">
    <title>Registrar elementos</title>
</head>
<body>
    <header>
        <div class="logo">
            <img src="assets/source/sena.png">
            <h1>  | Sistema Inventario</h1>
            <div class="btnsup"> 
                <button>Consulta x serial</button>
                <button>Toma virtual</button>
                <button>Acceso</button>
                <button>Catalogo</button>
                <button>Test defectos</button>
            </div>
        </div>
    </header>
    <nav>
        <div class="contenedor">
            <form class="formu" action="elemento" method="post">
                <% if (request.getAttribute("error") != null) { %>
                    <div style="color: red; margin-bottom: 10px;">
                        <%= request.getAttribute("error") %>
                    </div>
                <% } %>
                <label>Nombre:</label>
                <input type="text" name="NombreElemento" id="NombreElemento" required>
                <label>N° placa:</label>
                <input type="text" name="N_placa" id="N_placa" required>
                <label>Cantidad:</label>
                <input type="text" name="cantidad" id="cantidad" required>
                <label>Costo:</label>
                <input type="text" name="Costo" id="Costo" required>
                <label>Tipo:</label>
                <select class="desp" name="TipoElemento" id="TipoElemento" required>
                    <option disabled selected value="">Seleccionar el tipo</option>
                    <option>Consumo</option>
                                   <option>Desechable</option>
                </select>
                <label>Fecha Ingreso:</label>
                <input type="date" name="FechaIngresoElemento" id="FechaIngresoElemento" required>
                <label>Categoría:</label>
                <select class="desp" name="categoriaElemento" id="categoriaElemento" required>
                    <option disabled selected value="">Seleccionar una categoria</option>


              <!--   iteracion para las categorias  : se hizo con un for each importando la lista desde el modelo dao de categorias -->
                 <%   
                 CategoriaDao cd = new CategoriaDao();
                 List<CategoriaVo> categorias=cd.obtenerCategorias();
                        for (CategoriaVo categoria : categorias ) { %>                   
                       <option value=><%= categoria.getNombreCategoria() %>   </option>   
              <% } %>



                </select>
                <label>N° Aula:</label>
                <input type="text" name="NumAula" id="NumAula">
                <label>Descripcion:</label>
                <input type="text" name="Descripcion" id="Descripcion" required>
                <label>Estado:</label>
                <select class="desp" name="EstadoElemento" id="EstadoElemento" required>
                    <option disabled selected value="">Seleccionar el Estado del elemento </option>
                    <option>Activo</option>
                    <option>Inactivo</option>
                </select>
                <button type="submit" name="accion" value="add">REGISTRO</button>
            </form>
            <div class="btngrupo">
                <aside class="extra">
                    <a href="elemento?accion=listar">
                        <button><center>Consultar Elementos registrados</center></button>
                    </a>
                    <button>Registrar Usuarios</button>
                    <button>Consultar usuarios registrados en el sistema</button>
                    <button>Consultar prestamos</button>
              <!--   boton para redireccionar a el servlet elemento para el formulario de creacion de  categoria en el servlet  elementos   -->
                    <a href="elemento?accion=c_categoria">    
                       <button> Crear nueva categoria </button>
                    </a>
                </aside>
            </div>
        </div>
    </nav>
    <footer class="end0">
        <div class="end1">
            <h1><a class="link" href="https://www.sena.edu.co/">WWW.SENA.EDU.CO</a></h1>
        </div>
        <div class="end2">
            <legend>Equipo de desarrollo</legend>
            <ul class="lista">
                <li>Michael Josué Rico</li>
                <li>Juan Camilo Torres Ávila</li>
                <li>Luis Carlos Galindo Flórez</li>
                <li>Duvan Felipe Sánchez Leguizamón</li>
                <li>Kevin Andrés Mora Castañeda</li>
            </ul>
        </div>
    </footer>
</body>
</html>
