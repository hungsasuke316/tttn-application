package ptit.example.tttnapplication.dto.request;

import lombok.Getter;
import lombok.Setter;
import ptit.example.tttnapplication.data.entity.Product;

import java.util.Date;

@Getter
@Setter
public class RatingRequest {
    //private Users users;
    private Product product;
    private Integer rating;
    private Date createdDate;
}
