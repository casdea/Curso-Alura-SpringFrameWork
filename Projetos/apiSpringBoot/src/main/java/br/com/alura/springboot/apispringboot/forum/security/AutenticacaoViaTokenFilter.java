package br.com.alura.springboot.apispringboot.forum.security;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.alura.springboot.apispringboot.forum.modelo.Usuario;
import br.com.alura.springboot.apispringboot.forum.repository.UsuarioRepository;

public class AutenticacaoViaTokenFilter extends OncePerRequestFilter {

	private UsuarioRepository usuarioRepository;
	private TokenService tokenService;

	public AutenticacaoViaTokenFilter(TokenService tokenService, UsuarioRepository usuarioRepository) {
		super();
		this.tokenService = tokenService;
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String token = recuperarToken(request);

		boolean valido = tokenService.isTokenValido(token);

		if (valido) {
			autenticarCliente(token);
		}

		filterChain.doFilter(request, response);

	}

	private void autenticarCliente(String token) {
		Long idUsuario = tokenService.getIdUsuario(token);

		Optional<Usuario> optional = usuarioRepository.findById(idUsuario);

		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(optional.get(),
				null, optional.get().getAuthorities());

		SecurityContextHolder.getContext().setAuthentication(authentication);

	}

	private String recuperarToken(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String token = request.getHeader("Authorization");

		if (token == null || token.isEmpty() || token.startsWith("Bearer") == false) {
			return null;
		}

		return token.substring(7, token.length());
	}

}
