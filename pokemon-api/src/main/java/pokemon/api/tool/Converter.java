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
}
