package br.com.gerenciamento.scoreclientes.application.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gerenciamento.scoreclientes.application.convert.ScoreConvert;
import br.com.gerenciamento.scoreclientes.application.dto.ScoreDTO;
import br.com.gerenciamento.scoreclientes.services.ScoreService;

@RestController
@RequestMapping(path = "/v1/api/")
public class ScoreController {
	
	@Autowired
	private ScoreConvert scoreConvert;

	@Autowired
	private ScoreService scoreService;

	//@ApiOperation(value = "Cadastra um score") 
	@PostMapping(path = "/score")
	public ResponseEntity<HttpStatus> cadastrarScore(@Valid @RequestBody ScoreDTO scoreDTO) {
		scoreService.cadastrarScore(scoreConvert.convertToEntity(scoreDTO));
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
