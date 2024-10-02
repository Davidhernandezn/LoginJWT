package davidhernandezn.login.mx.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
//RESPUESTA DEL REGISTRO O LOGIN DEVUELVE TOKEN
	String token;
}
