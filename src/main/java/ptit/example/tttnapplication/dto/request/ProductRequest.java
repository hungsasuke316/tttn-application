package ptit.example.tttnapplication.dto.request;

import lombok.Getter;
import lombok.Setter;
import ptit.example.tttnapplication.data.entity.Category;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ProductRequest {
    @NotNull(message = "Category ID is required")
    Category category;
    @NotBlank(message = "Name is required")
    String name;
    @NotNull(message = "Price is required")
    Double price;
    @NotBlank(message = "Thumbnail is required")
    String thumbnail;
    @NotBlank(message = "Description is required")
    String description;
}
