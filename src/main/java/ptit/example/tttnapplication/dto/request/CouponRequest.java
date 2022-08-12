package ptit.example.tttnapplication.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CouponRequest {
    private String code;
    private Date startDate;
    private Date endDate;
    private Integer value;
    private Integer customerClassId;
}
