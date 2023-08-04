<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.ElementosDao" %>
<%@ page import="model.ElementosVo" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/shady.css">
    <title>Registrar elementos</title>
</head>
<body>
    <header>
        <div class="logo">
            <img src="assets/source/sena.png" alt="Sena Logo">
            <h1> | Sistema Inventario</h1>
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
            <form class="formu">
                <label for="valorElemento">nombre de la categoria</label>
                <input type="text" id="nombre">
                <label for="descripcion">Descripción:</label>
                <textarea id="descripcionCTG"></textarea>
                <button type="submit"><a class="link" href="index.jsp">REGISTRAR</a></button>
            </form>            
            <div class="btngrupo">
                <aside class="extra">
                    <button>Consultar comprobante de realización de toma virtual de inventarios</button>
                    <button><a class="link" href="index.jsp">volver</a></button>
                    <button>Transpasar bienes</button>
                    <button>Reintegrar bienes</button>
                    <button>Generar reporte de relación de bienes</button>
                </aside>
            </div>
        </div>
    </nav>
    <footer class="end0">
        <div class="end2">
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
