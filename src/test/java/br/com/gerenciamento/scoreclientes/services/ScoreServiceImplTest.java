package br.com.gerenciamento.scoreclientes.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import br.com.gerenciamento.scoreclientes.entities.Score;
import br.com.gerenciamento.scoreclientes.enums.ScoreFinal;
import br.com.gerenciamento.scoreclientes.enums.ScoreInicial;
import br.com.gerenciamento.scoreclientes.insfrastructure.repositories.ScoreRepository;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ScoreServiceImplTest {
 
	    @Mock
	    private ScoreRepository scoreRepository;

	@Test
	void listaScoresTest() {

		Score score = new Score("Insuficiente", ScoreInicial.INSUFICIENTE.getInicioScore(),
						ScoreFinal.INSUFICIENTE.getFinalScore());
		List<Score> list = new ArrayList();
		list.add(score);

		when(scoreRepository.listaScores()).thenReturn(list);
		assertThat(list, is(not(empty())));
	}
}
