package br.com.gerenciamento.scoreclientes.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.gerenciamento.scoreclientes.entities.Pessoa;
import br.com.gerenciamento.scoreclientes.insfrastructure.repositories.PessoaRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class PessoaRepositoryTest {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Test
	public void insertPessoa() {
	
	pessoaRepository.save(getPessoa());
		List<Pessoa> listaPessoa = pessoaRepository.findAll();
		assertTrue(!listaPessoa.isEmpty());
	}
	
	private Pessoa getPessoa() {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Teste João");
		pessoa.setCidade("Goiania");
		pessoa.setIdade(34);
		pessoa.setRegiao("centro-oeste");
		pessoa.setScore(500L);
		pessoa.setTelefone("62 99999-9999");
		pessoa.setDataInclusao(pessoa.adicionarDataInclusao());
		return pessoa;
	}
}
