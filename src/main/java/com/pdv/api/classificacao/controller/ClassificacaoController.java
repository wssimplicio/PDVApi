package com.pdv.api.classificacao.controller;

import com.pdv.api.classificacao.model.DTO.ClassificacaoDTO;
import com.pdv.api.classificacao.model.entity.Classificacao;
import com.pdv.api.classificacao.service.ClassificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/classificacao")
public class ClassificacaoController {

    @Autowired
    private ClassificacaoService classificacaoService;

    @GetMapping()
    public ResponseEntity<List<ClassificacaoDTO>> getAllPessoas(){
        return ResponseEntity.ok().body(classificacaoService.getAll());
    }

    @PostMapping
    public ResponseEntity<Classificacao> criar(@RequestBody ClassificacaoDTO classificacaoDTO) {
        System.out.println(classificacaoDTO);
        return ResponseEntity.ok(classificacaoService.salvar(classificacaoDTO));
    }
}
