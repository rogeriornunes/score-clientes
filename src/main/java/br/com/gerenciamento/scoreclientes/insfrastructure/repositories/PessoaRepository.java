package br.com.gerenciamento.scoreclientes.insfrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gerenciamento.scoreclientes.entities.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Object> {
	
	//@Query(value = "SELECT * FROM AFINIDADE WHERE REGIAO = :regiao AND ESTADO = :estado", nativeQuery = true)
	//Optional<Afinidade> findByRegiaoEstado(@Param("regiao") String regiao, @Param("estado") String estado);

}
