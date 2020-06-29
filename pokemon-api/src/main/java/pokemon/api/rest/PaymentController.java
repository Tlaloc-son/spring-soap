package pokemon.api.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pokemon.api.tool.Saver;

@RestController
@RequestMapping("/payment")
public class PaymentController {	
	
	@PutMapping(value = "/")
	@ResponseStatus(HttpStatus.CREATED)
	public String save(@RequestBody String body) {
		Saver.notifications.add(body);
		return "ok";
	}
}
