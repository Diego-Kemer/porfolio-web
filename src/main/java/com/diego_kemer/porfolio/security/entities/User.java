
package com.diego_kemer.porfolio.security.entities;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;

@Getter @Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "user_id")
    private String id;
    @NotNull
    @NaturalId
    @Column(unique = true)
    private String userName;
    @NotNull
    private String password;
    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    //Esta tabla simplemente la usamos para identificar que role tiene cada usuari y que cada usuario pueda tener más de un role
    @JoinTable(name="user_role_relate", joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns=@JoinColumn(name="role_id"))
    private transient Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    
            
    
}
