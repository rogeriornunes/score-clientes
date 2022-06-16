package br.com.gerenciamento.scoreclientes.enums;

import lombok.Getter;

@Getter
public enum ScoreFinal {

	INSUFICIENTE(200L), INACEITAVEL(500L), ACEITAVEL(700L), RECOMENDAVEL(1000L);

	public Long finalScore;

	ScoreFinal(Long valor) {
		finalScore = valor;
	}
}
