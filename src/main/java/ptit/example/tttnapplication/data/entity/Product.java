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
    private Double price;
    private String thumbnail;
    private String description;
    private Boolean status;

    @JsonIgnore
    @OneToMany (mappedBy = "product")
    private Set<Rating> ratings;

    @JsonIgnore
    @OneToMany (mappedBy = "product")
    private Set<Image> images;

    @JsonIgnore
    @OneToMany (mappedBy = "product")
    private Set<Cart_Item> cartItems;

    @JsonIgnore
    @OneToMany (mappedBy = "product")
    private Set<Orders_Item> ordersItems;

    @JsonIgnore
    @OneToMany (mappedBy = "product")
    private Set<Comment> comments;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
