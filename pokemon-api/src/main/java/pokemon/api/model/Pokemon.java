package pokemon.api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {

	private int id;
	
	private String name;
	
	private int order;
	
	private int weight;
	
	private Value species;
	
	@JsonProperty("is_default")
	private boolean isDefault;
	
	private List<Ability> abilities;
	
	@JsonProperty("base_experience")
	private int baseExperience;
	
	private List<Value> forms;
	
	@JsonProperty("game_indices")
	private List<GameIndex> gameIndices;
	
	private int height;
	
	@JsonProperty("held_items")
	private List<Held> heldItems;
	
	@JsonProperty("location_area_encounters")
	private String locationAreaEncounters;
	
	private Sprite sprites;
	
	private List<Stat> stats;
	
	private List<Type> types;
}
