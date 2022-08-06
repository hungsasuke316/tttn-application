package ptit.example.tttnapplication.dto.request;

import lombok.Getter;
import lombok.Setter;
import ptit.example.tttnapplication.data.entity.Roles;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class UsersUpdateDto {
    @NotNull(message = "Role is required")
    private Roles roles;
    @NotBlank(message = "Email is required")
    @Email
    private String username;
    @NotBlank(message = "Password is required")
    private String password;
    @NotBlank(message = "First Name is required")
    private String firstName;
    @NotBlank(message = "Last Name is required")
    private String lastName;
    @NotBlank(message = "Address is required")
    private String address;
    @NotNull(message = "Phone is required")
    private Integer phone;
    @NotBlank(message = "Status is required")
    private String status;
    private Date createdDate;
    private Date updatedDate;

}
