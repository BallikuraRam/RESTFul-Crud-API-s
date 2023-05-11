package com.crud.security;

import com.crud.exception.UserNotFoundException;
import com.crud.model.Users;
import com.crud.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UsersRepository repository;

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {

        Users users = repository.findByUserEmail(userEmail)
                .orElseThrow(() -> new UserNotFoundException(String
                        .format("User not found with is %s  userEmail  : ", userEmail)));

        Set<String> roles = new HashSet<String>();
        roles.add("ROLE_ADMIN");
        return new User(users.getUserEmail(), users.getPassword(), userAuthorities(roles));
    }

    private Collection<? extends GrantedAuthority> userAuthorities(Set<String> roles) {
        return roles.stream().map(
                role -> new SimpleGrantedAuthority(role)
        ).collect(Collectors.toList());
    }
}
