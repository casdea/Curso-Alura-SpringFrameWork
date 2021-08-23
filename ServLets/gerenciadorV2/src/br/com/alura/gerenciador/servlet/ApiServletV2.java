package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.controller.EmpresaController;
import br.com.alura.gerenciador.controller.IEmpresaAcao;

/**
 * Servlet implementation class ApiServlet
 */
@WebServlet("/api")
public class ApiServletV2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Object LISTA_EMPRESAS = "ListaEmpresas";
	private static final Object CRIA_EMPRESA = "NovaEmpresa";
	private static final Object ALTERA_EMPRESAS = "AlteraEmpresa";
	private static final Object REMOVE_EMPRESAS = "RemoveEmpresa";
	private static final Object MOSTRA_EMPRESAS = "MostraEmpresa";
	private static final Object INSERIR_EMPRESA = "InsereEmpresa";
	
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
		
		String nomeClasse = "br.com.alura.gerenciador.controller."+acao;
		
		
		
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
