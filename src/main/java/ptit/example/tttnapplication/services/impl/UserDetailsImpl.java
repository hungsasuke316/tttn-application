package ptit.example.tttnapplication.services.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ptit.example.tttnapplication.data.entity.Account;
import ptit.example.tttnapplication.data.entity.Roles;

import java.util.*;

@Getter
@Setter
public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;
    private String username;
    @JsonIgnore
    private String password;
    private Roles roles;
    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(String username, String password, Roles roles, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.authorities = authorities;
    }

    public static UserDetailsImpl build(Account account) {
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        if (account.getRoles().getName().equalsIgnoreCase("employee")){
            authorities.add(new SimpleGrantedAuthority("employee"));
        }
        if (account.getRoles().getName().equalsIgnoreCase("customer")){
            authorities.add(new SimpleGrantedAuthority("customer"));
        }
        return new UserDetailsImpl(
            account.getEmail(),
            account.getPassword(),
            account.getRoles(),
            authorities);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl account = (UserDetailsImpl) o;
        return Objects.equals(username, account.username);
    }
}