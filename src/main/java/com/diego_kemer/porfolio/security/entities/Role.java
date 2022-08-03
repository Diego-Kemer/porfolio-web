
package com.diego_kemer.porfolio.security.entities;

import com.diego_kemer.porfolio.security.enums.RoleList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private RoleList rolName;

    public Role() {
    }

    public Role(RoleList rolName) {
        this.rolName = rolName;
    }
    
    
}
