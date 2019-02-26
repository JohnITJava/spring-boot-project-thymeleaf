package com.geekbrains.springbootproject.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @Column(name = "title")
    private String title;

    @Column(name = "cost")
    private double cost;
}
