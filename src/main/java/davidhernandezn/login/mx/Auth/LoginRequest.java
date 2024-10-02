package davidhernandezn.login.mx.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //CREA GETTER AND SETTER
@Builder//CONSTRULLE OBJETOS
@AllArgsConstructor//CONSTRUCTORES
@NoArgsConstructor
public class LoginRequest {
	//PIDE CREDENCIALES
	String userName;
	String password;

}
