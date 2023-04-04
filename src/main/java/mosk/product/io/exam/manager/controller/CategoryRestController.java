package mosk.product.io.exam.manager.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mosk.product.io.exam.manager.api.CategoryReadService;
import mosk.product.io.exam.manager.api.CategoryService;
import mosk.product.io.exam.manager.domain.dto.CreateCategoryRequest;
import mosk.product.io.exam.manager.domain.dto.SimpleCategoryResponse;
import mosk.product.io.exam.manager.domain.dto.SimpleProductResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1")
public class CategoryRestController {

    private final CategoryService categoryService;
    private final CategoryReadService categoryReadService;

    @PostMapping("/categories")
    public ResponseEntity<SimpleCategoryResponse> create(@RequestBody final CreateCategoryRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.create(request.toEntity()));
    }

    @GetMapping("/categories")
    public ResponseEntity<SimpleCategoryResponse> findByName(@RequestParam(name = "categoryName") final String categoryName) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryReadService.findByName(categoryName));
    }

    @GetMapping("/categories/product")
    public ResponseEntity<List<SimpleProductResponse>> findAllProductFromCategoryName(@RequestParam(name = "categoryName") final String categoryName) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryReadService.findAllProductFromCategoryName(categoryName));
    }
}
