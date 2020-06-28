package pokemon.api.tool;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Converter {

	public List<pokemon.api.jaxb.Ability> convertAbilityList(List<pokemon.api.model.Ability> abilitiesModel){
		List<pokemon.api.jaxb.Ability> abilitiesJaxb = new LinkedList<pokemon.api.jaxb.Ability>();
		for(pokemon.api.model.Ability model : abilitiesModel) {
			abilitiesJaxb.add(convertAbility(model));
		}
		return abilitiesJaxb;
	}
	
	public pokemon.api.jaxb.Ability convertAbility(pokemon.api.model.Ability model){
		pokemon.api.jaxb.Ability jaxb = new pokemon.api.jaxb.Ability();
		jaxb.setHidden(model.isHidden());
		jaxb.setSlot(model.getSlot());
		jaxb.setAbility(convertValue(model.getAbility()));
		return jaxb;
	}

	private pokemon.api.jaxb.Value convertValue(pokemon.api.model.Value model) {
		pokemon.api.jaxb.Value jaxb = new pokemon.api.jaxb.Value();
		jaxb.setName(model.getName());
		jaxb.setUrl(model.getUrl());
		return jaxb;
	}
	
	public List<pokemon.api.jaxb.Held> convertHeldItems(List<pokemon.api.model.Held> heldItems) {
		List<pokemon.api.jaxb.Held> jaxb = new LinkedList<pokemon.api.jaxb.Held>();
		for(pokemon.api.model.Held held : heldItems) {
			jaxb.add(convertHeld(held));
		}
		return jaxb;
	}

	private pokemon.api.jaxb.Held convertHeld(pokemon.api.model.Held model) {
		pokemon.api.jaxb.Held jaxb = new pokemon.api.jaxb.Held();
		jaxb.setItem(convertValue(model.getItem()));
		jaxb.getVersionDetails().addAll(convertVersionDetails(model.getVersionDetails()));
		return jaxb;
	}
	
	private List<pokemon.api.jaxb.VersionDetail> convertVersionDetails(List<pokemon.api.model.VersionDetail> versionDetails) {
		List<pokemon.api.jaxb.VersionDetail> details = new LinkedList<pokemon.api.jaxb.VersionDetail>();
		for(pokemon.api.model.VersionDetail detail : versionDetails) {
			details.add(convertDetail(detail));
		}
		return details;
	}

	private pokemon.api.jaxb.VersionDetail convertDetail(pokemon.api.model.VersionDetail model) {
		pokemon.api.jaxb.VersionDetail jaxb = new pokemon.api.jaxb.VersionDetail();
		jaxb.setRarity(model.getRarity());
		jaxb.setVersion(convertValue(model.getVersion()));
		return jaxb;
	}	
	
}
