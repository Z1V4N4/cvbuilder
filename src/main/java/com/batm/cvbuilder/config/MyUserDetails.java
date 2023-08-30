package com.batm.cvbuilder.config;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.batm.cvbuilder.model.master.User;
import com.batm.cvbuilder.repository.management.UserManagementRepository;

@Service
public class MyUserDetails implements UserDetails, UserDetailsService {
    @Autowired
    private UserManagementRepository managementRepository;
    private String username;
    private String password;
    private GrantedAuthority authority;

    public MyUserDetails() {
        super();
    }

    public MyUserDetails(User user) {
        this.username = user.getEmail();
        this.password = user.getPassword();
        this.authority = new SimpleGrantedAuthority(user.getRole().getName());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = managementRepository.Login(username);
        return new MyUserDetails(user);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> grantedAuthority = new HashSet<>();
        grantedAuthority.add(authority);
        return grantedAuthority;
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
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }
}
