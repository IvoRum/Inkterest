package com.ink.authentication.service;

import com.ink.authentication.repository.UserRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
@ReadingConverter
@RequiredArgsConstructor
public class AuthenticationService {
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;


    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = userRepository.findByEmail(request.getEmail()).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "user not found"
                )
        );

        var jwtToken = jwtUtil.generateToken(user);

        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .build();
    }
}