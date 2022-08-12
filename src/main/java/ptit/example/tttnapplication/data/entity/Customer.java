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
    private String email;
    private String firstName;
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private CustomerClass customerClass;

    @OneToOne(mappedBy = "customer")
    private Account customer;

    @OneToOne(mappedBy = "customer")
    private Cart cart;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private Set<CustomerAddress> customerAddress;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private Set<Comment> comment;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private Set<Rating> rating;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private Set<Orders> orders;

}
