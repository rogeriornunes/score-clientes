package br.com.gerenciamento.scoreclientes.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import br.com.gerenciamento.scoreclientes.entities.Pessoa;
import br.com.gerenciamento.scoreclientes.insfrastructure.repositories.PessoaRepository;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class PessoaServiceImplTest {
 
	    @Mock
	    private PessoaRepository pessoaRepository;

	@Test
	void buscarPessoaPorIdTest() {

		Pessoa pessoa = new Pessoa();
		pessoa = getPessoa();

		when(pessoaRepository.findById(pessoa.getId())).thenReturn(Optional.of(pessoa));
		assertThat(pessoa.getNome(), is(equalTo(pessoa.getNome())));
	}

	private Pessoa getPessoa() {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(1);
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
