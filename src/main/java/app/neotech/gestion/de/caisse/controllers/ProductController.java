	package app.neotech.gestion.de.caisse.controllers;


import java.util.Set;
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
import app.neotech.gestion.de.caisse.services.ProductService;
import app.neotech.gestion.de.caisse.shared.dto.ProductDto;

@RestController
@RequestMapping("/products")

public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping
	public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
		ProductDto createProduct= productService.createProduct(productDto);
		return new ResponseEntity<ProductDto>(createProduct,HttpStatus.CREATED);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<ProductDto> getProduct(@PathVariable Long id) {
		ProductDto productDto = productService.getProductById(id);
		return new ResponseEntity<ProductDto>(productDto,HttpStatus.OK);
	}
	
	@PutMapping(path="/{id}")
	public ResponseEntity<ProductDto> UpdateProduct(@PathVariable Long id,@RequestBody ProductDto productDto) {
		ProductDto updateProduct= productService.updateProduct(id,productDto);
		return new ResponseEntity<ProductDto>(updateProduct,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Object> DeleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(path="/category/{id}")
	public ResponseEntity<Set<ProductDto>>getProductsByCategoryId(@PathVariable Long id){
		
		Set<ProductDto> products = productService.getProductsByCategoryId(id);
		return new ResponseEntity<Set<ProductDto>>(products,HttpStatus.OK);
	}

}
