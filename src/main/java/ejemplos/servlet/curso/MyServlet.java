package ejemplos.servlet.curso;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/myServlet")
public class MyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// send HTML page to client
		out.println("<html>");
		out.println("<head><title>Formulario HTML</title></head>");
		out.println("<body>");
		out.println("<h1>Actividad 1 Servlets</h1>");
		out.println("<form action='myServlet' method='POST'>");
		out.println("<label for=\"fname\">Nombre:</label>");
		out.println("<input type=\"text\" id=\"fname\" name=\"fname\" value=\"\">");
		out.println("<input type=\"submit\" value=\"Submit\">");
		out.println("</form>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recibe el valor del formulario
		//String inputText = request.getParameter("fname");

		// Añade el dato como atributo para el siguiente servlet
		//request.setAttribute("fname", inputText);

		// Redirige al segundo servlet, pasando el parámetro en la URL
		//response.sendRedirect("myServlet2?fname=" + inputText);

		// Recibe el valor del formulario
		String inputText = request.getParameter("fname");

		// Añade el dato como atributo para el siguiente servlet
		request.setAttribute("fname", inputText);

		// Redirige (forward) la petición al segundo servlet
		RequestDispatcher dispatcher = request.getRequestDispatcher("myServlet2");
		dispatcher.forward(request, response);
	}

}