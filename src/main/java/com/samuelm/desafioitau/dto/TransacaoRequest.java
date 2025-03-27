package com.samuelm.desafioitau.dto;

import java.time.OffsetDateTime;

public record TransacaoRequest(Double valor, OffsetDateTime dataHora) {}
