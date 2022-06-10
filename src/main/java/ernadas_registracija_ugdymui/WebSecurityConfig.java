package ernadas_registracija_ugdymui;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private VartotojaiRepository vartotojai_repository;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers( "/", "/home", "/registracija" ).permitAll()
				.antMatchers( HttpMethod.POST, "/registruoti" ).permitAll()
				.antMatchers( "/admin-ugdymo-istaigos" ).access( "hasRole('user')" )
				.antMatchers( HttpMethod.POST, "/admin-ugdymo-istaigos-tvarkyti" ).access( "hasRole('user')" )	
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
			.logout()
				.permitAll();
	}

	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		/*
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("user")
				.password("password")
				.roles("USER")
				.build();
		*/
		Iterable<Vartotojai>  vartotojai = vartotojai_repository.findAll();
		
		ArrayList<UserDetails> vartotojai_visi = new ArrayList<UserDetails>();
		
		for ( Vartotojai vartotojas : vartotojai ) {
			
			UserDetails vartotojas1 = User.withDefaultPasswordEncoder()
					.username( vartotojas.getVardas() )
					.password( vartotojas.getSlaptazodis() )
					.roles ( vartotojas.getTipas() )
					.build();
				vartotojai_visi.add(vartotojas1);
		}

		return new InMemoryUserDetailsManager(vartotojai_visi);
	}
}