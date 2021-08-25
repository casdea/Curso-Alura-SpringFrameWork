package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

public class NovaEmpresa implements IEmpresaAcao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

}
