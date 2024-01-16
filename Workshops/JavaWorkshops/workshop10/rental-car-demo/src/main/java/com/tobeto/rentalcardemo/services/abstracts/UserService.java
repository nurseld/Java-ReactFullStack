package com.tobeto.rentalcardemo.services.abstracts;

import com.tobeto.rentalcardemo.services.dto.user.requests.AddUserRequest;
import com.tobeto.rentalcardemo.services.dto.user.requests.DeleteUserRequest;
import com.tobeto.rentalcardemo.services.dto.user.requests.UpdateUserRequest;
import com.tobeto.rentalcardemo.services.dto.user.responses.GetAllUserResponse;
import com.tobeto.rentalcardemo.services.dto.user.responses.GetByIdUserResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void add(AddUserRequest request);
    void delete(DeleteUserRequest request);
    void update(UpdateUserRequest request);
    List<GetAllUserResponse> getAll();

    GetByIdUserResponse getByEmail(String email);

    GetByIdUserResponse getById(int id);
}
