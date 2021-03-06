package app.neotech.gestion.de.caisse.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.neotech.gestion.de.caisse.entities.CategoryEntity;
import app.neotech.gestion.de.caisse.mapper.CategoryMapper;
import app.neotech.gestion.de.caisse.repositories.CategoryRepository;
import app.neotech.gestion.de.caisse.services.CategoryService;
import app.neotech.gestion.de.caisse.shared.dto.CategoryDto;


@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryRepository categoryRepository;
	
	
	
	@Autowired
	CategoryMapper categoryMapper;
	
	@Override
	public CategoryDto createCategory(CategoryDto category) {
		
		
		CategoryEntity categoryEntity = categoryMapper.modelToEntity(category);
		CategoryEntity newCategory = categoryRepository.save(categoryEntity);
		return categoryMapper.entityToModel(newCategory);
	}

	@Override
	public void deleteCategory(long id) {
		
		
		CategoryEntity categoryEntity = categoryRepository.findCategoryById(id);
		if(categoryEntity == null) throw null;
		categoryRepository.delete(categoryEntity);
		
	}

	@Override
	public CategoryDto getCategoryById(Long id) {

		CategoryEntity categoryEntity = categoryRepository.findCategoryById(id);
		if(categoryEntity == null) throw null;
		CategoryDto categoryDto = categoryMapper.entityToModel(categoryEntity);
		return categoryDto;
}

	@Override
	public CategoryDto updateCategory(Long id, CategoryDto categoryDto) {
		// TODO Auto-generated method stub
		return null;
	}
}
