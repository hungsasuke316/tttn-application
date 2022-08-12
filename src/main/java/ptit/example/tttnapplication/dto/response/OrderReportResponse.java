package ptit.example.tttnapplication.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class OrderReportResponse {
    Long sale ;

    List<OrderDetailResponse> listBills;
}
