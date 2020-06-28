package pokemon.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Stat {

	@JsonProperty("base_stat")
	private int baseStat;
	private String effort;
	private Value stat;
}
