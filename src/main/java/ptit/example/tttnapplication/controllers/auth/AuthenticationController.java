package ptit.example.tttnapplication.controllers.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ptit.example.tttnapplication.dto.request.LoginRequest;
import ptit.example.tttnapplication.dto.request.RegisterRequest;
import ptit.example.tttnapplication.dto.response.RegisterResponse;
import ptit.example.tttnapplication.services.RegisterService;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api")
public class AuthenticationController {
    private final RegisterService registerService;

    @Autowired
    public AuthenticationController(RegisterService registerService) {
        this.registerService = registerService;
    }
    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    RegisterResponse signUpUser(@Valid @RequestBody RegisterRequest dto){
        return this.registerService.signUpUser(dto);
    }

    @PostMapping("/sign-in")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<?> signUpUser(@Valid @RequestBody LoginRequest dto){
        return this.registerService.signInUser(dto);
    }
}
