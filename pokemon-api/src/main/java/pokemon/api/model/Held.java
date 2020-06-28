package pokemon.api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Held {

	private Value item;
	@JsonProperty("version_details")
	private List<VersionDetail> versionDetails;
}
