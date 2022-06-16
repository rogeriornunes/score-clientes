package br.com.gerenciamento.scoreclientes.enums;

import lombok.Getter;

@Getter
public enum ScoreEnum {

	INSUFICIENTE("Insuficiente"), INACEITAVEL("Inaceitável"), ACEITAVEL("Aceitável"), RECOMENDAVEL("Recomendável");

	public String scoreDescricao;

	ScoreEnum(String valor) {
		scoreDescricao = valor;
	}
}
