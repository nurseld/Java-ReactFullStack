package com.tobeto.rentalcardemo.services.abstracts;

import com.tobeto.rentalcardemo.services.dto.authenticate.requests.AuthenticationRequest;
import com.tobeto.rentalcardemo.services.dto.authenticate.requests.RegisterRequest;
import com.tobeto.rentalcardemo.services.dto.authenticate.responses.AuthenticationResponse;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticateService {

    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);
}
