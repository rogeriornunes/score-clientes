package br.com.gerenciamento.scoreclientes.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciamento.scoreclientes.entities.Score;
import br.com.gerenciamento.scoreclientes.enums.ScoreEnum;
import br.com.gerenciamento.scoreclientes.enums.ScoreFinal;
import br.com.gerenciamento.scoreclientes.enums.ScoreInicial;
import br.com.gerenciamento.scoreclientes.insfrastructure.repositories.ScoreRepository;
import br.com.gerenciamento.scoreclientes.services.JWTService;
import br.com.gerenciamento.scoreclientes.services.ScoreService;

@Service
public class ScoreServiceImpl implements ScoreService {

	@Autowired
	private ScoreRepository scoreRepository;

	@Autowired
	private JWTService jwtService;

	@Override
	public void cadastrarScore(Score score) {
		try {
			if (validarIntervalo(score)) {
				scoreRepository.save(score);
			} else {
				throw new RuntimeException("Score com pontuação inicial e final informado incorretamente.");
			}
		} catch (Exception e) {
			throw new RuntimeException("Falha ao salvar score: " + e.getMessage());
		}
	}

	@Override
	public List<Score> listaScores() {
		List<Score> listaScores =  scoreRepository.listaScores();	
		return  scoreRepository.listaScores();
	}
	
	@Override
	public String getTipoDescricaoScore(Long score) {
		String scoreDescricao = null;
		if (ScoreInicial.INACEITAVEL.getInicioScore() <= score
						&& ScoreFinal.INSUFICIENTE.getFinalScore() >= score) {
			return scoreDescricao = ScoreEnum.INSUFICIENTE.getScoreDescricao();
		} else if (ScoreInicial.INACEITAVEL.getInicioScore() <= score
						&& ScoreFinal.INACEITAVEL.getFinalScore() >= score) {
			return scoreDescricao = ScoreEnum.INACEITAVEL.getScoreDescricao();
		} else if (ScoreInicial.ACEITAVEL.getInicioScore() <= score
						&& ScoreFinal.ACEITAVEL.getFinalScore() >= score) {
			return scoreDescricao = ScoreEnum.ACEITAVEL.getScoreDescricao();
		} else if (ScoreInicial.RECOMENDAVEL.getInicioScore() <= score
						&& ScoreFinal.RECOMENDAVEL.getFinalScore() >= score) {
			return scoreDescricao = ScoreEnum.RECOMENDAVEL.getScoreDescricao();
		}
		return scoreDescricao;
	}
	
	private boolean validarIntervalo(Score score) {
		if (ScoreEnum.INSUFICIENTE.getScoreDescricao().equals(score.getDescricao())
						&& score.getScoreInicial() >= ScoreInicial.INSUFICIENTE.getInicioScore()
						&& score.getScoreFinal() <= ScoreFinal.INSUFICIENTE.getFinalScore()) {
			return true;
		} else if (ScoreEnum.INACEITAVEL.getScoreDescricao().equals(score.getDescricao())
						&& score.getScoreInicial() >= ScoreInicial.INACEITAVEL.getInicioScore()
						&& score.getScoreFinal() <= ScoreFinal.INACEITAVEL.getFinalScore()) {
			return true;
		} else if (ScoreEnum.ACEITAVEL.getScoreDescricao().equals(score.getDescricao())
						&& score.getScoreInicial() >= ScoreInicial.ACEITAVEL.getInicioScore()
						&& score.getScoreFinal() >= ScoreFinal.ACEITAVEL.getFinalScore()) {
			return true;
		} else if (ScoreEnum.RECOMENDAVEL.getScoreDescricao().equals(score.getDescricao())
						&& score.getScoreInicial() >= ScoreInicial.RECOMENDAVEL.getInicioScore()
						&& score.getScoreFinal() >= ScoreFinal.RECOMENDAVEL.getFinalScore()) {
			return true;
		}
		return false;
	}
}
