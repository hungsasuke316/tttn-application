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
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ordersId;
    private Integer total;
    private Date ordersDate;
    private Integer statusOrder;
    private Boolean statusBill;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private CustomerAddress customerAddress;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "code",
                    referencedColumnName = "code"),
            @JoinColumn(
                    name = "startDate",
                    referencedColumnName = "startDate")
    })
    private Coupon coupon;

    @JsonIgnore
    @OneToMany(mappedBy = "orders")
    private Set<OrdersItem> ordersItems;
}
