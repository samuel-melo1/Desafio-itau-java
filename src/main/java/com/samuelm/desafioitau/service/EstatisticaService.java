package com.samuelm.desafioitau.service;

import com.samuelm.desafioitau.domain.Transacao;
import com.samuelm.desafioitau.dto.EstatisticaResponse;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
public class EstatisticaService {

    private final TransacaoService transacaoService;

    public EstatisticaService(TransacaoService transacaoService){
        this.transacaoService = transacaoService;
    }
    public EstatisticaResponse obterMetricas(){
        OffsetDateTime ultimas60Segundos = OffsetDateTime.now().minusSeconds(60);
        List<Transacao> transacoesFiltradas = transacaoService.getTransacoes().stream()
                .filter(v -> v.getDataHora().isAfter(ultimas60Segundos)).toList();

        DoubleSummaryStatistics estatisticas = transacoesFiltradas.stream()
                .mapToDouble(Transacao::getValor).summaryStatistics();

        double min = estatisticas.getCount() > 0 ? estatisticas.getMin(): 0.0;
        double max = estatisticas.getCount() > 0 ? estatisticas.getMax(): 0.0;

        return new EstatisticaResponse(
                estatisticas.getCount(),
                estatisticas.getSum(),
                estatisticas.getAverage(),
                min,
                max
        );
    }
}
