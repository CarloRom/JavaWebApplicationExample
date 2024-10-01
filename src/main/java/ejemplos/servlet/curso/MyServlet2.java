package ejemplos.servlet.curso;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/myServlet2")
public class MyServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Recoge el parámetro desde la URL
		//String inputText = request.getParameter("fname");



		// Recibe el dato enviado por el primer servlet
		String inputText = (String) request.getAttribute("fname");



		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// send HTML page to client
		out.println("<html>");
		out.println("<head><title>Recogida de parámetro de Servlet 1</title></head>");
		out.println("<body>");
		out.println("<h1>Bienvenid@ " + inputText +"!</h1>");
	}

	protected void doPost(HttpServletRequest request,
						 HttpServletResponse response) throws ServletException, IOException {


		// Recibe el dato enviado por el primer servlet
		String inputText = (String) request.getAttribute("fname");



		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// send HTML page to client
		out.println("<html>");
		out.println("<head><title>Recogida de parámetro de Servlet 1</title></head>");
		out.println("<body>");
		out.println("<h1>Bienvenid@ " + inputText +"!</h1>");
	}

}