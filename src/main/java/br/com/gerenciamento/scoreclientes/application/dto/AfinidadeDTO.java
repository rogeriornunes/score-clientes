package br.com.gerenciamento.scoreclientes.application.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AfinidadeDTO {
	
	private String regiao;
	
	private List<String> estados;
}
