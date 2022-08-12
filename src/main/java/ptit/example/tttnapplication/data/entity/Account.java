package ptit.example.tttnapplication.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Account {
    @Id
    private String email;
    private String password;
    private Boolean enable;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Roles roles;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "email", referencedColumnName = "email")
    private Customer customer;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "email", referencedColumnName = "email")
    private Employee employee;

    @Override
    public String toString() {
        return "Account{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", customer=" + customer +
                ", employee=" + employee +
                '}';
    }
}
