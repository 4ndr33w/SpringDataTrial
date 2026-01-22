package trials.itk.spring_data.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import trials.itk.spring_data.security.handler.SecurityExceptionHandler;

/**
 * @author 4ndr33w
 * @version 1.0
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(
					HttpSecurity http,
					SecurityExceptionHandler exceptionHandler) throws Exception {
		
		return http
				.cors(AbstractHttpConfigurer::disable)
				.httpBasic(AbstractHttpConfigurer::disable)
				.formLogin(AbstractHttpConfigurer::disable)
				.csrf(AbstractHttpConfigurer::disable)
				.sessionManagement(sessionManagement ->
						sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(authz -> authz
						.requestMatchers(HttpMethod.GET, "/api/v1/employees/home").permitAll()
						.requestMatchers(HttpMethod.GET, "/v3/api-docs/**").permitAll()
						.requestMatchers(HttpMethod.GET, "/actuator/**").permitAll()
						.requestMatchers(HttpMethod.POST, "/api/v1/employees").permitAll() // оставим возможность создавать пользователей
						.requestMatchers(HttpMethod.POST, "/api/v1/departments").permitAll() // и подразделения
						.requestMatchers("/swagger-ui/**").permitAll()
						.anyRequest().authenticated())
				.exceptionHandling(e -> e
						.authenticationEntryPoint(exceptionHandler::unauthorizedHandler)
						.accessDeniedHandler(exceptionHandler::accessDeniedHandler))
				.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}