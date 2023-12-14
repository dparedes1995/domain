package com.projElektra.domain.controllers;

import com.projElektra.domain.constants.ErrorMessageConstants;
import com.projElektra.domain.constants.HttpStatusConstants;
import com.projElektra.domain.constants.MessageConstants;
import com.projElektra.domain.exceptions.MySqlException;
import com.projElektra.domain.models.User;
import com.projElektra.domain.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("domain")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        try {
            userService.createUser(user);
            return ResponseEntity.status(HttpStatusConstants.OK).body(MessageConstants.USER_REGISTERED);
        } catch (Exception e) {
            throw new MySqlException(ErrorMessageConstants.ERROR_DB + e.getMessage(),
                    HttpStatusConstants.INTERNAL_SERVER_ERROR);
        }
    }

    @ExceptionHandler(MySqlException.class)
    public ResponseEntity<String> handleMySqlException(MySqlException ex) {
        return ResponseEntity.status(ex.getHttpStatus()).body(ex.getMessage());
    }
}