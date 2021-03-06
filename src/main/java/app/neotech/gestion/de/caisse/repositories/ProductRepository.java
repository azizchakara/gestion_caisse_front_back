package app.neotech.gestion.de.caisse.repositories;

import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import app.neotech.gestion.de.caisse.entities.ProductEntity;


@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
	
	ProductEntity findProductById(Long id);
	Set<ProductEntity> findProductsByCategoryId(Long id);
	
}
