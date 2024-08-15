package com.TCC.AgroSoft.model;


import jakarta.persistence.Entity;
import lombok.NonNull;

@Entity
public class Vendedor extends Pessoa {

    @NonNull
    private String tipo;
}
