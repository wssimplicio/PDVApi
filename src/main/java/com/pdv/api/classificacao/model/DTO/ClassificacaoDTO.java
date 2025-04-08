package com.pdv.api.classificacao.model.DTO;

import com.pdv.api.classificacao.model.entity.Classificacao;

public record ClassificacaoDTO(

        String descricao,
        Integer nivel,

        Integer idpai
) {

    public ClassificacaoDTO(Classificacao classificacao) {
        this(classificacao.getDescricao(), classificacao.getNivel(), classificacao.getIdpai());
    }
}
