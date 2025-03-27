package com.samuelm.desafioitau.service.validacoes.impl;

import com.samuelm.desafioitau.dto.TransacaoRequest;
import com.samuelm.desafioitau.exceptions.ValorNegativoException;
import com.samuelm.desafioitau.service.validacoes.Validacao;
import org.springframework.stereotype.Component;

@Component
public class ValidaValorNegativoImpl implements Validacao {


    @Override
    public void validar(TransacaoRequest request) {
        boolean numeroNegativo = request.valor() < 0;

        if(numeroNegativo){
            throw new ValorNegativoException("Não é permitido informar valor negativo!");
        }
    }
}
