package ptit.example.tttnapplication.services;

import org.springframework.http.ResponseEntity;
import ptit.example.tttnapplication.dto.request.LoginRequest;
import ptit.example.tttnapplication.dto.request.RegisterRequest;
import ptit.example.tttnapplication.dto.response.RegisterResponse;

public interface RegisterService {
    RegisterResponse signUpUser(RegisterRequest dto);
    ResponseEntity<?> signInUser(LoginRequest dto);
}
