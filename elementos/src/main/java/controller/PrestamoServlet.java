package controller;

import model.Conexion;
import model.Prestamo;
import model.PrestamoDAO;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/prestamo")
public class PrestamoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PrestamoDAO prestamoDAO;

    public PrestamoServlet() {
        super();
        Conexion conexion = new Conexion();
      /*   prestamoDAO = new PrestamoDAO(conexion.conectar()); */
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Prestamo> prestamos = prestamoDAO.obtenerTodosLosPrestamos();
        request.setAttribute("prestamos", prestamos);
        request.getRequestDispatcher("prestamo.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idUsuario = Integer.parseInt(request.getParameter("usuario"));
        int idElemento = Integer.parseInt(request.getParameter("elemento"));
        Date fechaPrestamo = Date.valueOf(request.getParameter("fechaPrestamo"));
        Date fechaDevolucion = Date.valueOf(request.getParameter("fechaDevolucion"));

        Prestamo prestamo = new Prestamo(idUsuario, idElemento, fechaPrestamo, fechaDevolucion);
        prestamoDAO.agregarPrestamo(prestamo);

        response.sendRedirect(request.getContextPath() + "/prestamo");
    }
}
