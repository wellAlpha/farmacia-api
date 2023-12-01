package com.proj.farmacia.entities;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
@Where (clause = "ativo = true")
@SQLDelete (sql = "UPDATE EstoqueMedicacao SET ativo = false WHERE = id?;" )
public class EstoqueMedicacao {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = " INT UNSIGNED NOT NULL")
    private Integer medicacao_id;

    @Column(nullable = false)
    @ColumnDefault("true")
    private Boolean  ativo = true;

    

    
}
