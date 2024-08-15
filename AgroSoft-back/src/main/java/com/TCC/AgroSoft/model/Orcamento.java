package com.TCC.AgroSoft.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Orcamento {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NonNull
    @ManyToMany
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @NonNull
    @ManyToMany
    @JoinColumn(name = "vendedor_id")
    private Vendedor vendedor;


    @JsonIgnore
    @ManyToMany(mappedBy = "produto")
    private List<Produto> produtosOrcamento; //Verificar escrita código e seu relacionamento

    @JsonIgnore
    @ManyToMany(mappedBy = "servico")
    private List<Servico> servicosOrcamento;//Verificar escrita código e seu relacionamento

    private Double total;

    @NonNull
    private Boolean statusOrcamento;


}
