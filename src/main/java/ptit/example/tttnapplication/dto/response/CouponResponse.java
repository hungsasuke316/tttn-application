package ptit.example.tttnapplication.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CouponResponse {
    private String code;
    private Date startDate;
    private Date endDate;
    private Integer value;
    private Integer customerClassId;
    private String employee;
}
