package app.neotech.gestion.de.caisse.services;

import app.neotech.gestion.de.caisse.exceptions.CategoryAlreadyExist;
import app.neotech.gestion.de.caisse.exceptions.NullException;
import app.neotech.gestion.de.caisse.shared.dto.CategoryDto;

public interface CategoryService {
	
	CategoryDto createCategory(CategoryDto categoryDto) throws NullException,CategoryAlreadyExist;
	void deleteCategory(long id);
	CategoryDto getCategoryById(Long id);
	CategoryDto updateCategory(Long id, CategoryDto categoryDto);

}
