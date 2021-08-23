package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.controller.EmpresaController;

/**
 * Servlet implementation class ApiServlet
 */
@WebServlet("/api")
public class ApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Object LISTA_EMPRESAS = "listaEmpresas";
	private static final Object CRIA_EMPRESA = "novaEmpresa";
	private static final Object ALTERA_EMPRESAS = "alteraEmpresa";
	private static final Object REMOVE_EMPRESAS = "removeEmpresa";
	private static final Object MOSTRA_EMPRESAS = "mostraEmpresa";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String acao = request.getParameter("acao");	
		
		EmpresaController empresaController = new EmpresaController();
	
		String url = null;
		
		if (acao.equals(LISTA_EMPRESAS)) url = empresaController.lista(request, response);
		if (acao.equals(CRIA_EMPRESA)) url = empresaController.cria(request, response);
		if (acao.equals(ALTERA_EMPRESAS)) url = empresaController.altera(request, response);
		if (acao.equals(REMOVE_EMPRESAS)) url = empresaController.remove(request, response);
		if (acao.equals(MOSTRA_EMPRESAS)) url = empresaController.mostra(request, response);
		
		String[] tipoUrl = url.split(":");
		
		if (tipoUrl[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher(tipoUrl[1]);
			rd.forward(request, response);
		}
		else {
			response.sendRedirect(tipoUrl[1]);
		}
	}

}
