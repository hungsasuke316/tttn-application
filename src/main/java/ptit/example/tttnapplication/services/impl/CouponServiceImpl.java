package ptit.example.tttnapplication.services.impl;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ptit.example.tttnapplication.data.entity.Coupon;
import ptit.example.tttnapplication.data.entity.CouponId;
import ptit.example.tttnapplication.data.entity.CustomerClass;
import ptit.example.tttnapplication.data.entity.Employee;
import ptit.example.tttnapplication.data.repositpty.CouponRepository;
import ptit.example.tttnapplication.data.repositpty.CustomerClassRepository;
import ptit.example.tttnapplication.data.repositpty.EmployeeRepository;
import ptit.example.tttnapplication.dto.request.CouponRequest;
import ptit.example.tttnapplication.dto.response.CouponResponse;
import ptit.example.tttnapplication.exceptions.ResourceNotFoundException;
import ptit.example.tttnapplication.services.CouponService;

import java.util.List;

@AllArgsConstructor
@Service
public class CouponServiceImpl implements CouponService {
    private final CouponRepository couponRepository;
    private final ModelMapper modelMapper;
    private final AuthenticationServiceImpl authenticationService;
    private final EmployeeRepository employeeRepository;
    private final CustomerClassRepository customerClassRepository;

    @Override
    public List<Coupon> getAllCoupons() {
        return this.couponRepository.findAll();
    }

    @Override
    public CouponResponse createCoupon(CouponRequest couponRequest) {
        String username = authenticationService.getAuthentication();
        Employee employee = employeeRepository.findByEmail(username).orElseThrow(() ->
                new ResourceNotFoundException("Not Found Employee"));

        Coupon coupon = modelMapper.map(couponRequest, Coupon.class);

        CustomerClass customerClass = this.customerClassRepository.findById(couponRequest.getCustomerClassId()).orElseThrow(() ->
                new ResourceNotFoundException("Not Found Customer Class With ID: " + couponRequest.getCustomerClassId()));

        CouponId couponId = new CouponId();
        couponId.setCode(couponRequest.getCode());
        couponId.setStartDate(couponRequest.getStartDate());

        coupon.setCouponId(couponId);
        coupon.setCustomerClass(customerClass);
        coupon.setEmployee(employee);

        couponRepository.save(coupon);

        CouponResponse couponResponse = modelMapper.map(couponRequest, CouponResponse.class);
        couponResponse.setEmployee(employee.getEmail());

        return couponResponse;
    }
}
