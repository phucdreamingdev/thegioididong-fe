package vn.com.groupfive.tgdd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.client.RestTemplate;
import ch.itds.taglib.phonenumber.PhoneNumberDialect;

@SpringBootApplication
public class GroupfiveTgddFeApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroupfiveTgddFeApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public PhoneNumberDialect phoneNumberDialect() {
		return new PhoneNumberDialect();
	}

	@Bean
	public static PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService() throws Exception {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

		manager.createUser(User.withUsername("admin").password(encoder().encode("admin")).roles("ADMIN").build());

		return manager;
	}
}
