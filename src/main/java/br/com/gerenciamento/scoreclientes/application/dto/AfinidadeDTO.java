package br.com.gerenciamento.scoreclientes.application.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AfinidadeDTO {
	
	private String regiao;
	
	@JsonIgnore
	private String estado;
	
	private List<String> estados;
	
	public AfinidadeDTO() {
	}
	
	public AfinidadeDTO(String estado) {
		this.estado = estado;
	}
}
