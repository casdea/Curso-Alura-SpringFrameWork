package br.com.alura.springboot.apispringboot.forum.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.alura.springboot.apispringboot.forum.modelo.Usuario;
import br.com.alura.springboot.apispringboot.forum.repository.UsuarioRepository;

@Service
public class AutenticacaoService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<Usuario> usuario = usuarioRepository.findByEmail(arg0);
		
		if (usuario.isPresent()==false) {
			throw new UsernameNotFoundException("Dados invalidos informados");
		}
		
		return usuario.get();
	}

}
