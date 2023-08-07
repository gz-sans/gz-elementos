package controller;

import model.Conexion;
import model.Prestamo;
import model.PrestamoDAO;

import java.util.List;

public class PrestamoController {
    private PrestamoDAO prestamoDAO;

    public PrestamoController() {
        Conexion conexion = new Conexion();
      /*   prestamoDAO = new PrestamoDAO(conexion.conectar()); */
    }

    // Método para agregar un nuevo préstamo
    public void agregarPrestamo(int idUsuario, int idElemento, java.sql.Date fechaPrestamo, java.sql.Date fechaDevolucion) {
        Prestamo prestamo = new Prestamo(idUsuario, idElemento, fechaPrestamo, fechaDevolucion);
        prestamoDAO.agregarPrestamo(prestamo);
    }

    // Método para actualizar un préstamo existente
    public void actualizarPrestamo(int idPrestamo, int idUsuario, int idElemento, java.sql.Date fechaPrestamo, java.sql.Date fechaDevolucion) {
        Prestamo prestamo = new Prestamo(idUsuario, idElemento, fechaPrestamo, fechaDevolucion);
        prestamo.setIdPrestamo(idPrestamo);
        prestamoDAO.actualizarPrestamo(prestamo);
    }

    // Método para eliminar un préstamo por su ID
    public void eliminarPrestamo(int idPrestamo) {
        prestamoDAO.eliminarPrestamo(idPrestamo);
    }

    // Método para obtener todos los préstamos
    public List<Prestamo> obtenerTodosLosPrestamos() {
        return prestamoDAO.obtenerTodosLosPrestamos();
    }
}
