package com.TCC.AgroSoft.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pessoa {

    private String name;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NonNull
    private String email;

    @NonNull
    private Integer telefone;

    @NonNull
    private Integer password;

    private String ImgPessoa;
}
