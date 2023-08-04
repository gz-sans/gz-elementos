package controller;

import model.CategoriaDao;
import model.CategoriaVo;


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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "list":
                mostrarCategorias(request, response);
                break; 

              case "en_categoria" : 
               request.getRequestDispatcher("resgitrar_c.jsp").forward(request, response);
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
            case "en_categoria":
                crearCategoria(request, response);
                break;
            default:
                // Acción por defecto, puedes redirigir o mostrar una página de error
                break;
        }
    }

    public  List<CategoriaVo> mostrarCategorias(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<CategoriaVo> categorias = categoriaDao.obtenerCategorias();
         /*    request.setAttribute("categorias", categorias);  */
            return  categorias;
        }  
            catch (SQLException e) {
            e.printStackTrace();
            // Manejo de errores
        }
        return null;
    }
   

public void c_categoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.getRequestDispatcher("views/registrar_c.jsp").forward(request, response);;
        }  
            catch (ServletException e) {
            e.printStackTrace();
            // Manejo de errores
        }
    }


    private void crearCategoria(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nombreCategoria = request.getParameter("n_categoria");
        String descripcionCategoria = request.getParameter("d_categoria");
        CategoriaVo categoria = new CategoriaVo();
        categoria.setNombreCategoria(nombreCategoria);
        categoria.setDescripcionCategoria(descripcionCategoria);
        try {
            categoriaDao.crearCategoria(categoria);
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de errores
        }
    }

   /*  @Override
    public void destroy() {
        super.destroy();
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de errores
        }
    } */
}
