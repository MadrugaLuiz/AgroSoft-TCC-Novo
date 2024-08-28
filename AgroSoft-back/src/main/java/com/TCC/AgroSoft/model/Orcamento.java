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
    @JoinTable(
            name = " orcamento_cliente",
            joinColumns = @JoinColumn(name = "orcamento_id" ),
            inverseJoinColumns = @JoinColumn(name = "cliente_id" )
    )
    private Cliente cliente;

    @NonNull
    @ManyToMany
    @JoinTable(
            name = "orcamento_vendedor",
            joinColumns = @JoinColumn(name = "orcamento_id"),
            inverseJoinColumns = @JoinColumn(name = "vendedor_id")
    )
    private Vendedor vendedor;


    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "orcamento_produto",
            joinColumns = @JoinColumn(name = "orcamento_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<Produto> produtosOrcamento; //Verificar escrita código e seu relacionamento

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "orcamento_servico",
            joinColumns = @JoinColumn(name = "orcamento_id"),
            inverseJoinColumns = @JoinColumn(name = "servico_id")
    )
    private List<Servico> servicosOrcamento;//Verificar escrita código e seu relacionamento

    private Double total;

    @NonNull
    private Boolean statusOrcamento;


}