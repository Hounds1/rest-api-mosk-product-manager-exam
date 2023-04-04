package mosk.product.io.exam.manager.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import mosk.product.io.exam.manager.domain.model.Category;
import mosk.product.io.exam.manager.domain.model.Product;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class SimpleProductResponse {

    private Long id;

    private String name;

    private String description;

    @JsonIgnore
    private Category category;

    public static SimpleProductResponse of(final Product product) {
        return SimpleProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .category(product.getCategory())
                .build();
    }
}
