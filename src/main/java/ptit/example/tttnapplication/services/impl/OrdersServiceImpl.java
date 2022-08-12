package ptit.example.tttnapplication.services.impl;

import org.springframework.stereotype.Service;
import ptit.example.tttnapplication.dto.request.OrderRequest;
import ptit.example.tttnapplication.dto.response.OrderDetailResponse;
import ptit.example.tttnapplication.dto.response.OrderPaginationResponse;
import ptit.example.tttnapplication.dto.response.OrderReportResponse;
import ptit.example.tttnapplication.dto.response.OrderResponse;
import ptit.example.tttnapplication.services.OrdersService;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {


    @Override
    public OrderResponse orderProduct(OrderRequest orderRequest) {
        return null;
    }

    @Override
    public OrderResponse getBillById(int billId) {
        return null;
    }

    @Override
    public OrderResponse getSingleBillDetail(int billId) {
        return null;
    }

    @Override
    public OrderResponse changeBilStatus(int billId, String status) {
        return null;
    }

    @Override
    public List<OrderDetailResponse> getBillByAccount() {
        return null;
    }

    @Override
    public OrderPaginationResponse getAllBills(int pageNo, int pageSize, String sortBy, String sortDir) {
        return null;
    }

    @Override
    public OrderPaginationResponse getAllBillsByStatus(int pageNo, int pageSize, String sortBy, String sortDir, String status) {
        return null;
    }

    @Override
    public OrderReportResponse getSaleReportByDateRange(String dateStart, String dateEnd) {
        return null;
    }
}
