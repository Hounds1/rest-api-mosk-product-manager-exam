package mosk.product.io.exam.manager.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mosk.product.io.exam.manager.domain.dto.SimpleCategoryResponse;
import mosk.product.io.exam.manager.domain.model.Category;
import mosk.product.io.exam.manager.domain.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public SimpleCategoryResponse create(final Category category) {
        Category savedCategory = categoryRepository.save(category);

        return SimpleCategoryResponse.of(savedCategory);
    }
}
