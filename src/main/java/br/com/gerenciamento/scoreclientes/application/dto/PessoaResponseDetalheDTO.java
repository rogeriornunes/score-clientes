package br.com.gerenciamento.scoreclientes.application.dto;

import java.util.List;

import br.com.gerenciamento.scoreclientes.entities.Estado;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaResponseDetalheDTO {

	private String nome;

	private String cidade;

	private String estado;

	private String scoreDescricao;

	private List<Estado> estados;

	public PessoaResponseDetalheDTO() {
	}
	
	public PessoaResponseDetalheDTO(String nome, String cidade, String estado,
					String scoreDescricao, List<Estado> estados) {
		this.nome = nome;
		this.cidade = cidade;
		this.estado = estado;
		this.scoreDescricao = scoreDescricao;
		this.estados = estados;
	}
}
