package com.pdv.api.classificacao.service;

import com.pdv.api.classificacao.model.DTO.ClassificacaoDTO;
import com.pdv.api.classificacao.model.entity.Classificacao;
import com.pdv.api.classificacao.repository.ClassificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
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
        return classificacaoRepository.save(classificacaoDTO.classificacaoMapper());
    }

    public Classificacao update(Integer id, ClassificacaoDTO classificacaoDTO) {
        return classificacaoRepository.findById(id).map(c -> {
                c.setDescricao(classificacaoDTO.descricao());
                c.setNivel(classificacaoDTO.nivel());
                c.setIdpai(classificacaoDTO.idpai());
            return classificacaoRepository.save(c);
        }).orElseThrow(() -> new RuntimeException("Classificação não encontrada"));
    }
}
