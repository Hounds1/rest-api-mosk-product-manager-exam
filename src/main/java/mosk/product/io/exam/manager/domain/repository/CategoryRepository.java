package mosk.product.io.exam.manager.domain.repository;

import mosk.product.io.exam.manager.domain.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByName(final String name);
}
