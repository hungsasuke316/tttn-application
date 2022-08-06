package ptit.example.tttnapplication.data.repositpty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ptit.example.tttnapplication.data.entity.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {
}
