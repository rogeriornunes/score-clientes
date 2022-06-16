package br.com.gerenciamento.scoreclientes.enums;

import lombok.Getter;

@Getter
public enum ScoreInicial {

	INSUFICIENTE(0L), INACEITAVEL(201L), ACEITAVEL(501L), RECOMENDAVEL(701L);

	public Long inicioScore;

	ScoreInicial(Long valor) {
		inicioScore = valor;
	}
}
