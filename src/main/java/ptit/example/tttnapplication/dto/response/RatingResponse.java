package ptit.example.tttnapplication.dto.response;

import lombok.Getter;
import lombok.Setter;
import ptit.example.tttnapplication.data.entity.Product;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class RatingResponse {
    private UUID ratingId;
    //private Users users;
    private Product product;
    private Integer rating;
    private Date createdDate;
}
