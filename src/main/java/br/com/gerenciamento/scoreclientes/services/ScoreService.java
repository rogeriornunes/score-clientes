package br.com.gerenciamento.scoreclientes.services;

import java.util.List;

import br.com.gerenciamento.scoreclientes.entities.Score;

public interface ScoreService {
	
	void  cadastrarScore(Score score);

	List<Score> listaScores();
	
	String getTipoDescricaoScore (Long score);
}
