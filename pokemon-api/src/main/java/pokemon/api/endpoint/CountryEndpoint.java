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

import pokemon.api.jaxb.GetCountryRequest;
import pokemon.api.jaxb.GetCountryResponse;
import pokemon.api.repository.CountryRepository;

@Endpoint
public class CountryEndpoint {

	private static final String NAMESPACE_URI = "http://www.api.pokemon/jaxb/";

	private CountryRepository countryRepository;

	@Autowired
	public CountryEndpoint(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
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
}
