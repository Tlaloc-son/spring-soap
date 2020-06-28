package pokemon.api.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import pokemon.api.jaxb.AbilitiesRequest;
import pokemon.api.jaxb.AbilitiesResponse;
import pokemon.api.jaxb.BaseExperienceRequest;
import pokemon.api.jaxb.BaseExperienceResponse;
import pokemon.api.jaxb.HeldItemsRequest;
import pokemon.api.jaxb.HeldItemsResponse;
import pokemon.api.jaxb.IdRequest;
import pokemon.api.jaxb.IdResponse;
import pokemon.api.jaxb.LocationAreaEncountersRequest;
import pokemon.api.jaxb.LocationAreaEncountersResponse;
import pokemon.api.jaxb.NameRequest;
import pokemon.api.jaxb.NameResponse;
import pokemon.api.model.Pokemon;
import pokemon.api.repository.PokemonRepository;
import pokemon.api.tool.Converter;
import pokemon.api.tool.StringResources;

@Endpoint
public class PokemonEndpoint {
	
	private PokemonRepository pokemonRepository;
	private Converter converter;
	
	@Autowired
	public PokemonEndpoint(PokemonRepository pokemonRepository, Converter converter) {
		this.pokemonRepository = pokemonRepository;
		this.converter = converter;
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
		response.setName(pokemon.getName());
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
	
	@PayloadRoot(namespace = StringResources.NAMESPACE_URI, localPart = "baseExperienceRequest")
	@ResponsePayload
	public BaseExperienceResponse getId(@RequestPayload BaseExperienceRequest request) {	
		BaseExperienceResponse response = new BaseExperienceResponse();
		Pokemon pokemon = pokemonRepository.getPokemon(request.getPokemon());        
		response.setBaseExperience(pokemon.getBaseExperience());
		return response;
	}
	
	@PayloadRoot(namespace = StringResources.NAMESPACE_URI, localPart = "heldItemsRequest")
	@ResponsePayload
	public HeldItemsResponse getId(@RequestPayload HeldItemsRequest request) {	
		HeldItemsResponse response = new HeldItemsResponse();
		Pokemon pokemon = pokemonRepository.getPokemon(request.getPokemon());        
		response.getHeldItems().addAll(converter.convertHeldItems(pokemon.getHeldItems()));
		return response;
	}
	
	@PayloadRoot(namespace = StringResources.NAMESPACE_URI, localPart = "locationAreaEncountersRequest")
	@ResponsePayload
	public LocationAreaEncountersResponse getId(@RequestPayload LocationAreaEncountersRequest request) {	
		LocationAreaEncountersResponse response = new LocationAreaEncountersResponse();
		Pokemon pokemon = pokemonRepository.getPokemon(request.getPokemon());        
		response.setLocationAreaEncounters(pokemon.getLocationAreaEncounters());
		return response;
	}
	
}
