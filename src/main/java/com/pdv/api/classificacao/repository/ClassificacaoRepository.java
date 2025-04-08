package com.pdv.api.classificacao.repository;

import com.pdv.api.classificacao.model.entity.Classificacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassificacaoRepository extends JpaRepository<Classificacao, Integer> {
}
