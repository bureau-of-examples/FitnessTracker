package com.pluralsight.model.security;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

/**
 * Spring Security User.
 */
@Entity
public class User {

    @Id
    @NotNull
    @Size(min = 4)
    @Column(length = 50, nullable = false, updatable = false)
    private String username;

    @Size(min = 4)
    @NotNull
    @Column(length = 60, nullable = false)
    private String password;

    @NotNull
    @Column(nullable = false)
    private Boolean enabled = Boolean.TRUE;

    @OneToMany(orphanRemoval = true, fetch = FetchType.EAGER, mappedBy = "owner", cascade = {CascadeType.ALL})
    private Set<Authority> authorities = new HashSet<>();

    @CollectionTable(name = "user_permissions")
    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @MapKeyClass(String.class)
    @MapKeyColumn(nullable = false, length = 60)
    @Column(length = 70)
    private Map<String, String> permissions = new HashMap<>();

    public Authority addAuthority(String auth){
        Authority authority = new Authority();
        authority.setOwner(this);
        authority.setAuthority(auth);
        if(!this.getAuthorities().contains(authority))
            this.authorities.add(authority);
        else {
            for (Authority a : this.getAuthorities()){
                if(Objects.equals(a.getAuthority(), auth))
                    return a;
            }
        }
        return authority;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public Map<String, String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Map<String, String> permissions) {
        this.permissions = permissions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return username.equals(user.username);
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }
}
