package ptit.example.tttnapplication.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class EmployeesRequest {
    @NotBlank(message = "Email is required")
    @Email
    private String email;
    @NotBlank(message = "Password is required")
    private String password;
    @NotBlank(message = "First Name is required")
    private String firstName;
    @NotBlank(message = "Last Name is required")
    private String lastName;
    @NotNull(message = "CMND is required")
    private Integer nationalIdentityCard;
    private Date dateOfBirth;
    @NotBlank(message = "Address is required")
    private String address;
    @NotNull(message = "Phone is required")
    private Integer phone;
}