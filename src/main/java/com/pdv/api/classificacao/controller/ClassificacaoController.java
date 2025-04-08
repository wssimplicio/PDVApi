package com.pdv.api.classificacao.controller;

import com.pdv.api.classificacao.model.DTO.ClassificacaoDTO;
import com.pdv.api.classificacao.model.entity.Classificacao;
import com.pdv.api.classificacao.service.ClassificacaoService;
import com.pdv.api.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/classificacao")
public class ClassificacaoController {

    @Autowired
    private ClassificacaoService classificacaoService;

    @GetMapping()
    public ResponseEntity<ApiResponse<List<ClassificacaoDTO>>> getAllPessoas(){
        List<ClassificacaoDTO> list = classificacaoService.getAll();
        ApiResponse<List<ClassificacaoDTO>> res = new ApiResponse<>("Listagem de Classificação", list);
        return ResponseEntity.ok().body(res);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Classificacao>> save(@RequestBody ClassificacaoDTO classificacaoDTO) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("Salvo Com Sucesso!",classificacaoService.salvar(classificacaoDTO)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Classificacao>> update(@PathVariable Integer id, @RequestBody ClassificacaoDTO classificacaoDTO) {
        try {
            Classificacao classificacao = classificacaoService.update(id, classificacaoDTO);
            ApiResponse<Classificacao> res = new ApiResponse<>("Atualizado Com Sucesso!", classificacao);
            return ResponseEntity.ok(res);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
