package com.richieoscar.flightreservation.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Role extends EntityId implements GrantedAuthority {


    private String name;

    @ManyToMany(mappedBy="roles")
    private  Set<AppUser> appUsers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<AppUser> getUsers() {
        return appUsers;
    }

    public void setUsers(Set<AppUser> appUsers) {
        this.appUsers = appUsers;
    }


    @Override
    public String getAuthority() {
        return name;
    }
}
