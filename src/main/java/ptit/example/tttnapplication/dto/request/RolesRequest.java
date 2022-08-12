package ptit.example.tttnapplication.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class RolesRequest {
    @NotBlank(message = "Name is required")
    private String name;
}
