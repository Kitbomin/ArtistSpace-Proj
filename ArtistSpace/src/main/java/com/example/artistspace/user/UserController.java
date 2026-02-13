package com.example.artistspace.user;

import com.example.artistspace.user.dto.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<?>  signUp(@RequestBody UserRequest.SignUpDto signUpDto) {
        User user = userService.signUp(signUpDto);

        return ResponseEntity.ok(user);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<?> signIn(@RequestBody UserRequest.SignInDto signInDto) {
        User user = userService.signIn(signInDto);

        return ResponseEntity.ok(user);
    }

//    @PostMapping("/update")
//    publ
}
