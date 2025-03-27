package com.samuelm.desafioitau.service.validacoes;

import com.samuelm.desafioitau.dto.TransacaoRequest;

public interface Validacao {

    void validar(TransacaoRequest request);
}
