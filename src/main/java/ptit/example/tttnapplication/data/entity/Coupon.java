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
public class Coupon {
    @Id
    private CouponId couponId;
    private Integer value;
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private CustomerClass customerClass;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @JsonIgnore
    @OneToMany(mappedBy = "coupon")
    private Set<Orders> orders;

}
