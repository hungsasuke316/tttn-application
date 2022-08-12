package ptit.example.tttnapplication.services.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ptit.example.tttnapplication.services.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{
    @Override
    public String getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
