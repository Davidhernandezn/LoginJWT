package davidhernandezn.login.mx.Jwt;

import java.io.IOException;
import java.net.http.HttpHeaders;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import ch.qos.logback.core.joran.conditional.IfAction;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAutenticationFilter extends OncePerRequestFilter {
	// OncePerRequestFilter
	/* CREA FILTROS PERZONAIZADOS, EJECUTAR FILTRO UNA VEZ POR CADA PETICION */

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// Realiza filtros relacionados al token
		// FilterChain = cadena de filtros

		// OBTENER TOKEN
		final String token = getTokenFromRequest(request);

		if (token == null) {
			filterChain.doFilter(request, response);
			return;
		}
		
		filterChain.doFilter(request, response);//Para que siga su curso

	}

	//DEVUELVE TOKEN (STRING)
	private String getTokenFromRequest(HttpServletRequest request) {
		// PASAMOS COMO PARAM EL request porque ahi se cuentra el header
		final String authHeader = request.getHeader(org.springframework.http.HttpHeaders.AUTHORIZATION); //obtener header del encabezado de auth
		
		/*EL STRING INICIA CON Bearer LA CUAL NO DEBEMOS INCORPORAR
		 * hasText = exite el texto
		 * evaluar que comienze con Bearer*/
		if (StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer"))  {
			//SI SE CUMPLE QUIERE DECIR QUE VIENE EL TOKEN, apartir de la posicion 7
			return authHeader.substring(7);
		}
		//SI NO CUMPLE
		return null;
		
	}
	
}
