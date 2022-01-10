package ejemplo.demoweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ejemplo.demoweb.service.UsuarioService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UsuarioService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Bean
	public BCryptPasswordEncoder passEncoder() {
		BCryptPasswordEncoder bCryptPass = new BCryptPasswordEncoder();
		return bCryptPass;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*auth
		.inMemoryAuthentication()
		.withUser("admin")
		.password("1234")
		.roles("USER");
		*/
		auth.userDetailsService(userDetailsService).passwordEncoder(bcrypt);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
	}
	
	
	
}
