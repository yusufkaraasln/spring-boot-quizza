package com.quizza.api.service;

import com.quizza.api.entity.User;
import com.quizza.api.enums.UserType;
import com.quizza.api.ex.AlreadyExistsException;
import com.quizza.api.ex.UserNotFoundException;
import com.quizza.api.repository.UserRepository;
import com.quizza.api.security.JWTUtil;
import com.quizza.api.util.Result;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthService {

    private UserRepository userRepository;

    private JWTUtil jwtUtil;
    private AuthenticationManager authManager;
    private PasswordEncoder passwordEncoder;



    public Result<String> signin(String email, String password) throws UserNotFoundException {

        Optional<User> userRes = userRepository.findFirstByEmail(email);

        if (userRes.isEmpty()) {
            return new Result<>(false, "error", "User not found");
        }

        User user = userRes.get();

        UsernamePasswordAuthenticationToken authInputToken =
                new UsernamePasswordAuthenticationToken(user.getId(), password);
        authManager.authenticate(authInputToken);
        String token = jwtUtil.generateToken(user.getId());
        System.out.println(token);

        return new Result<>(true, "success", token);


    }


    public Result<String> signup(String email, String password, String name, String surname, String username) throws AlreadyExistsException {

        Optional<User> userRes = userRepository.findFirstByEmail(email);

        if (userRes.isPresent()) {
            System.out.println(userRes.get());
            return new Result<>(false, "error", "User already exists");
        }

        User user = new User();


        String encodedPass = passwordEncoder.encode(password);


        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(encodedPass);
        user.setName(name);
        user.setSurname(surname);
        user.setUserType(UserType.USER);
        userRepository.save(user);

        return new Result<>(true, "success", "User created");

    }
}