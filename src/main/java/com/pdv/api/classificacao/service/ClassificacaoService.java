package com.pdv.api.classificacao.service;

import com.pdv.api.classificacao.model.DTO.ClassificacaoDTO;
import com.pdv.api.classificacao.model.entity.Classificacao;
import com.pdv.api.classificacao.repository.ClassificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassificacaoService {

    @Autowired
    private ClassificacaoRepository classificacaoRepository;

    public List<ClassificacaoDTO> getAll() {
      return classificacaoRepository.findAll().stream()
                .map(ClassificacaoDTO::new)
                .toList();
    }

    public Classificacao salvar(ClassificacaoDTO classificacaoDTO) {
        Classificacao classificacao = new Classificacao(classificacaoDTO);
        return classificacaoRepository.save(classificacao);
    }
}
