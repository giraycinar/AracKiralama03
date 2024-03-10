package com.giray.dto.response;

import com.giray.utility.enums.EStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDto {
    @Id
    private Long id;

    private long authId;
    private String username;
    private String email;
    private String password;
    private String address;
    private String phone;
    private Long createAt;
    private Long updateAt;
    private Boolean isActive;

    @Builder.Default
    private EStatus status = EStatus.PENDING;
}
