package pokemon.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class MoveDetail {

	@JsonProperty("level_learned_at")
	private int levelLearnedAt;
	
	@JsonProperty("move_learn_method")
	private Value moveLearnMethod;
	
	@JsonProperty("version_group")
	private Value versionGroup;
}
