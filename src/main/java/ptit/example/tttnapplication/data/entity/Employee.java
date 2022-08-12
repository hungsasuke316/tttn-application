package ptit.example.tttnapplication.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
public class Employee {
    @Id
    private String email;
    private String firstName;
    private String lastName;
    private Integer nationalIdentityCard;
    private Date dateOfBirth;
    private String address;
    private Integer phone;

    @JsonIgnore
    @OneToOne(mappedBy = "employee")
    private Account employee;

    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    private Set<Orders> orders;

    @JsonIgnore
    @OneToMany (mappedBy = "employee")
    private Set<Coupon> coupon;
}
