package ptit.example.tttnapplication.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private Integer ordersId;
    private Date ordersDate;
    private Integer valueCode;
    private Integer total;
    private Integer customerId;
    private String customerAddress;
    private Integer customerPhone;
    private Integer employeeId;
    private Integer statusOrder;
}
