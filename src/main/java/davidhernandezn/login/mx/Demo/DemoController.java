package davidhernandezn.login.mx.Demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class DemoController {
	
	/*AL TENER SPRING SECURITY, AGREGA LA SEGURIDAD POR DEFECTO*/
	
	@PostMapping(value="demo")
	public String welcome() {
		return "Bienvenido!";
	}
}
