package mosk.product.io.exam.manager.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name")
    private String name;

    private int price;

    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "name")
    private Category category;

    /**
     * 비즈니스 로직
     */

    public void setCategory(final Category category) {
        this.category = category;
    }
}
