package com.giray.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {

    INTERNAL_SERVER_ERROR(5200, "Sunucu Hatasi",HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST (4200,"Parametre hatasi", HttpStatus.BAD_REQUEST),
    USERNAME_DUPLICATE(4211,"Böyle bir kullanici adi sistemde mevcut...", HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND(4212,"Böyle bir kullanici bulunamadi...",HttpStatus.BAD_REQUEST),
    USER_NOT_CREATED(4213,"Kullanıcı oluşturulamadı..." ,HttpStatus.BAD_REQUEST ),
    INVALID_TOKEN(4214,"Geçersiz token" ,HttpStatus.BAD_REQUEST),
    FOLLOW_ALREADY_EXIST(4215, "Boyle bir takip isteği daha once olusturulmustur",HttpStatus.BAD_REQUEST);


    private int code;
    private String message;
    private HttpStatus httpStatus;
}
