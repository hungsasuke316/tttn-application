package ptit.example.tttnapplication.dto.response;

import lombok.Getter;
import lombok.Setter;
import ptit.example.tttnapplication.data.entity.Account;

import java.util.Date;

@Getter
@Setter
public class EmployeesResponse {
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private Integer nationalIdentityCard;
    private Date dateOfBirth;
    private String address;
    private Integer phone;
    private Boolean enable;
    private Account email;
}
