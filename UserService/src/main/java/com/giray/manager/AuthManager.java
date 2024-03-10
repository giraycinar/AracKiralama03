package com.giray.manager;

import com.giray.dto.request.CreateUserRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.giray.constant.RestApiUrls.DELETE_BY_TOKEN;


@FeignClient(url = "http://localhost:7070/api/v1/auth",name = "user-auth")
public interface AuthManager {


}
