package br.com.gerenciamento.scoreclientes.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciamento.scoreclientes.entities.Pessoa;
import br.com.gerenciamento.scoreclientes.insfrastructure.repositories.PessoaRepository;
import br.com.gerenciamento.scoreclientes.services.JWTService;
import br.com.gerenciamento.scoreclientes.services.PessoaService;


@Service
public class PessoaServiceImpl implements PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private JWTService jwtService;

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
	public Pessoa buscarPessoaPorID(Integer id) {
		Pessoa pessoa = null;
		Optional<Pessoa> optPessoa = pessoaRepository.findById(id);
		if (optPessoa.isPresent()) {
			pessoa = optPessoa.get();
		}
		return pessoa;
	}
}
