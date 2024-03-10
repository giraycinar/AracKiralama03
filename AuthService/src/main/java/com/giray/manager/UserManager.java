package com.giray.manager;

import com.giray.dto.request.CreateUserRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.giray.constant.RestApiUrls.ACTIVATE_STATUS;
import static com.giray.constant.RestApiUrls.DELETE_BY_TOKEN;


@FeignClient(url = "http://localhost:7071/api/v1/user-profile",name = "auth-userprofile")
public interface UserManager {

    @PostMapping("/create")
        public ResponseEntity<Boolean> createUser(@RequestBody CreateUserRequestDto dto);
    @GetMapping(ACTIVATE_STATUS+"/{authId}")
    public ResponseEntity<Boolean> activateStatus(@PathVariable Long authId);
    @DeleteMapping(DELETE_BY_TOKEN)
    public ResponseEntity<Boolean> deleteByToken(@RequestParam String token);
    //@RequestParam Controller sinifinda default deger olarak atansa da benim UserManager'im bir controller degil ve bunu bilemez.
    //dolayisiyla bir veri gonderirken mutlaka @RequestParam @RequestBody @PathVariable gibi anotasyonlardan birisini mutlaka kullanmak zorundayim.
}


