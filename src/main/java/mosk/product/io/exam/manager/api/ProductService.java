package mosk.product.io.exam.manager.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mosk.product.io.exam.manager.domain.dto.SimpleProductResponse;
import mosk.product.io.exam.manager.domain.model.Category;
import mosk.product.io.exam.manager.domain.model.Product;
import mosk.product.io.exam.manager.domain.repository.CategoryRepository;
import mosk.product.io.exam.manager.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public SimpleProductResponse create(final Product product, final String categoryName) {
        Category findCategory = categoryRepository.findByName(categoryName)
                .orElseThrow(() -> new IllegalStateException("불러올 수 없는 상태"));

        product.setCategory(findCategory);
        Product savedProduct = productRepository.save(product);

        return SimpleProductResponse.of(savedProduct);
    }

}
