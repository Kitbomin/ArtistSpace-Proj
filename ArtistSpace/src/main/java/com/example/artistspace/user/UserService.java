package com.example.artistspace.user;

import com.example.artistspace.enums.SocialType;
import com.example.artistspace.user.dto.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public User signUp(UserRequest.SignUpDto signUpDto) {
        User user = signUpDto.toUser();
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        user.setSocialType(SocialType.Normal);

        return userRepository.save(user);
    }

    @Transactional
    public User signIn(UserRequest.SignInDto signInDto) {
        User userEntity = userRepository
                .findByEmail(signInDto.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        if (userEntity == null) {
            throw new IllegalArgumentException("User not found");
        }

        return userEntity;
    }
}
