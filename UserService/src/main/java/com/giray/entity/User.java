package com.giray.entity;


import com.giray.utility.enums.EStatus;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Document


public class User extends BaseEntity {

    @Id
    private String id;

    private Long authId;
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

//    private List<String> customers = new ArrayList<>();

}