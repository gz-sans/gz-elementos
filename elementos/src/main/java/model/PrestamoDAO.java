package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrestamoDAO {
    private Connection con;

    public PrestamoDAO(Connection con) {
        this.con = con;
    }

    // Método para agregar un nuevo préstamo
    public void agregarPrestamo(Prestamo prestamo) {
        String sql = "INSERT INTO Prestamos (IdUsuario, IdElemento, FechaPrestamo, FechaDevolucion) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, prestamo.getIdUsuario());
            stmt.setInt(2, prestamo.getIdElemento());
            stmt.setDate(3, prestamo.getFechaPrestamo());
            stmt.setDate(4, prestamo.getFechaDevolucion());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al agregar el préstamo: " + e.getMessage());
        }
    }

    // Método para actualizar un préstamo existente
    public void actualizarPrestamo(Prestamo prestamo) {
        String sql = "UPDATE Prestamos SET IdUsuario = ?, IdElemento = ?, FechaPrestamo = ?, FechaDevolucion = ? WHERE IdPrestamo = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, prestamo.getIdUsuario());
            stmt.setInt(2, prestamo.getIdElemento());
            stmt.setDate(3, prestamo.getFechaPrestamo());
            stmt.setDate(4, prestamo.getFechaDevolucion());
            stmt.setInt(5, prestamo.getIdPrestamo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el préstamo: " + e.getMessage());
        }
    }

    // Método para eliminar un préstamo por su ID
    public void eliminarPrestamo(int idPrestamo) {
        String sql = "DELETE FROM Prestamos WHERE IdPrestamo = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, idPrestamo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar el préstamo: " + e.getMessage());
        }
    }

    // Método para obtener todos los préstamos
    public List<Prestamo> obtenerTodosLosPrestamos() {
        List<Prestamo> prestamos = new ArrayList<>();
        String sql = "SELECT * FROM Prestamos";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Prestamo prestamo = new Prestamo(
                    rs.getInt("IdUsuario"),
                    rs.getInt("IdElemento"),
                    rs.getDate("FechaPrestamo"),
                    rs.getDate("FechaDevolucion")
                );
                prestamo.setIdPrestamo(rs.getInt("IdPrestamo"));
                prestamos.add(prestamo);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los préstamos: " + e.getMessage());
        }
        return prestamos;
    }
}
