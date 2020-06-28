package pokemon.api.repository;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import pokemon.api.model.Pokemon;
import pokemon.api.tool.JacksonSerializer;

@Component
public class PokemonRepository {

	public Pokemon getPokemon(String name) {
		long petitionTime = System.currentTimeMillis();
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
			System.out.println(String.format("%s", e.getMessage()));
		}
		long took = System.currentTimeMillis() - petitionTime;
        System.out.println(String.format("Tiempo [%d] ms", took));
        
		return pokemon;
	}
}
