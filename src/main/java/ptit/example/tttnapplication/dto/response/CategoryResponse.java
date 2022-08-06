package ptit.example.tttnapplication.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryResponse {
    private Integer categoryId;
    private String name;
    private String description;
}
