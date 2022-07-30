package vn.com.groupfive.tgdd.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/", "/cart").permitAll()
					.antMatchers("/admin/**").hasRole("ADMIN")
						.anyRequest()
							.authenticated()
			.and()
				.formLogin()
					.loginPage("/login")
						.permitAll()
							.failureUrl("/login?error=true")
							.defaultSuccessUrl("/admin/dashboard")
			.and()
				.logout()
					.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
						.logoutSuccessUrl("/login")
							.invalidateHttpSession(true)
								.deleteCookies("JSESSIONID")
			.and()
				.exceptionHandling()				
			. and()
				.csrf()
				.disable();
			
		http.headers().frameOptions().disable();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**","/images/**", "/fonts/**", "/css/**", "/js/**", "/error", "/vendors/**");
	}
}	
