package ptit.example.tttnapplication.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class RegisterRequest {
    @NotBlank(message = "Email is required")
    @Email
    private String email;
    @NotBlank(message = "Password is required")
    private String password;
    @NotBlank(message = "first Name is required")
    private String firstName;
    @NotBlank(message = "Last Name is required")
    private String lastName;
}