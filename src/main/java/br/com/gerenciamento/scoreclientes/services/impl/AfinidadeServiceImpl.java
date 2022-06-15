package br.com.gerenciamento.scoreclientes.services.impl;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciamento.scoreclientes.entities.Afinidade;
import br.com.gerenciamento.scoreclientes.insfrastructure.repositories.AfinidadeRepository;
import br.com.gerenciamento.scoreclientes.services.AfinidadeService;
import br.com.gerenciamento.scoreclientes.services.JWTService;


@Service
public class AfinidadeServiceImpl implements AfinidadeService {

	@Autowired
	private AfinidadeRepository afinidadeRepository;
	
	@Autowired
	private JWTService jwtService;

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
}
