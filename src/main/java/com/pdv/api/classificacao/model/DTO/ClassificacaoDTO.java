package com.pdv.api.classificacao.model.DTO;

import com.pdv.api.classificacao.model.entity.Classificacao;

public record ClassificacaoDTO(
        Integer id,

        String descricao,
        Integer nivel,

        Integer idpai
) {

    public ClassificacaoDTO(Classificacao classificacao) {
        this(classificacao.getId(), classificacao.getDescricao(), classificacao.getNivel(), classificacao.getIdpai());
    }

    public Classificacao classificacaoMapper() {
        Classificacao classificacao = new Classificacao();

        classificacao.setDescricao(this.descricao());
        classificacao.setNivel(this.nivel());
        classificacao.setIdpai(this.idpai());

        return classificacao;
    }
}
