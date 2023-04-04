package mosk.product.io.exam.manager.domain.dto;

import lombok.*;
import mosk.product.io.exam.manager.domain.model.Category;
import mosk.product.io.exam.manager.domain.model.Product;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class SimpleCategoryResponse {


    private Long id;
    private String name;
    private String description;

    private List<Product> products;

    public static SimpleCategoryResponse of(final Category category) {
        return SimpleCategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .products(category.getProducts())
                .build();
    }
}
