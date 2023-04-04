package mosk.product.io.exam.manager.domain.dto;

import lombok.*;
import mosk.product.io.exam.manager.domain.model.Category;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class CreateCategoryRequest {

    private String name;

    private String description;

    public Category toEntity() {
        return Category.builder()
                .name(name)
                .description(description)
                .build();
    }
}
