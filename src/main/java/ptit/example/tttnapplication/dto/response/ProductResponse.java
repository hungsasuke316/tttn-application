package ptit.example.tttnapplication.dto.response;

import lombok.Getter;
import lombok.Setter;
import ptit.example.tttnapplication.data.entity.Category;

@Getter
@Setter
public class ProductResponse {
    Integer productId;
    String name;
    Double price;
    String thumbnail;
    String description;
    Boolean status;
    Category category;
}
