package com.samuelm.desafioitau.service;

import com.samuelm.desafioitau.dto.TransacaoRequest;
import com.samuelm.desafioitau.domain.Transacao;
import com.samuelm.desafioitau.service.validacoes.Validacao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransacaoService {

    private List<Transacao> transacoes = new ArrayList<>();
    private final List<Validacao> validacoes;

    public TransacaoService(List<Validacao> validacoes){
        this.validacoes = validacoes;
    }
    public void salvar(TransacaoRequest request){
        validacoes.forEach(v -> v.validar(request));
        transacoes.add(new Transacao(request.valor(), request.dataHora()));
    }
    public void deletar(){
        validacoes.clear();
    }
    public List<Transacao> getTransacoes() {
        return transacoes;
    }


}
