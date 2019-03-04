package com.geekbrains.springbootproject.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "product")
@Data //При компиляции геттеры и сеттеры автоматически сгенирируются
@NoArgsConstructor //Автоматическая генерация конструктора без аргументов при компиляции
public class Product {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;


    @NotNull(message = "Title can not be null")
    @Size(min = 3, message = "Title length must be greater than 3 symbols")
    @Column(name = "title")
    private String title;

    @NotNull(message = "Cost can not be null")
    @Column(name = "cost")
    @Min(value = 1)
    private double cost;
}
