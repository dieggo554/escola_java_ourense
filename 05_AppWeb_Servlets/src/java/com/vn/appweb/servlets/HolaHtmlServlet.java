package com.vn.appweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet que genera una respuesta en formato HTML
 *
 * @author pc
 */
public class HolaHtmlServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest peticionHTTP,
            HttpServletResponse respuestaHTTP) throws IOException {

        // Definimos el tipo de contenido según los tipos MIME
        // MIME: Formatos conocidos de ficheros para emails
        respuestaHTTP.setContentType("text/html;charset=UTF-8");
        try (PrintWriter salida = respuestaHTTP.getWriter()) {
            salida.print("<html>");
            salida.print("<head>");
            salida.print("<title>Web HTML desde Servlet</title>");
            salida.print("<link rel='stylesheet' href='./css'/>");
            salida.print("</head>");
            salida.print("<body>");
            
            salida.print("<h1>Web HTML desde Servlet</h1>"
                    + "<h2 class='color-rojo'>Hola que pasa</h2>"
                    + "<ul>");
            for (int i = 0; i < 10; i++) {
                salida.print("<li id='li" + i + "'> Iteración: " + i + "</li>");
            }
            salida.print("</ul>");
            
            salida.print("<br/>Ruta: " + peticionHTTP.getContextPath());
            salida.print("<br/>Método: " + peticionHTTP.getMethod());
            
            salida.print("</body>");
            salida.print("</html>");
            // YA no hace falta, TRY se encarga de CERRAR
//            salida.close();
        }
    }
}
