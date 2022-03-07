package com.dariotintore.backend.Service;

import com.dariotintore.backend.Entity.User;
import com.dariotintore.backend.Repository.UserRepository;
import com.dariotintore.backend.Utils.ResponseHelper;
import com.dariotintore.backend.Utils.UserCheck;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenService tokenService;

    public ResponseEntity<JSONObject> saveUser(User user) {
        // CHECK PRE-REGISTRATION
        if (!isEmailAvailable(user.getEmail())) return ResponseHelper.buildBadRequestResponse("Email already used");
        if (!UserCheck.isPasswordLongEnough(user.getPassword()))
            return ResponseHelper.buildBadRequestResponse("Password too short");
        // REGISTRATION
        user.setPassword(UserCheck.passwordEncrypter(user.getPassword()));
        if(!user.getEmail().equals("testing@test.com"))
        userRepository.save(user);
        return ResponseHelper.buildOkResponse("User created");
    }

    public Optional<User> findUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return user;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    private boolean userDoesExist(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.isPresent();
    }

    public boolean isEmailAvailable(String email) {
        Long check;
        check = userRepository.checkEmailAlreadyExists(email);
        return check <= 0;
    }

    public ResponseEntity<JSONObject> deleteUserById(Long id) {
        if (userDoesExist(id)) {
            userRepository.deleteById(id);
            return ResponseHelper.buildOkResponse("User deleted");
        } else {
            return ResponseHelper.buildNotFoundResponse("User not found");
        }
    }

    public ResponseEntity<JSONObject> login(User user) {
        if (userRepository.doesUserExist(user.getEmail()) > 0) {
            String encryptedPassword = userRepository.loginUser(user.getEmail(), user.getPassword());
            if (UserCheck.checkPassword(user.getPassword(), encryptedPassword)) { // Check password validity
                String token = getToken(user);
                return ResponseHelper.buildOkResponse("Login effettuato", token);
            }
        }
        return ResponseHelper.buildBadRequestResponse("Email o password errata");
    }

    public String getToken(User user) {
        return tokenService.generateToken(user.getEmail());
    }
}
