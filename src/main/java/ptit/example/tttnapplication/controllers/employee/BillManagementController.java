package ptit.example.tttnapplication.controllers.employee;

import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ptit.example.tttnapplication.dto.response.OrderPaginationResponse;
import ptit.example.tttnapplication.dto.response.OrderReportResponse;
import ptit.example.tttnapplication.dto.response.OrderResponse;
import ptit.example.tttnapplication.services.OrdersService;
import ptit.example.tttnapplication.utils.AppConstants;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/admin/api/bills")
public class BillManagementController {
    private final OrdersService ordersService;

    public BillManagementController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }


    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public OrderPaginationResponse getAllBillsInPagination(
            @RequestParam(
                    value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false)
            int pageNo,
            @RequestParam(
                    value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE , required = false)
            int pageSize,
            @RequestParam(
                    value = "sortBy", defaultValue = "id", required = false)
            String sortBy,
            @RequestParam(
                    value = "sortDir", defaultValue = "desc", required = false)
            String sortDir) {

        return ordersService.getAllBills(pageNo, pageSize, sortBy, sortDir );
    }

    @GetMapping("/{status}")
    @ResponseStatus(HttpStatus.OK)
    public OrderPaginationResponse getBillsByStatus(
            @RequestParam(
                    value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false)
            int pageNo,
            @RequestParam(
                    value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE , required = false)
            int pageSize,
            @RequestParam(
                    value = "sortBy", defaultValue = "id", required = false)
            String sortBy,
            @RequestParam(
                    value = "sortDir", defaultValue = "desc", required = false)
            String sortDir,
            @PathVariable("status") String status
    ) {
        return ordersService.getAllBillsByStatus(pageNo, pageSize, sortBy, sortDir, status);
    }

    @GetMapping("/detail/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderResponse getBillByBillId(@PathVariable("id") int id
    ) {
        return ordersService.getSingleBillDetail(id);
    }


    @PutMapping("/change/status")
    @ResponseStatus(HttpStatus.OK)
    public OrderResponse changeBillStatus(@RequestParam("bill") int billId,
                                         @RequestParam("status") String status) {
        return ordersService.changeBilStatus(billId, status);
    }

    @GetMapping("/report")
    @ResponseStatus(HttpStatus.OK)
    public OrderReportResponse getSaleReport(@Param("start") String dateStart,
                                             @Param("end") String dateEnd) {
        return ordersService.getSaleReportByDateRange(dateStart, dateEnd);
    }
}
