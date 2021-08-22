package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

/**
 * Servlet implementation class AlteraEmpresaServlet
 */
@WebServlet("/alteraEmpresa")
public class AlteraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlteraEmpresaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String dataFundacaoTxt = request.getParameter("dataFundacao");

		Date dataFundacao = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			dataFundacao = sdf.parse(dataFundacaoTxt);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new ServletException("Data de Fundacao invalida");
		}

		Banco banco = new Banco();
		Empresa empresa = banco.findEmpresaById(Integer.parseInt(id));
		
		if (empresa != null) {
			empresa.setNome(nome);
			empresa.setDataFundacao(dataFundacao);
		}

		request.setAttribute("empresa", empresa.getNome());

		response.sendRedirect("listaEmpresas");
	}

}
