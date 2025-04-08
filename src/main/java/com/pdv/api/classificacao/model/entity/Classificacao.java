package com.pdv.api.classificacao.model.entity;

import com.pdv.api.classificacao.model.DTO.ClassificacaoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "classificacao")
@Entity(name = "classificacao")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Classificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 60, nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Integer nivel;

    @Column()
    private Integer idpai;

}