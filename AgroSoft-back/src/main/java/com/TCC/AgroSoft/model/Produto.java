package com.TCC.AgroSoft.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Produto {

    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NonNull
    private String categoria; // Verificar se não herda os atributos por meio de uma LISt

    private String urlVideo;

    private List<ImgProd> imagensProduto; //Verificar se fluxo correto

    private Double preco;

}
