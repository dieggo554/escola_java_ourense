package com.vn.appusuarios.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Descriptores de servlets
@WebServlet({ "/saludo", "/otraurl" })
public class SaludosServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doGet(req, resp);
		String nombre = req.getParameter("nombre");
		resp.getWriter().println("<html><body>");
		
		resp.getWriter().println(nombre);
		Cookie[] todasCookies = req.getCookies();
		
		Cookie nombreCookie;
		if (todasCookies.length > 2) {
			nombreCookie = new Cookie("nombre_cookie", "Valor de la cookie: " + nombre);
			nombreCookie.setMaxAge(3600);
		} else {
			nombreCookie = todasCookies[0];
		}
		if (todasCookies.length > 0) {
			System.out.println("Cookie desde navegador: " + todasCookies[1].getValue());
		}
		
		resp.addCookie(nombreCookie);
		resp.getWriter().println("<div id='divC'></div>");
		resp.getWriter().println("<script>");
		resp.getWriter().println("document.getElementById('divC').innerHTML = document.cookie;");
		resp.getWriter().println("document.cookie='nombre_cookie=\"modificada en JS: \"';");
		
		resp.getWriter().println("</script>");
		
		resp.getWriter().println("</body></html>");
	}

}
