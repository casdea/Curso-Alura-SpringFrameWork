package br.com.alura.gerenciador.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

public class MostraEmpresa implements IEmpresaAcao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Banco banco = new Banco();
		Empresa empresa = banco.findEmpresaById(id);

		request.setAttribute("empresa", empresa);

		return "forward:/formAlteraEmpresa.jsp";
	}

}
