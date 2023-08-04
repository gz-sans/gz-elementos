package controller;

import model.CategoriaDao;
import model.CategoriaVo;
import model.Conexion;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Categoria extends HttpServlet {
    private Connection connection;
    private CategoriaDao categoriaDao;

    @Override
    public void init() throws ServletException {
        super.init();
        connection = Conexion.conectar();
        categoriaDao = new CategoriaDao(connection);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "list":
                mostrarCategorias(request, response);
                break;
            default:
                // Acción por defecto, puedes redirigir o mostrar una página de error
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "create":
                crearCategoria(request, response);
                break;
            default:
                // Acción por defecto, puedes redirigir o mostrar una página de error
                break;
        }
    }

    private void mostrarCategorias(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<CategoriaVo> categorias = categoriaDao.obtenerCategorias();
            request.setAttribute("categorias", categorias);
            request.getRequestDispatcher("categorias.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de errores
        }
    }

    private void crearCategoria(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nombreCategoria = request.getParameter("nombre");
        String descripcionCategoria = request.getParameter("descripcion");

        CategoriaVo categoria = new CategoriaVo();
        categoria.setNombreCategoria(nombreCategoria);
        categoria.setDescripcionCategoria(descripcionCategoria);

        try {
            categoriaDao.crearCategoria(categoria);
            response.sendRedirect(request.getContextPath() + "/categorias?action=list");
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de errores
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de errores
        }
    }
}
