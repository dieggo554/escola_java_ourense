/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.appweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pc
 */
public class ParamServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param peticionHttp servlet request
     * @param respuestaHttp servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest peticionHttp, HttpServletResponse respuestaHttp)
            throws ServletException, IOException {
        respuestaHttp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = respuestaHttp.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ParamServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ParamServlet at " + peticionHttp.getContextPath() + "</h1>");
            out.println("<h2>Formulario de registro</h2>");
            // Campos a enviar: nombre e email, obligatorios y con su validación HTML5
            out.println("<form name='formDatos' action='./formulario' method='POST'>");
            out.println("<label>Nombre: </label>");
            out.println("<input id='nombre_campo' name='nombre_campo' type='text' placeholder='Nombre' required></input>");
            out.println("<br/>");
            out.println("<label>Email: </label>");
            out.println("<input id='email_campo' name='email_campo' type='email' placeholder='correo electronico' required></input>");
            out.println("<br/>");
            out.println("<input type='submit' value='Envía parámetros'/>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
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
    protected void doPost(HttpServletRequest peticionHttp, HttpServletResponse respuestaHttp)
            throws ServletException, IOException {

        respuestaHttp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = respuestaHttp.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ParamServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ParamServlet at " + peticionHttp.getContextPath() + "</h1>");
            out.println("<h2>Formulario de registro</h2>");
            // Campos a recibir: nombre e email, obligatorios y con su validación HTML5
            String valorNombre = peticionHttp.getParameter("nombre_campo");
            String valorEmail = peticionHttp.getParameter("email_campo");
            if (valorNombre == null || "".equals(valorNombre) || valorEmail == null || "".equals(valorEmail)) {
                out.println("<p style='color: red;'>Los parámetros no son correctos</p>");
            } else {
                out.println("<p style='color: green;'>Nombre: " + valorNombre.toUpperCase() + "</p>");
                out.println("<p style='color: green;'>Email: " + valorEmail.toLowerCase() + "</p>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
