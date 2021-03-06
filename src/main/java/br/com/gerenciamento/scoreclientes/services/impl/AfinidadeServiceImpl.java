package br.com.gerenciamento.scoreclientes.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciamento.scoreclientes.entities.Afinidade;
import br.com.gerenciamento.scoreclientes.insfrastructure.repositories.AfinidadeRepository;
import br.com.gerenciamento.scoreclientes.services.AfinidadeService;


@Service
public class AfinidadeServiceImpl implements AfinidadeService {

	@Autowired
	private AfinidadeRepository afinidadeRepository;

	@Override
	public void cadastrarAfinidade(Afinidade afinidade) {
		try {
			salvarAfinidade(afinidade);
		} catch (Exception e) {
			throw new RuntimeException("Falha ao cadastrar afinidade: " + e.getMessage());
		}
	}

	private void salvarAfinidade(Afinidade afinidade) {
		afinidade.getEstados().forEach(estado -> {
			Afinidade afinidadeCadastrar = new Afinidade();
			afinidadeCadastrar.setRegiao(afinidade.getRegiao());
			afinidadeCadastrar.setEstado(estado);
			if (!afinidadeRepository
							.findByRegiaoEstado(afinidade.getRegiao(), estado)
							.isPresent()) {
				afinidadeRepository.save(afinidadeCadastrar);
			}
		});
	}

	@Override
	public List<Afinidade> buscarAfinidadeRegiaoDaPessoa(String regiao) {
		 return afinidadeRepository.listaEstadosPorRegiao(regiao);
	}
}
