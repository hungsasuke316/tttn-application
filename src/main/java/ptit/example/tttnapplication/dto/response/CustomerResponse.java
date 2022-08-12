package ptit.example.tttnapplication.dto.response;

import lombok.Getter;
import lombok.Setter;
import ptit.example.tttnapplication.data.entity.CustomerClass;

@Getter
@Setter
public class CustomerResponse {
    private String email;
    private String firstName;
    private String lastName;
    private Boolean enable;
    private CustomerClass customerClass;
}
