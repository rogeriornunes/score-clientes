package br.com.gerenciamento.scoreclientes.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.gerenciamento.scoreclientes.entities.Afinidade;
import br.com.gerenciamento.scoreclientes.insfrastructure.repositories.AfinidadeRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class AfinidadeRepositoryTest {

	@Autowired
	private AfinidadeRepository afinidadeRepository;

	@Test
	public void insertAfinidade() {	
		afinidadeRepository.save(getAfinidade());
		List<Afinidade> listAfinidade = afinidadeRepository.findAll();
		assertTrue(!listAfinidade.isEmpty());
	}
	
	private Afinidade getAfinidade() {
		Afinidade afinidade = new Afinidade();
		afinidade.setRegiao("centro-oeste");
		afinidade.setEstado("GO");
		return afinidade;
	}
}
