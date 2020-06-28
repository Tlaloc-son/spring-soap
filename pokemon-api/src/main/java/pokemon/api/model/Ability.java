package pokemon.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Ability {
	
	@JsonProperty("is_hidden")
	private boolean hidden;
	
	private int slot;
	
	private Value ability;
}
