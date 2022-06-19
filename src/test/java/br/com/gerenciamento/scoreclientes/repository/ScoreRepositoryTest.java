package br.com.gerenciamento.scoreclientes.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.gerenciamento.scoreclientes.entities.Score;
import br.com.gerenciamento.scoreclientes.enums.ScoreFinal;
import br.com.gerenciamento.scoreclientes.enums.ScoreInicial;
import br.com.gerenciamento.scoreclientes.insfrastructure.repositories.ScoreRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ScoreRepositoryTest {

	@Autowired
	private ScoreRepository scoreRepository;

	@Test
	public void insertScore() {
		Score score = new Score("Insuficiente", ScoreInicial.INSUFICIENTE.getInicioScore(),
						ScoreFinal.INSUFICIENTE.getFinalScore());
		scoreRepository.save(score);
		List<Score> listScore = scoreRepository.findAll();
		assertTrue(listScore.size() == 1);
	}
}
