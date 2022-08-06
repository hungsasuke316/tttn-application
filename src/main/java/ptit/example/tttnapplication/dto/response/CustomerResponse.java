package ptit.example.tttnapplication.dto.response;

import lombok.Getter;
import lombok.Setter;
import ptit.example.tttnapplication.data.entity.Customer_Class;

@Getter
@Setter
public class CustomerResponse {
    private Integer customerId;
    private String firstName;
    private String lastName;
    private Boolean enable;
    private Customer_Class customerClass;
}
