package app.neotech.gestion.de.caisse.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import app.neotech.gestion.de.caisse.services.IngredientService;
import app.neotech.gestion.de.caisse.shared.dto.IngredientDto;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {
	
	@Autowired
	IngredientService ingredientService;
	
	@GetMapping(path="/{id}")
	public ResponseEntity<IngredientDto> getIngredient(@PathVariable long id) {
		
		IngredientDto ingredientDto = ingredientService.getIngredientByIngredientId(id);
		return new ResponseEntity<IngredientDto>(ingredientDto,HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<IngredientDto> createIngredient(@RequestBody IngredientDto ingredientDto) {
		IngredientDto createIngredient = ingredientService.createIngredient(ingredientDto);
		return new ResponseEntity<IngredientDto>(createIngredient,HttpStatus.ACCEPTED);
	}
	
	@PutMapping
	public String updateIngredient() {
		return "update ingredient";
		
	}
	
	@DeleteMapping
	public String deleteIngredient() {
		return "delete ingredient";
	}

}
