package com.proj.farmacia.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "medicacao_composicao")
public class MedicacaoComposicao {
    @Id
     @Column(name = "dosagem")
    private String dosagem;
    
}
