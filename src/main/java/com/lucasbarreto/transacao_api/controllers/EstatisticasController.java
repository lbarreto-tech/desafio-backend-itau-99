package com.lucasbarreto.transacao_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lucasbarreto.transacao_api.dtos.EstatisticasDTO;
import com.lucasbarreto.transacao_api.services.EstatisticasService;

@RestController
@RequestMapping("/estatistica")
public class EstatisticasController {
	
	@Autowired
	private EstatisticasService estatisticasService;
	
	
	public ResponseEntity<EstatisticasDTO> buscarEstatisticas(@RequestParam(value = "intervaloBusca", required = false, defaultValue = "60") int intervaloBusca){
		return ResponseEntity.ok(estatisticasService.calcularEstatisticasTransacoes(intervaloBusca));
	} 

}
