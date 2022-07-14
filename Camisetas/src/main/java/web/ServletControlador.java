package web;

import data.CamisetasDAO;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import model.*;

@WebServlet("/servletControlador")
public class ServletControlador extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest req , HttpServletResponse res) throws ServletException, IOException{
        String accion = req.getParameter("accion");
        
        if(accion!=null){
            switch(accion){
                case "eliminar":
                    break;
                case "editar":
                    editarCamiseta(req, res);
                    break;
                default:
                    accionDefault(req, res);
                    break;
            }
        }else{
            accionDefault(req, res);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req , HttpServletResponse res)throws ServletException, IOException{
        String queryParam = req.getParameter("accion");
        if(queryParam!=null){
            switch(queryParam){
                case "insertar":
                    insertarCamiseta(req,res);
                    break;
                case "modificar":
                    break;
                default:
                    accionDefault(req,res);
                    break;
            }
        }
    }
    
    private void accionDefault(HttpServletRequest req , HttpServletResponse res) throws ServletException, IOException{
        List <Camisetas> camisetas = new CamisetasDAO().findAll();
        camisetas.forEach(System.out::println);
        HttpSession sesion = req.getSession();
        sesion.setAttribute("camisetas", camisetas);
        sesion.setAttribute("cantidadCamisetas",calcularStock(camisetas));
        sesion.setAttribute("precioTotal", calcularPrecio(camisetas));
//        req.getRequestDispatcher("libros.jsp").forward(req, res);
        res.sendRedirect("camisetas.jsp");
    }
    
    private void insertarCamiseta(HttpServletRequest req , HttpServletResponse res) throws ServletException, IOException{
        String equipo = req.getParameter("equipo");        
        int numero = Integer.parseInt(req.getParameter("numero"));
        String jugador = req.getParameter("jugador");
        String talle = req.getParameter("talle");
        double precio = Double.parseDouble(req.getParameter("precio"));
        int stock = Integer.parseInt(req.getParameter("stock"));
        
        Camisetas camiseta = new Camisetas(equipo, numero, jugador, talle, precio, stock);
        
        int registrosMod = new CamisetasDAO().insert(camiseta);
        
        System.out.println("insertados = " + registrosMod);
        
        accionDefault(req, res);
    }
    
    private void editarCamiseta(HttpServletRequest req , HttpServletResponse res) throws ServletException, IOException{
        int idCamiseta = Integer.parseInt(req.getParameter("idcamiseta"));
        Camisetas camiseta = new CamisetasDAO().findById(idCamiseta);
        req.setAttribute("camiseta", camiseta);
        String jspEditar = "/WEB-INF/paginas/operaciones/editar.jsp";
        req.getRequestDispatcher(jspEditar).forward(req, res);
    }
    
    private int calcularStock(List<Camisetas> camisetas){
        int cant=0;
        for (int i = 0; i < camisetas.size(); i++) {
            cant += camisetas.get(i).getStock();
        }
        return cant;
    }
    
    private double calcularPrecio(List<Camisetas> camiseta){
        double precio = 0;
        for (int i = 0; i < camiseta.size(); i++) {
            precio += (camiseta.get(i).getPrecio() * camiseta.get(i).getStock());
        }
        return precio;
    }
}
