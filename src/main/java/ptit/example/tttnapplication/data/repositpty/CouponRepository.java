package ptit.example.tttnapplication.data.repositpty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ptit.example.tttnapplication.data.entity.Coupon;
import ptit.example.tttnapplication.data.entity.CouponId;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, CouponId> {
}
