package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.acao.EmpresaAcao;
import br.com.alura.gerenciador.acao.IEmpresaAcao;

/**
 * Servlet implementation class ApiServlet
 */
@WebServlet("/api")
public class ApiServletV2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApiServletV2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String acao = request.getParameter("acao");	
		
		HttpSession httpSession = request.getSession();
		
		boolean usuarioNaoLogado = httpSession.getAttribute("usuarioLogado") == null;
		boolean acaoProtegida = !(acao.equals("Login") || acao.equals("LoginForm")); 
		
		if (usuarioNaoLogado && acaoProtegida) {
			response.sendRedirect("api?acao=LoginForm");
			return; 
		}
		
		String nomeClasse = "br.com.alura.gerenciador.acao."+acao;
		
		System.out.println("Chegou "+acao);
		
		String url = null;
		
		try {
			Class classe = Class.forName(nomeClasse);
			Object obj = classe.newInstance();
			url = ((IEmpresaAcao) obj).executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}
		
		String[] tipoUrl = url.split(":");
		
		if (tipoUrl[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view"+tipoUrl[1]);
			rd.forward(request, response);
		}
		else {
			response.sendRedirect(tipoUrl[1]);
		}
	}

}
