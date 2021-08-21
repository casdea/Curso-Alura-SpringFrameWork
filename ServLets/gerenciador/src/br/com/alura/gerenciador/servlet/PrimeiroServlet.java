package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/ola")
public class PrimeiroServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6614938405063156327L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException 
	{
		// TODO Auto-generated method stub
		//super.service(req, resp);
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("O Primeiro ServLet Respndendo....");
		out.println("</body>");
		out.println("</html>");
	}

}
