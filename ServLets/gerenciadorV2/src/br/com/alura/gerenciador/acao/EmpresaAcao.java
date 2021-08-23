package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

public class EmpresaAcao {

	public String lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Banco banco = new Banco();
		List<Empresa> empresas = banco.getEmpresas();

		request.setAttribute("empresas", empresas);

		return "forward:/listaEmpresas.jsp";
	}

	public String nova(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		return "forward:/formNovaEmpresa.jsp";
	}

	public String mostra(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Banco banco = new Banco();
		Empresa empresa = banco.findEmpresaById(id);

		request.setAttribute("empresa", empresa);

		return "forward:/formAlteraEmpresa.jsp";
	}

	public String altera(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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

		return "redirect:api?acao=ListaEmpresas";
	}

	public String cria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

		return "redirect:api?acao=ListaEmpresas";

	}

	public String remove(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
		Banco banco = new Banco();
		banco.removeEmpresa(id);

		return "redirect:api?acao=ListaEmpresas";

	}

}
