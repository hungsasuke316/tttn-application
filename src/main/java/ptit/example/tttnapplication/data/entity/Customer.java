package ptit.example.tttnapplication.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    private String firstName;
    private String lastName;
    private Boolean enable;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Customer_Class customerClass;

    @OneToOne
    @JoinColumn(name = "email", referencedColumnName = "email")
    private Account email;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private Set<Customer_Address> customerAddress;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private Set<Comment> comments;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private Set<Rating> ratings;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private Set<Cart> carts;
}
