package mosk.product.io.exam.manager.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mosk.product.io.exam.manager.domain.dto.SimpleCategoryResponse;
import mosk.product.io.exam.manager.domain.dto.SimpleProductResponse;
import mosk.product.io.exam.manager.domain.model.Category;
import mosk.product.io.exam.manager.domain.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class CategoryReadService {

    private final CategoryRepository categoryRepository;

    public SimpleCategoryResponse findByName(final String name) {
        Category findCategory = categoryRepository.findByName(name)
                .orElseThrow(() -> new IllegalStateException("불러올 수 없는 상태"));

        return SimpleCategoryResponse.of(findCategory);
    }

    public List<SimpleProductResponse> findAllProductFromCategoryName(final String categoryName) {
        Category findCategory = categoryRepository.findByName(categoryName)
                .orElseThrow(() -> new IllegalStateException("불러올 수 없는 상태"));

        return findCategory.getProducts().stream()
                .map(product -> SimpleProductResponse.of(product))
                .collect(Collectors.toList());
    }
}
