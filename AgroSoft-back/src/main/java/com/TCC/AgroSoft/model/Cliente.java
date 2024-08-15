package com.TCC.AgroSoft.model;


import jakarta.persistence.Entity;
import lombok.*;

@Entity
public class Cliente  extends  Pessoa{

    @NonNull
    private Boolean IsCliente;

}
