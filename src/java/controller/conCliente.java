/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model.*;
/**
 *
 * @author root
 */
@WebServlet(name = "conCliente", urlPatterns = {"/conCliente"})
public class conCliente extends HttpServlet {

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
        try{
            HttpSession session;
            session = request.getSession();
            //String html = null;
            
            CListaCliente lCliente;
            
            if(session.getAttribute("LClientes") == null) lCliente = new CListaCliente();
            else lCliente = (CListaCliente)session.getAttribute("LClientes");
            
            if(request.getParameter("accion").equals("ingresar")){
                String correo =  request.getParameter("strcorreo");
                String contraseña = request.getParameter("strcontraseña");
                
                if(lCliente.BuscarUsuario(correo, contraseña) != null){
                    response.setContentType("text/html");
                    response.getWriter().write("te encontramos :D");
                }else{
                    response.setContentType("text/html");
                    response.getWriter().write("No te encontramos :(");
                }
                
            }
            
            if(request.getParameter("accion").equals("inscribir")){
                
                CCliente objCliente = new CCliente();
                
                objCliente.setDNI(request.getParameter("dni"));
                objCliente.setNombres(request.getParameter("nombre"));
                objCliente.setApellidos(request.getParameter("apellidos"));
                //objCliente.setDireccion(request.getParameter("direccion"));
                //objCliente.setTelefono(request.getParameter("telefono"));
                objCliente.setCorreo(request.getParameter("correo"));
                objCliente.setUsuario(request.getParameter("usuario"));
                objCliente.setContraseña(request.getParameter("contraseña"));
                
                String resultado = lCliente.insCliente(objCliente);
                
                session.setAttribute("LClientes",lCliente);
                
                response.setContentType("text/html");
                response.getWriter().write(resultado);
            }
            
        }catch(Exception ex){
            
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
        processRequest(request, response);
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