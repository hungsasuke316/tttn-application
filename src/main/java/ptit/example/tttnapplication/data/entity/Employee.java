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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private Integer nationalIdentityCard;
    private Date dateOfBirth;
    private String address;
    private Integer phone;
    private Boolean enable;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "email", referencedColumnName = "email")
    private Account email;

    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    private Set<Orders> orders;

    @JsonIgnore
    @OneToMany (mappedBy = "employee")
    private Set<Coupon> coupon;

}
