package ptit.example.tttnapplication.data.repositpty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ptit.example.tttnapplication.data.entity.Rating;
import ptit.example.tttnapplication.data.entity.Rating_ID;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Rating_ID> {
}
