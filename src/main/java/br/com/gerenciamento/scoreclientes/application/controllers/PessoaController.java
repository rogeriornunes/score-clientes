package br.com.gerenciamento.scoreclientes.application.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gerenciamento.scoreclientes.application.convert.PessoaConvert;
import br.com.gerenciamento.scoreclientes.application.dto.PessoaRequestDTO;
import br.com.gerenciamento.scoreclientes.application.dto.PessoaResponseDTO;
import br.com.gerenciamento.scoreclientes.application.dto.PessoaResponseDetalheDTO;
import br.com.gerenciamento.scoreclientes.services.PessoaService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/v1/api")
public class PessoaController {
	
	@Autowired
	private PessoaConvert pessoaConvert;

	@Autowired
	private PessoaService pessoaService;

	@ApiOperation(value = "Cadastra uma nova pessoa") 
	@PostMapping(path = "/pessoa")
	public ResponseEntity<HttpStatus> cadastrarPessoa(@Valid @RequestBody PessoaRequestDTO pessoaDTO) {
		pessoaService.cadastrarPessoa(pessoaConvert.convertToEntity(pessoaDTO));
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping(path = "pessoa/{id}")
	 @ApiOperation(value = "Busca uma pessoa por ID")
	public ResponseEntity<PessoaResponseDTO> buscarPessoaPorID(@PathVariable("id") Integer id) {
		ResponseEntity<PessoaResponseDTO> response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		PessoaResponseDTO pessoaDTO = pessoaService.buscarPessoaPorID(id);
		if (pessoaDTO != null) {
			response = ResponseEntity.ok(pessoaDTO);
		}
		return response;
	}
	
	@ApiOperation(value = "Lista todos pessoas") 
	@GetMapping(path = "/pessoa")
	public ResponseEntity<List<PessoaResponseDetalheDTO>> listaClientes() {
		ResponseEntity<List<PessoaResponseDetalheDTO>> response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		List<PessoaResponseDetalheDTO> listPessoaDTO = pessoaService.listaPessoas();
		
		if (!listPessoaDTO.isEmpty()) {
			response = ResponseEntity.ok(listPessoaDTO);
		}
		return response;
	}
}
