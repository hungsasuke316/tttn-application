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

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Roles roles;

    @JsonIgnore
    @OneToOne(mappedBy = "email")
    private Customer customer;

    @JsonIgnore
//    @Transient
    @OneToOne(mappedBy = "email", cascade=CascadeType.ALL)
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
