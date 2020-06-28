package pokemon.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class GameIndex {

	@JsonProperty("game_index")
	private int gameIndex;
	
	private Value version;
}
