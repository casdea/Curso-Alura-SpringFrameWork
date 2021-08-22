package br.com.alura.gerenciador.servlet;

import java.io.IOException;
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
	private static final Object CRIA_EMPRESA = "criaEmpresa";
	private static final Object ALTERA_EMPRESAS = "alteraEmpresa";
	private static final Object REMOVE_EMPRESAS = "removeEmpresa";
       
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
		
		if (acao.equals(LISTA_EMPRESAS)) empresaController.lista(request, response);
		if (acao.equals(CRIA_EMPRESA)) empresaController.cria(request, response);
		if (acao.equals(ALTERA_EMPRESAS)) empresaController.altera(request, response);
		if (acao.equals(REMOVE_EMPRESAS)) empresaController.remove(request, response);
	}

}
