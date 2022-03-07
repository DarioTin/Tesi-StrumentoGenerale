package com.dariotintore.backend.Controller;

import com.dariotintore.backend.Entity.User;
import com.dariotintore.backend.Service.TokenService;
import com.dariotintore.backend.Service.UserService;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;

    @GetMapping("/")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping(path = "/")
    public ResponseEntity<JSONObject> saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<JSONObject> deleteUser(@PathVariable Long id) {
        return userService.deleteUserById(id);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<JSONObject> login(@RequestBody User user) {
        logger.info(" "+ user.getEmail());
        return userService.login(user);
    }

    @PostMapping("/validate")
    public ResponseEntity<JSONObject> validateToken(@RequestBody JSONObject body) {
        String email = (String) body.get("email");
        String token = (String) body.get("token");
        return tokenService.validateToken(email, token);
    }

}
