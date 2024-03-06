package com.giray.entity;

import com.giray.utility.ERole;
import com.giray.utility.EStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Auth extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @Size(min = 3, max =20, message = "Kullanici adi en az 3, en fazla 20 karakter olabilir.")
    private String username;
    @Size(min = 8, max = 32, message ="Kullanici sifresi en az 8, en fazla 32 karakterden olusabilir." )
    private String password;
    @Email
    private String email;
    private Long createAt;
    private Long updateAt;
    private Boolean isActive;
    private String activationCode;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private ERole role = ERole.USER;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EStatus status = EStatus.RENTABLE;

}
