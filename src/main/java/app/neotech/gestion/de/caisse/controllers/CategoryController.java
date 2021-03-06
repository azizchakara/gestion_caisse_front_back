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
import app.neotech.gestion.de.caisse.exceptions.CategoryAlreadyExist;
import app.neotech.gestion.de.caisse.exceptions.NullException;
import app.neotech.gestion.de.caisse.exceptions.RessourceAlreadyExistException;
import app.neotech.gestion.de.caisse.exceptions.RessourceNotFoundException;
import app.neotech.gestion.de.caisse.services.CategoryService;
import app.neotech.gestion.de.caisse.shared.dto.CategoryDto;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@PostMapping
	public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) throws NullException,CategoryAlreadyExist {
		if(categoryDto.getCategoryName() == null || categoryDto.getLogo() == null)
		throw new NullException("category Name and logo already exist");
		CategoryDto createCategory = categoryService.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(createCategory,HttpStatus.CREATED);
	}

	@DeleteMapping(path="/{id}")
	public ResponseEntity<Object> deleteCategory(@PathVariable Long id) throws NullException{
		categoryService.deleteCategory(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Long id) throws NullException,RessourceNotFoundException{
		CategoryDto categoryDto = categoryService.getCategoryById(id);
		return new ResponseEntity<CategoryDto>(categoryDto,HttpStatus.OK);
	}
	
	@PutMapping(path="/{id}")
	public ResponseEntity<CategoryDto> updateCategory(@PathVariable Long id,@RequestBody CategoryDto categoryDto) throws RessourceAlreadyExistException{
		CategoryDto updateCategory = categoryService.updateCategory(id,categoryDto);
		return new ResponseEntity<CategoryDto>(updateCategory,HttpStatus.ACCEPTED);
	}


}
