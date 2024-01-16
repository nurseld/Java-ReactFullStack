package com.tobeto.rentalcardemo.services.concretes;

import com.tobeto.rentalcardemo.config.JwtService;
import com.tobeto.rentalcardemo.core.mapper.services.ModelMapperService;
import com.tobeto.rentalcardemo.entities.concretes.User;
import com.tobeto.rentalcardemo.enums.Role;
import com.tobeto.rentalcardemo.services.abstracts.AuthenticateService;
import com.tobeto.rentalcardemo.services.abstracts.UserService;
import com.tobeto.rentalcardemo.services.dto.authenticate.requests.AuthenticationRequest;
import com.tobeto.rentalcardemo.services.dto.authenticate.requests.RegisterRequest;
import com.tobeto.rentalcardemo.services.dto.authenticate.responses.AuthenticationResponse;
import com.tobeto.rentalcardemo.services.dto.user.requests.AddUserRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticateManager implements AuthenticateService {


    private final UserService userService;
    private final ModelMapperService modelMapperService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        userService.add(this.modelMapperService.forRequest().map(user, AddUserRequest.class));
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userService.getByEmail(request.getEmail());
        var jwtToken = jwtService.generateToken(modelMapperService.forResponse().map(user, User.class));
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
