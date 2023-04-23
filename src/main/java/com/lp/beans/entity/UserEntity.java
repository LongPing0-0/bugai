//用户实体类
package com.lp.beans.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity implements UserDetails {
    private Integer uid;
    private String username;
    private String password;
    private Boolean enabled;
    private Boolean accountNonExpired;
    private Boolean accountNonLocked;
    private Boolean credentialsNonExpired;
    private List<RoleEntity> roles = new ArrayList<>();
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        roles.forEach(role->{
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role.getRname());
            authorities.add(simpleGrantedAuthority);
        });
        return authorities;
    }
    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }
    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }
    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
