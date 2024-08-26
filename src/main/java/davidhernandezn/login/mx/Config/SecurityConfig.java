package davidhernandezn.login.mx.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

import lombok.RequiredArgsConstructor;

@Configuration // INDICAMOS QUE SERÁ DE CONFIGURACION
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	
	/* CADENA DE FILTROS */
	@Bean
	public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
		// TODOS LOS ENDPOINTS QUE PASEN AUTH PERMITE ACCESO PERO A OTROS REQUEST
		// SOLICITAMOS AUTENTICACIÓN

		// CSRF: PROTECCION A LAS SOLICITUDES A LAS ENDPOINTS (agrega autenticación)
		return http
				.csrf(csrf->csrf.disable())
				.authorizeHttpRequests(
						authRequest -> authRequest.requestMatchers("/auth/**")
						.permitAll().anyRequest()
						.authenticated())
				.formLogin(withDefaults())
				.build();
	}

}
