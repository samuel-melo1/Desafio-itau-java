package com.samuelm.desafioitau.service.validacoes.impl;

import com.samuelm.desafioitau.dto.TransacaoRequest;
import com.samuelm.desafioitau.exceptions.FormularioInvalidoException;
import com.samuelm.desafioitau.service.validacoes.Validacao;
import org.springframework.stereotype.Component;

@Component
public class ValidaCamposPreenchidosImpl implements Validacao {
    @Override
    public void validar(TransacaoRequest request) {
        if(request.valor() == null || request.dataHora() == null){
            throw new FormularioInvalidoException("Campo valor ou dataHora não foram preenchidos!");
        }
    }
}
