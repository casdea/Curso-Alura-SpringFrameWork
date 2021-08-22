package br.com.alura.gerenciador.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

public class EmpresaController {
	
	public void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Banco banco = new Banco();
		List<Empresa> empresas = banco.getEmpresas();

		request.setAttribute("empresas", empresas);
		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresasJSTL.jsp");
		rd.forward(request, response);
	}
	
	public void mostra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Banco banco = new Banco();
		Empresa empresa = banco.findEmpresaById(id);

		request.setAttribute("empresa", empresa);
		RequestDispatcher rd = request.getRequestDispatcher("/formAlteraEmpresa.jsp");
		rd.forward(request, response);
	}

	public void altera(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	
	public void cria(HttpServletRequest request, HttpServletResponse response)
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

		response.sendRedirect("listaEmpresas");

	}

	public void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
		Banco banco = new Banco();
		banco.removeEmpresa(id);		
		response.sendRedirect("listaEmpresas");
				
	}

	

}
