package cm.allpha.Echo_Sos.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import cm.allpha.Echo_Sos.service.EchoSosAccountService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private AuthenticationManager authenticationManager;
	@Autowired
	private EchoSosAccountService userService;
	private AccessDeniedHandler accessDeniedHandler;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.parentAuthenticationManager(authenticationManager).userDetailsService(userService)
				.passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// http.formLogin();
		// http.authorizeRequests().antMatchers("/addArticle",
		// "/planning.html").hasRole("ORPHANAGE");
		// http.authorizeRequests().antMatchers("/selfpage").hasRole("SPONSORING");
		// http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic().and()
		// .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.csrf().disable().authorizeRequests().antMatchers("/css/font-awesome.min.css", "/**", "/css/main.css")
				.permitAll().anyRequest().authenticated().and().formLogin().loginPage("/authentification")
				.defaultSuccessUrl("/home", true).and().logout().permitAll().and().exceptionHandling()
				.accessDeniedHandler(accessDeniedHandler);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}