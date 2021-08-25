package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.IEmpresaAcao;

//@WebFilter("/api")
public class ControladorFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servLetresponse, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("Controlador Filter");

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servLetresponse;
				
		String acao = request.getParameter("acao");	
		
		String nomeClasse = "br.com.alura.gerenciador.acao."+acao;
		
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
