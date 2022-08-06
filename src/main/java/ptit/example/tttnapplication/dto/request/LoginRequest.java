package ptit.example.tttnapplication.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class LoginRequest {
    @NotBlank(message = "Email is required")
    @Email
    private String username;

    @NotBlank(message = "Email is required")
    private String password;

}