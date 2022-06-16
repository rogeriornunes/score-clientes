package br.com.gerenciamento.scoreclientes.application.convert;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.gerenciamento.scoreclientes.application.dto.ScoreDTO;
import br.com.gerenciamento.scoreclientes.entities.Score;

@Controller
public class ScoreConvert {

	@Autowired
	private ModelMapper modelMapper;
	
	public ScoreDTO convertToDto(Score score) {
		ScoreDTO scoreDTO = modelMapper.map(score, ScoreDTO.class);
	    return scoreDTO;
	}
	
	public Score convertToEntity(ScoreDTO scoreDTO) {
		Score score = modelMapper.map(scoreDTO, Score.class);
	    return score;
	}
}
