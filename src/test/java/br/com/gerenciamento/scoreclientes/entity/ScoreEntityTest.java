package br.com.gerenciamento.scoreclientes.entity;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.com.gerenciamento.scoreclientes.entities.Score;
import br.com.gerenciamento.scoreclientes.enums.ScoreFinal;
import br.com.gerenciamento.scoreclientes.enums.ScoreInicial;

public class ScoreEntityTest {

	@Test
	public void scoreTest() {
		Score score = new Score("Insuficiente", ScoreInicial.INSUFICIENTE.getInicioScore(),
						ScoreFinal.INSUFICIENTE.getFinalScore());
		assertEquals("Insuficiente", score.getDescricao());
		assertTrue(score.toString().contains("Score ["));
	}
}
