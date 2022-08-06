package ptit.example.tttnapplication.dto.response;

import lombok.Getter;
import lombok.Setter;
import ptit.example.tttnapplication.data.entity.Customer;
import ptit.example.tttnapplication.data.entity.Roles;

@Getter
@Setter
public class RegisterResponse {
    private String email;
    private Roles roles;
    private CustomerResponse customerResponse;
}
