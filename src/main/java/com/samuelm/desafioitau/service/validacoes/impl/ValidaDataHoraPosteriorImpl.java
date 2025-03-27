package com.samuelm.desafioitau.service.validacoes.impl;

import com.samuelm.desafioitau.dto.TransacaoRequest;
import com.samuelm.desafioitau.exceptions.DataHoraFuturoException;
import com.samuelm.desafioitau.service.validacoes.Validacao;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
public class ValidaDataHoraPosteriorImpl implements Validacao {

    @Override
    public void validar(TransacaoRequest request) {
        boolean dataFutura = request.dataHora().isAfter(OffsetDateTime.now());

        if(dataFutura){
            throw new DataHoraFuturoException("Não é permitido campo de data e hora futuros!");
        }
    }
}
