package ejemplo.demoweb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ejemplo.demoweb.modelo.Usuario;
import ejemplo.demoweb.repository.IUsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService {

	@Autowired
	private IUsuarioRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {		
		Usuario user = repo.findByNombre(username);
		
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		roles.add(new SimpleGrantedAuthority("ADMIN"));
		
		UserDetails userDetails = new User(user.getNombre(), user.getPass(), roles);
		
		return userDetails;
	}
	
	

}
