package ptit.example.tttnapplication.data.repositpty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ptit.example.tttnapplication.data.entity.Coupon;
import ptit.example.tttnapplication.data.entity.Coupon_ID;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Coupon_ID> {
}
