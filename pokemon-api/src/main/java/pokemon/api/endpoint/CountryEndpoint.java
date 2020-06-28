package pokemon.api.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import pokemon.api.jaxb.AbilitiesRequest;
import pokemon.api.jaxb.AbilitiesResponse;
import pokemon.api.jaxb.GetCountryRequest;
import pokemon.api.jaxb.GetCountryResponse;
import pokemon.api.jaxb.IdRequest;
import pokemon.api.jaxb.IdResponse;
import pokemon.api.jaxb.NameRequest;
import pokemon.api.jaxb.NameResponse;
import pokemon.api.model.Pokemon;
import pokemon.api.repository.CountryRepository;
import pokemon.api.repository.PokemonRepository;
import pokemon.api.tool.Converter;
import pokemon.api.tool.StringResources;

@Endpoint
public class CountryEndpoint {	

	private CountryRepository countryRepository;
	private PokemonRepository pokemonRepository;
	private Converter converter;
	
	@Autowired
	public CountryEndpoint(CountryRepository countryRepository, PokemonRepository pokemonRepository, Converter converter) {
		this.countryRepository = countryRepository;
		this.pokemonRepository = pokemonRepository;
		this.converter = converter;
	}

	@PayloadRoot(namespace = StringResources.NAMESPACE_URI, localPart = "getCountryRequest")
	@ResponsePayload
	public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {		 
		
		
		try {
			
			RestTemplate restTemplate = new RestTemplate();
			String uri = String.format("https://pokeapi.co/api/v2/pokemon/%s", request.getName());
			
			HttpHeaders headers = new HttpHeaders();			
			headers.add("User-Agent", "Client Rest");
			HttpEntity<String> httpRequestEntity = new HttpEntity<>(headers);
			
			long petitionTime = System.currentTimeMillis();
			ResponseEntity<String> exchange = restTemplate.exchange(uri, HttpMethod.GET, httpRequestEntity, String.class);			
			String jsonResponse = exchange.getBody();
	        long took = System.currentTimeMillis() - petitionTime;
	        System.out.println(String.format("Tiempo [%d] ms", took));
	        System.out.println(String.format("Peticion %s", jsonResponse));
		}catch(Exception e) {
			System.out.println(String.format("%s", e.getMessage()));
		}
		
        
        //log.info(String.format("Peticion %d/%d  - idDireccion [%d] - tiempo [%d] ms", new Integer(contador) + 1, totales, direccion.getIdDireccion(), took));        
		

        GetCountryResponse countryResponse = new GetCountryResponse();
        countryResponse.setCountry(countryRepository.findCountry("Spain"));
		return countryResponse;
	}
	
	@PayloadRoot(namespace = StringResources.NAMESPACE_URI, localPart = "idRequest")
	@ResponsePayload
	public IdResponse getId(@RequestPayload IdRequest request) {	
		IdResponse response = new IdResponse();
		Pokemon pokemon = pokemonRepository.getPokemon(request.getPokemon());        
		response.setId(pokemon.getId());
		return response;
	}
	
	@PayloadRoot(namespace = StringResources.NAMESPACE_URI, localPart = "nameRequest")
	@ResponsePayload
	public NameResponse getId(@RequestPayload NameRequest request) {	
		NameResponse response = new NameResponse();
		Pokemon pokemon = pokemonRepository.getPokemon(request.getPokemon());        
		response.setName(pokemon.getId());
		return response;
	}
	
	@PayloadRoot(namespace = StringResources.NAMESPACE_URI, localPart = "abilitiesRequest")
	@ResponsePayload
	public AbilitiesResponse getId(@RequestPayload AbilitiesRequest request) {	
		AbilitiesResponse response = new AbilitiesResponse();
		Pokemon pokemon = pokemonRepository.getPokemon(request.getPokemon());        
		response.getAbilities().addAll(converter.convertAbilityList(pokemon.getAbilities()));
		return response;
	}
}
