package ptit.example.tttnapplication.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class CustomerClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer classId;
    private String name;
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "customerClass")
    private Set<Coupon> coupon;

    @JsonIgnore
    @OneToMany(mappedBy = "customerClass")
    private Set<Customer> customer;
}
