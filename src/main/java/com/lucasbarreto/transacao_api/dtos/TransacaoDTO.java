package com.lucasbarreto.transacao_api.dtos;

import java.time.OffsetDateTime;

public record TransacaoDTO(Double valor, OffsetDateTime dataHora) {

}
