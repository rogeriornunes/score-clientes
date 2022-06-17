package br.com.gerenciamento.scoreclientes.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaDTO {
	
	private String nome;
	
	@JsonFormat(pattern = "XX XXXXX-XXXX")
	private String telefone; 
	
	private Integer idade;
	
	private String cidade;

	private String estado;
	
	private Long score;
	
	private String regiao;
	
}
