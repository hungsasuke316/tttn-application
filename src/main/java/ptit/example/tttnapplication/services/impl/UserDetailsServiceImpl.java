package ptit.example.tttnapplication.services.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ptit.example.tttnapplication.data.entity.Account;
import ptit.example.tttnapplication.data.repositpty.AccountRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final AccountRepository accountRepository;

    public UserDetailsServiceImpl (AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        Account account = accountRepository.findById(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User Not Found with -> username or email : " + email)
                );

        return UserDetailsImpl.build(account);
    }
}
