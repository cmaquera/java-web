/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;
import org.json.simple.*;

/**
 *
 * @author anon
 */
@WebServlet(name = "conPedido", urlPatterns = {"/conPedido"})
public class conPedido extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }
    
    protected void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try{
            CListaPedido olPedido= new CListaPedido();
               
              JSONObject objx =  new JSONObject();
            
               JSONArray arr =  new JSONArray();
                for (int i = 0; i < olPedido.cantPedido(); i++) {
                    CPedido opedido = olPedido.elemento(i);
                    JSONObject obj = new JSONObject();

                    obj.put("codigo", opedido.getCodigo());
                    obj.put("cliente", opedido.getCliente().getNombres());
                    obj.put("importe", opedido.getImporte());
                    obj.put("fecha", opedido.getFecha());
                    obj.put("local", opedido.getLocal().getNombre());
                   
                    arr.add(obj);
                }
                
                objx.put("data",arr);
  
            response.getWriter().write(objx.toJSONString());         
            
        }catch(Exception ex){
            response.setContentType("text/html");
            response.getWriter().write(ex.toString());
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String Action = request.getParameter("Action");
        
        if(Action.equals("listPedido"))
            listar(request, response);
        
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
