package br.com.gerenciamento.scoreclientes.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gerenciamento.scoreclientes.application.convert.AfinidadeConvert;
import br.com.gerenciamento.scoreclientes.application.dto.AfinidadeDTO;
import br.com.gerenciamento.scoreclientes.services.AfinidadeService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/v1/api")
public class AfinidadeController {
	
	@Autowired
	private AfinidadeConvert afinidadeConvert;

	@Autowired
	private AfinidadeService afinidadeService;

	@ApiOperation(value = "Cadastra uma nova afinidade") 
	@PostMapping(path = "/afinidade")
	public ResponseEntity<HttpStatus> cadastrarAfinidade(@RequestBody AfinidadeDTO afinidadeDTO, 
					@RequestHeader("Authorization") String header) {
		afinidadeService.cadastrarAfinidade(afinidadeConvert.convertToEntity(afinidadeDTO));
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
