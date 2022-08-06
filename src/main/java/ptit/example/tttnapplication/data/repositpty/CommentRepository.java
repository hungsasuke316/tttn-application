package ptit.example.tttnapplication.data.repositpty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ptit.example.tttnapplication.data.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
