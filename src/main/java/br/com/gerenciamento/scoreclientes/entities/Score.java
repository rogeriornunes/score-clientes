package br.com.gerenciamento.scoreclientes.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "SCORE")
public class Score {

	@Column()
	private String descricao;

	@Column(name = "INICIAL")
	private BigDecimal ScoreInicial;

	@Column(name = "FINAL")
	private BigDecimal ScoreFinal;
}
