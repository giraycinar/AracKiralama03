package com.giray.entity;

import com.giray.utility.EStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity



public class Vehicle extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String model;
    private String plate;
    private String color;
    private String description;
    private Long createAt;
    private Long updateAt;
    private Boolean isActive;
//    private Boolean isRented;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EStatus status = EStatus.RENTABLE;

    @Builder.Default
    private List<String> cars = new ArrayList<>();

}
