package com.lucasbarreto.transacao_api.services;

import java.util.DoubleSummaryStatistics;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasbarreto.transacao_api.dtos.EstatisticasDTO;
import com.lucasbarreto.transacao_api.dtos.TransacaoDTO;

@Service
public class EstatisticasService {
	
	@Autowired
	private TransacaoService transacaoService;
	
	
	public EstatisticasDTO calcularEstatisticasTransacoes(int intervaloBusca) {
		
		List<TransacaoDTO> transacoes = transacaoService.buscarTransacoes(intervaloBusca);
		
		DoubleSummaryStatistics estatisticas = transacoes.stream().mapToDouble(TransacaoDTO::valor).summaryStatistics();
		
		return new EstatisticasDTO(estatisticas.getCount(), estatisticas.getSum(), estatisticas.getAverage(), estatisticas.getMin(), estatisticas.getMax());
	}

}
