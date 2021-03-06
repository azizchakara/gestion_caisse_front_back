package app.neotech.gestion.de.caisse.services;

import app.neotech.gestion.de.caisse.shared.dto.IngredientDto;

public interface IngredientService {

	IngredientDto createIngredient (IngredientDto ingredientDto);
	IngredientDto getIngredientByIngredientId(Long id);
}
