package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nome = request.getParameter("nome");
		String dataFundacaoTxt = request.getParameter("dataFundacao");
		System.out.println(dataFundacaoTxt);
		Date dataFundacao = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			dataFundacao = sdf.parse(dataFundacaoTxt);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new ServletException("Data de Fundacao invalida");
		}

		Empresa empresa = new Empresa(nome, dataFundacao);

		Banco banco = new Banco();
		banco.adiciona(empresa);

		request.setAttribute("empresa", empresa.getNome());

		// FASE 1		
		// RequestDispatcher rd  request.getRequestDispatcher("/novaEmpresaCriada.jsp");
		// FASE 2
		//RequestDispatcher rd = request.getRequestDispatcher("/novaEmpresaCriadaExpressao.jsp");
		// FASE 3
		//RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
		//rd.forward(request, response);
		response.sendRedirect("listaEmpresas");

	}

}
