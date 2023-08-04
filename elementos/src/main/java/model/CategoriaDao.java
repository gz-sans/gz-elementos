package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDao { 

    private Connection con;

    public void CategoriaDAO(Connection con) {
        this.con = con;
    }

/*     Connection con; //objeto de conexión */
    PreparedStatement ps; //preparar sentencias
    ResultSet rs; // almacenar consutas
    String sql=null;
    int r; //cantidad de filas que devuelve una sentencia

    public void crearCategoria(CategoriaVo categoria) throws SQLException {
        String sql = "INSERT INTO Categoria (nombreCategoria, DescripcionCategoria) VALUES (?, ?)";
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, categoria.getNombreCategoria());
            statement.setString(2, categoria.getDescripcionCategoria());
            r = ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se registró el rol correctamente");
        }
    }

    public List<CategoriaVo> obtenerCategorias() throws SQLException {
        List<CategoriaVo> categorias = new ArrayList<>();
        String sql = "SELECT nombreCategoria FROM Categoria";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    CategoriaVo categoria = new CategoriaVo();
                    categoria.setNombreCategoria(resultSet.getString("nombreCategoria"));
                    categoria.setDescripcionCategoria(resultSet.getString("DescripcionCategoria"));
                    categorias.add(categoria); 
                    System.out.println(sql);
                    System.out.println(r); 
               r = ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se consulto categoria");
                }
            }
        }

        return categorias;
    }
}
