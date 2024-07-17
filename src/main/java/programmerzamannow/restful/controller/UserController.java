package programmerzamannow.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import programmerzamannow.restful.entity.User;
import programmerzamannow.restful.model.RegisterUserRequest;
import programmerzamannow.restful.model.UpdateUserRequest;
import programmerzamannow.restful.model.UserResponse;
import programmerzamannow.restful.model.WebResponse;
import programmerzamannow.restful.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
 
    @PostMapping(
            path = "api/users",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> register(@RequestBody RegisterUserRequest request) {
        userService.register(request);
        return WebResponse.<String>builder().data("OK").build();
    }

    @GetMapping(
            path = "/api/users/current",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<UserResponse> get(User user) {
        UserResponse userResponse = userService.get(user);
        return WebResponse.<UserResponse>builder().data(userResponse).build();
    }

    @PatchMapping(
            path = "/api/users/current",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<UserResponse> update(User user, @RequestBody UpdateUserRequest request){
        UserResponse userResponse = userService.update(user, request);
        return WebResponse.<UserResponse>builder().data(userResponse).build();
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("registerUserRequest", new RegisterUserRequest());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterUserRequest request, Model model) {
        try {
            userService.register(request);
            model.addAttribute("message", "User registered successfully");
            return "login";
        } catch (ResponseStatusException e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }
}
