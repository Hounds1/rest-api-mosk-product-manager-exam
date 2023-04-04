package mosk.product.io.exam.manager.domain.dto;

import lombok.*;
import mosk.product.io.exam.manager.domain.model.Product;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class CreateProductRequest {

    private String name;

    private String description;

    private int price;

    private String categoryName;

    public Product toEntity() {
        return Product.builder()
                .name(name)
                .description(description)
                .price(price)
                .build();
    }
}
