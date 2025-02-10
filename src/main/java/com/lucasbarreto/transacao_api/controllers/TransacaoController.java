package com.lucasbarreto.transacao_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucasbarreto.transacao_api.dtos.TransacaoDTO;
import com.lucasbarreto.transacao_api.services.TransacaoService;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {
	
	@Autowired
	private TransacaoService transacaoService;
	
	
	@PostMapping
	public ResponseEntity<Void> adicionarTransacao(@RequestBody TransacaoDTO dto){
		transacaoService.adicionarTransacoes(dto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deletarTransacoes(){
		transacaoService.limparTransacoes();
		return ResponseEntity.ok().build();
	}

}
