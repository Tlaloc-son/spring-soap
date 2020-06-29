package pokemon.api.repository;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import pokemon.api.endpoint.PokemonEndpoint;
import pokemon.api.model.Pokemon;
import pokemon.api.tool.JacksonSerializer;

@Component
public class PokemonRepository {

	public static final Log LOGGER = LogFactory.getLog(PokemonEndpoint.class);
	
	public Pokemon getPokemon(String name) {		
		Pokemon pokemon = new Pokemon();
		try {
			RestTemplate restTemplate = new RestTemplate();
			String uri = String.format("https://pokeapi.co/api/v2/pokemon/%s", name);

			HttpHeaders headers = new HttpHeaders();			
			headers.add("User-Agent", "Client Rest");
			HttpEntity<String> httpRequestEntity = new HttpEntity<>(headers);
			
			ResponseEntity<String> exchange = restTemplate.exchange(uri, HttpMethod.GET, httpRequestEntity, String.class);			
			String jsonResponse = exchange.getBody();
			
			pokemon = JacksonSerializer.objectify(jsonResponse, Pokemon.class);	        
		}catch(Exception e) {
			LOGGER.error(String.format("%s", e.getMessage()));
		}
		return pokemon;
	}
}
