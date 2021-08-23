package br.com.alura.gerenciador.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

public class AlteraEmpresa implements IEmpresaAcao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
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

}
