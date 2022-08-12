package ptit.example.tttnapplication.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    private String name;
    private Integer price;
    private String thumbnail;
    private String description;
    private Boolean status;

    @JsonIgnore
    @OneToMany (mappedBy = "product")
    private Set<Rating> rating;

    @JsonIgnore
    @OneToMany (mappedBy = "product")
    private Set<Image> image;

    @JsonIgnore
    @OneToMany (mappedBy = "product")
    private Set<CartItem> cartItem;

    @JsonIgnore
    @OneToMany (mappedBy = "product")
    private Set<OrdersItem> ordersItem;

    @JsonIgnore
    @OneToMany (mappedBy = "product")
    private Set<Comment> comment;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
