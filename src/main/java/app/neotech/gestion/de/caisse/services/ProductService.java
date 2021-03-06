package app.neotech.gestion.de.caisse.services;


import java.util.Set;
import app.neotech.gestion.de.caisse.shared.dto.ProductDto;

public interface ProductService {
	
	ProductDto createProduct(ProductDto productDto);
	ProductDto getProductById(Long id);
	ProductDto updateProduct(Long id, ProductDto productDto);
	void deleteProduct(long id);
	Set<ProductDto> getProductsByCategoryId(Long id);

}
