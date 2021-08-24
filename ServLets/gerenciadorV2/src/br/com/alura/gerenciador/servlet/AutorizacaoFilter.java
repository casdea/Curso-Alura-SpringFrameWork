package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AutorizacaoFilter
 */
//@WebFilter("/api")
public class AutorizacaoFilter implements Filter {

	public void doFilter(ServletRequest servletRequest, ServletResponse servLetresponse, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("Autorizacao Filter");
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servLetresponse;
		
		HttpSession httpSession = request.getSession();
		
		String acao = request.getParameter("acao");
		
		boolean usuarioNaoLogado = httpSession.getAttribute("usuarioLogado") == null;
		boolean acaoProtegida = !(acao.equals("Login") || acao.equals("LoginForm")); 
		
		if (usuarioNaoLogado && acaoProtegida) {
			response.sendRedirect("api?acao=LoginForm");
			return; 
		}
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}


}
