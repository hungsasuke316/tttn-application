package ptit.example.tttnapplication.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartId;

    @JsonIgnore
    @OneToMany(mappedBy = "cart")
    private Set<Cart_Item> cartItems;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
