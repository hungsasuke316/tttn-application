package ptit.example.tttnapplication.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Customer_Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer classId;
    private String name;
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "customerClass")
    private Set<Coupon> coupons;

    @JsonIgnore
    @OneToMany(mappedBy = "customerClass")
    private Set<Customer> customer;
}
