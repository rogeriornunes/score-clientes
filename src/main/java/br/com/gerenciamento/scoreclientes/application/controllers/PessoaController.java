package br.com.gerenciamento.scoreclientes.application.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.gerenciamento.scoreclientes.application.convert.PessoaConvert;
import br.com.gerenciamento.scoreclientes.application.dto.PessoaDTO;
import br.com.gerenciamento.scoreclientes.entities.Pessoa;
import br.com.gerenciamento.scoreclientes.services.PessoaService;

@RestController
@RequestMapping(path = "/v1/api")
public class PessoaController {
	
	@Autowired
	private PessoaConvert pessoaConvert;

	@Autowired
	private PessoaService pessoaService;

	//@ApiOperation(value = "Cadastra uma nova afinidade") 
	@PostMapping(path = "/pessoa")
	public ResponseEntity<HttpStatus> cadastrarAfinidade(@Valid @RequestBody PessoaDTO pessoaDTO) {
		pessoaService.cadastrarPessoa(pessoaConvert.convertToEntity(pessoaDTO));
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping(path = "pessoa/{id}")
	// @ApiOperation(value = "Busca uma pessoa por ID")
	public ResponseEntity<PessoaDTO> buscarPessoaPorID(@PathVariable("id") Integer id) {
		ResponseEntity<PessoaDTO> response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		Pessoa pessoa = pessoaService.buscarPessoaPorID(id);
		if (pessoa != null) {
			response = ResponseEntity.ok(pessoaConvert.convertToDto(pessoa));
		}
		return response;
	}
}
