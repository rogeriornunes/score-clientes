package br.com.gerenciamento.scoreclientes.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "SCORE")
public class Score {

	@Id
	@Column()
	private String descricao;

	@Column(name = "INICIAL")
	private Long scoreInicial;

	@Column(name = "FINAL")
	private Long scoreFinal;
	
	public Score() {
		super();
	}

	public Score(String descricao, Long scoreInicial, Long scoreFinal) {
		this.descricao = descricao;
		this.scoreInicial = scoreInicial;
		this.scoreFinal = scoreFinal;
	}
	
}
