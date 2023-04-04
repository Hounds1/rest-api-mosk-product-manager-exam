package mosk.product.io.exam.manager.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mosk.product.io.exam.manager.api.ProductService;
import mosk.product.io.exam.manager.domain.dto.CreateProductRequest;
import mosk.product.io.exam.manager.domain.dto.SimpleProductResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1")
public class ProductRestController {


    private final ProductService productService;

    @PostMapping("/products")
    public ResponseEntity<SimpleProductResponse> create(@RequestBody final CreateProductRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.create(request.toEntity(), request.getCategoryName()));
    }
}
