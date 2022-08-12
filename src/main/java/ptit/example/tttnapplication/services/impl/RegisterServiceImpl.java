package ptit.example.tttnapplication.services.impl;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ptit.example.tttnapplication.data.entity.*;
import ptit.example.tttnapplication.data.repositpty.*;

import ptit.example.tttnapplication.dto.request.LoginRequest;
import ptit.example.tttnapplication.dto.request.RegisterRequest;
import ptit.example.tttnapplication.dto.response.CustomerResponse;
import ptit.example.tttnapplication.dto.response.JwtResponse;
import ptit.example.tttnapplication.dto.response.RegisterResponse;
import ptit.example.tttnapplication.exceptions.ResourceNotAcceptException;
import ptit.example.tttnapplication.jwt.JwtUtils;
import ptit.example.tttnapplication.services.RegisterService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class RegisterServiceImpl implements RegisterService {
    private final AccountRepository accountRepository;
    private final RolesRepository rolesRepository;
    private final CustomerRepository customerRepository;
    private final CustomerClassRepository customerClassRepository;

    private final CartRepository cartRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    @Override
    public RegisterResponse signUpUser(RegisterRequest dto) {
        Optional<Account> accountOptional = this.accountRepository.findById(dto.getEmail());

        if (accountOptional.isPresent()){
            throw new ResourceNotAcceptException("Email already exist");
        }

        dto.setPassword(passwordEncoder.encode(dto.getPassword()));

        Account account = modelMapper.map(dto, Account.class);
        Customer customer = modelMapper.map(dto, Customer.class);

        Roles roles = this.rolesRepository.findByName("customer");
        account.setRoles(roles);
        account.setEnable(true);
        Account saveAccount =accountRepository.save(account);

        CustomerClass customerClass = this.customerClassRepository.findByName("new");
        customer.setCustomerClass(customerClass);
        customer.setCustomer(saveAccount);
        Customer saveCustomer = customerRepository.save(customer);
        CustomerResponse customerResponse = modelMapper.map(saveCustomer, CustomerResponse.class);

        Cart cart = new Cart();
        cart.setCustomer(customer);
        cartRepository.save(cart);

        RegisterResponse registerResponse = modelMapper.map(saveAccount, RegisterResponse.class);
        registerResponse.setCustomerResponse(customerResponse);
        return registerResponse;
    }

    @Override
    public ResponseEntity<?> signInUser(LoginRequest dto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
        // if go there, the user/password is correct
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // generate jwt to return to client
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getUsername(),
                roles));
    }
}
