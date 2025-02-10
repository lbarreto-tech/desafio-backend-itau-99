package com.lucasbarreto.transacao_api.services;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasbarreto.transacao_api.dtos.TransacaoDTO;

@Service
public class TransacaoService {
	
	@Autowired
	private List<TransacaoDTO> listaTransacoes = new ArrayList<>(); 
	
	
	public void adicionarTransacoes(TransacaoDTO dto) {
		
		if(dto.dataHora().isAfter(OffsetDateTime.now())) {
			throw new com.lucasbarreto.transacao_api.exceptions.UnprocessableEntity("Data e hora maiores que a atual");
		}
		
		if(dto.valor() < 0) {
			throw new com.lucasbarreto.transacao_api.exceptions.UnprocessableEntity("Valor não pode ser menor que 0");
		}
		
		listaTransacoes.add(dto);
	}
	
	public void limparTransacoes() {
		listaTransacoes.clear();
	}
	
	public List<TransacaoDTO> buscarTransacoes(int intervaloBusca) {
		
		OffsetDateTime dataHoraIntervalo = OffsetDateTime.now().minusSeconds(intervaloBusca);
		
		return listaTransacoes.stream()
				.filter(transacao -> transacao.dataHora().isAfter(dataHoraIntervalo)).toList();
	}

}
