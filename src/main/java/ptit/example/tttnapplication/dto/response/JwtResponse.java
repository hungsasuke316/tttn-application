package ptit.example.tttnapplication.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class JwtResponse {
    private String token;
    private String type = "Bearer";
//    private Integer usersId;
    private String username;
    private List<String> roles;

    public JwtResponse(String token, String username, List<String> roles) {
        this.token = token;
//        this.usersId = usersId;
        this.username = username;
        this.roles = roles;
    }
}