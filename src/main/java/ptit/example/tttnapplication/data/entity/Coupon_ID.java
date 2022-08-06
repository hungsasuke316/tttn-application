package ptit.example.tttnapplication.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

@Embeddable
@Getter
@Setter
public class Coupon_ID implements Serializable {
    private String code;
    private Date startDate;

}
