package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDao {
    private Connection connection;

    public CategoriaDao(Connection connection) {
        this.connection = connection;
    }

    public void crearCategoria(CategoriaVo categoria) throws SQLException {
        String query = "INSERT INTO Categoria (nombreCategoria, DescripcionCategoria) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, categoria.getNombreCategoria());
            statement.setString(2, categoria.getDescripcionCategoria());
            statement.executeUpdate();
        }
    }

    public List<CategoriaVo> obtenerCategorias() throws SQLException {
        List<CategoriaVo> categorias = new ArrayList<>();
        String query = "SELECT * FROM Categoria";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    CategoriaVo categoria = new CategoriaVo();
                    categoria.setIdCategoria(resultSet.getInt("IdCategoria"));
                    categoria.setNombreCategoria(resultSet.getString("nombreCategoria"));
                    categoria.setDescripcionCategoria(resultSet.getString("DescripcionCategoria"));
                    categorias.add(categoria);
                }
            }
        }

        return categorias;
    }
}
