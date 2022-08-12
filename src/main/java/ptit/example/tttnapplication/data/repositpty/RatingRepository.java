package ptit.example.tttnapplication.data.repositpty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ptit.example.tttnapplication.data.entity.Rating;
import ptit.example.tttnapplication.data.entity.RatingId;

@Repository
public interface RatingRepository extends JpaRepository<Rating, RatingId> {
}
