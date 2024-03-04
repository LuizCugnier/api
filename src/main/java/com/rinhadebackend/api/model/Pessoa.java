package com.rinhadebackend.api.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 32, unique = true)
    private String apelido;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate nascimento;

    @ElementCollection
    @CollectionTable(name = "pessoa_stack")
    @Column(name = "stack", length = 32)
    private List<String> stack;

}
