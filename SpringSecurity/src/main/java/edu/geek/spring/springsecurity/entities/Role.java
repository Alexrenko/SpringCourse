package edu.geek.spring.springsecurity.entities;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Transient
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users;

    @Override
    public String getAuthority() {
        return getName();
    }

    public Role() {
    }

    public Role(long id) {
        this.id = id;
    }

    public Role(long id, String name) {
        this.id = id;
        this.name = name;
    }

    //@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@JoinColumn(name = "username")
    //private User user;

    //@ManyToMany
    //@JoinTable(name = "users_authorities",
    //        joinColumns = @JoinColumn(name = "authority_id"),
    //        inverseJoinColumns = @JoinColumn(name = "user_id"))
    //private Collection<User> users;
}
