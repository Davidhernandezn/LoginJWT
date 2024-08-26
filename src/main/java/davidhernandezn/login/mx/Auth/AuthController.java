package davidhernandezn.login.mx.Auth;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

/*
 * PERMITE EXPONER LOS ENDPOINT*/

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor // AGREGA CONSTRUCTOR CON TODOS LOS ELMENTOS
public class AuthController {

	@PostMapping(value = "login")
	public String Login() {
		return "Login public";
	}

	@PostMapping(value = "register")
	public String register() {
		return "Register public";
	}
}
