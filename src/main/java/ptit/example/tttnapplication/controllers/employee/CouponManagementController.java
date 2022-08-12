package ptit.example.tttnapplication.controllers.employee;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ptit.example.tttnapplication.data.entity.Coupon;
import ptit.example.tttnapplication.dto.request.CouponRequest;
import ptit.example.tttnapplication.dto.response.CouponResponse;
import ptit.example.tttnapplication.services.CouponService;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@AllArgsConstructor
@RestController
@RequestMapping("/employee")
public class CouponManagementController {

    private final CouponService couponService;
    @GetMapping("/coupon")
    List<Coupon> getAllCategory(){
        return this.couponService.getAllCoupons();
    }


    @PostMapping("/coupon")
    @ResponseStatus(HttpStatus.CREATED)
    CouponResponse createCategory(@Valid @RequestBody CouponRequest couponRequest){
        return this.couponService.createCoupon(couponRequest);
    }
}
