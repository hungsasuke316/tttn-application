package ptit.example.tttnapplication.services;

import ptit.example.tttnapplication.data.entity.Coupon;
import ptit.example.tttnapplication.dto.request.CouponRequest;
import ptit.example.tttnapplication.dto.response.CouponResponse;

import java.util.List;

public interface CouponService {
    List<Coupon> getAllCoupons();
    CouponResponse createCoupon(CouponRequest couponRequest);
}
