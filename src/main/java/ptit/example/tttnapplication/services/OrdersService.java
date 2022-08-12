package ptit.example.tttnapplication.services;

import ptit.example.tttnapplication.dto.request.OrderRequest;
import ptit.example.tttnapplication.dto.response.OrderDetailResponse;
import ptit.example.tttnapplication.dto.response.OrderPaginationResponse;
import ptit.example.tttnapplication.dto.response.OrderReportResponse;
import ptit.example.tttnapplication.dto.response.OrderResponse;

import java.util.List;

public interface OrdersService {
    OrderResponse orderProduct(OrderRequest orderRequest);

    OrderResponse getBillById( int billId);

    OrderResponse getSingleBillDetail(int billId);

    OrderResponse changeBilStatus(int billId, String status) ;

    List<OrderDetailResponse> getBillByAccount();

    OrderPaginationResponse getAllBills(int pageNo,
                                        int pageSize,
                                        String sortBy,
                                        String sortDir);

    OrderPaginationResponse getAllBillsByStatus(int pageNo,
                                               int pageSize,
                                               String sortBy,
                                               String sortDir,
                                               String status);
    OrderReportResponse getSaleReportByDateRange(String dateStart, String dateEnd);
}
