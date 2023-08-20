package com.quizza.api.security;

import com.quizza.api.entity.User;
import com.quizza.api.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;

@Component
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {


    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String user_id) throws UsernameNotFoundException {

        Optional<User> userRes = userRepository.findById(Integer.parseInt(user_id));

        if (userRes.isEmpty()) {
            throw new UsernameNotFoundException("User not found with id : " + user_id);
        }

        User user = userRes.get();

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + user.getUserType());

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                Arrays.asList(authority)
        );

    }


}