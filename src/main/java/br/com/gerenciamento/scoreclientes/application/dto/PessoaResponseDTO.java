package br.com.gerenciamento.scoreclientes.application.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.gerenciamento.scoreclientes.entities.Estado;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaResponseDTO {

	private String nome;

	@JsonFormat(pattern = "XX XXXXX-XXXX")
	private String telefone;

	private Integer idade;

	private String scoreDescricao;

	private List<Estado> estados;

	public PessoaResponseDTO() {
	}

	public PessoaResponseDTO(List<Estado> estados) {
		this.estados = estados;
	}
}
