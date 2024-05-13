package com.workintech.s18d2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@MappedSuperclass
public abstract class Plant {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name ="id")
    private long id;

    @Column(name="name")
    @NotNull(message=" Name con not be null")
    @Size(min=2, max=5, message="Name size must be between 2 to 45")
    private String name;

    @Column(name="price")
    @DecimalMin("10")
    private Double price;
}
