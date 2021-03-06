package app.neotech.gestion.de.caisse.services.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.neotech.gestion.de.caisse.entities.IngredientEntity;
import app.neotech.gestion.de.caisse.repositories.IngredientRepository;
import app.neotech.gestion.de.caisse.services.IngredientService;
import app.neotech.gestion.de.caisse.shared.dto.IngredientDto;


@Service
public class IngredientServiceImpl implements IngredientService {

	@Autowired
	IngredientRepository ingredientRepository;
	
	@Override
	public IngredientDto createIngredient(IngredientDto ingredient) {
		IngredientEntity ingredientEntity = new IngredientEntity();
		BeanUtils.copyProperties(ingredient, ingredientEntity);
		IngredientEntity newIngredient = ingredientRepository.save(ingredientEntity);
		IngredientDto ingredientDto = new IngredientDto();
		BeanUtils.copyProperties(newIngredient, ingredientDto);
		return ingredientDto;
	}

	@Override
	public IngredientDto getIngredientByIngredientId(Long id) {
		IngredientEntity ingredientEntity = ingredientRepository.findIngredientById(id);
		if(ingredientEntity == null) throw null;
		IngredientDto ingredientDto = new IngredientDto();
		BeanUtils.copyProperties(ingredientEntity, ingredientDto);
		return ingredientDto;
	}

}
