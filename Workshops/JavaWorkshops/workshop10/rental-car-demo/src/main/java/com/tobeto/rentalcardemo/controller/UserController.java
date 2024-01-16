package com.tobeto.rentalcardemo.controller;

import com.tobeto.rentalcardemo.services.abstracts.UserService;
import com.tobeto.rentalcardemo.services.dto.user.requests.AddUserRequest;
import com.tobeto.rentalcardemo.services.dto.user.requests.DeleteUserRequest;
import com.tobeto.rentalcardemo.services.dto.user.requests.UpdateUserRequest;
import com.tobeto.rentalcardemo.services.dto.user.responses.GetAllUserResponse;
import com.tobeto.rentalcardemo.services.dto.user.responses.GetByIdUserResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/auth/users")

public class UserController {
    private final UserService userService;

    @PostMapping("/add")
    public void add(@RequestBody @Valid AddUserRequest request){
        userService.add(request);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody @Valid DeleteUserRequest request){
        userService.delete(request);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid UpdateUserRequest request){
        userService.update(request);
    }

    @GetMapping("/getAll")
    public List<GetAllUserResponse> getAll(){
        return userService.getAll();
    }

    @GetMapping("/getById")
    public GetByIdUserResponse getById(@RequestParam int id){
        return userService.getById(id);
    }
}