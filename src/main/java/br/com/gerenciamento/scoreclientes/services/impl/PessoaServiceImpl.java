package br.com.gerenciamento.scoreclientes.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciamento.scoreclientes.application.convert.PessoaConvert;
import br.com.gerenciamento.scoreclientes.application.dto.PessoaResponseDTO;
import br.com.gerenciamento.scoreclientes.application.dto.PessoaResponseDetalheDTO;
import br.com.gerenciamento.scoreclientes.entities.Afinidade;
import br.com.gerenciamento.scoreclientes.entities.Estado;
import br.com.gerenciamento.scoreclientes.entities.Pessoa;
import br.com.gerenciamento.scoreclientes.entities.Score;
import br.com.gerenciamento.scoreclientes.insfrastructure.repositories.PessoaRepository;
import br.com.gerenciamento.scoreclientes.services.AfinidadeService;
import br.com.gerenciamento.scoreclientes.services.PessoaService;
import br.com.gerenciamento.scoreclientes.services.ScoreService;


@Service
public class PessoaServiceImpl implements PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private PessoaConvert pessoaConvert;
	
	@Autowired
	private AfinidadeService afinidadeService;
	
	@Autowired
	private ScoreService scoreService;

	@Override
	public void cadastrarPessoa(Pessoa pessoa) {
		try {
			pessoa.setDataInclusao(pessoa.adicionarDataInclusao());
			pessoaRepository.save(pessoa);
		} catch (Exception e) {
			throw new RuntimeException("Falha ao salvar pessoa: " + e.getMessage());
		}	
	}

	@Override
	public PessoaResponseDTO buscarPessoaPorID(Integer id) {
		Pessoa pessoa = null;
		PessoaResponseDTO pessoaDTO = null;

		Optional<Pessoa> optPessoa = pessoaRepository.findById(id);
		if (optPessoa.isPresent()) {
			pessoa = optPessoa.get();
			List<Estado> listaEstados = getAfinidadeRegiao(pessoa.getRegiao());
			String scoreDescricao = getDescricaoScore(pessoa);
			pessoaDTO = pessoaConvert.convertResponseToDto(pessoa);
			pessoaDTO.setEstados(listaEstados);
			pessoaDTO.setScoreDescricao(scoreDescricao);
		}
		return pessoaDTO;
	}
	
	private List<Estado> getAfinidadeRegiao(String regiao){
		Estado estado = new Estado();
		List<Afinidade> listaAfinidade = afinidadeService.buscarAfinidadeRegiaoDaPessoa(regiao);
		List<Estado> listaEstados = estado.retornaEstados(listaAfinidade);
		return listaEstados;
	}
	
	private String getDescricaoScore(Pessoa pessoa) {
		String scoreDescricao = scoreService.getTipoDescricaoScore(pessoa.getScore());
		List<Score> listaScore = scoreService.listaScores();
		boolean isScoreCorreto = listaScore.stream().anyMatch(score -> score.getDescricao().equals(scoreDescricao));
		return isScoreCorreto == true ? scoreDescricao : "";
	}

	@Override
	public List<PessoaResponseDetalheDTO> listaPessoas() {
		List<Pessoa> listaPessoas = pessoaRepository.findAll();
		List<PessoaResponseDetalheDTO> listaPessoaDTO = listaPessoas.stream()
						.map(pessoa -> new PessoaResponseDetalheDTO(pessoa.getNome(),
										pessoa.getCidade(), pessoa.getEstado(),
										getDescricaoScore(pessoa),
										getAfinidadeRegiao(pessoa.getRegiao())))
						.collect(Collectors.toList());
		return listaPessoaDTO;
	}
}
