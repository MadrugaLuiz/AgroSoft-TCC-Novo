package com.TCC.AgroSoft.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImgServico {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer IdServico;

    private String url;
}
