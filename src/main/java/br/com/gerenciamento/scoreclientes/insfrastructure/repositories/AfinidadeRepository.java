package br.com.gerenciamento.scoreclientes.insfrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.gerenciamento.scoreclientes.entities.Afinidade;

@Repository
public interface AfinidadeRepository extends JpaRepository<Afinidade, Object> {
	
	@Query(value = "SELECT * FROM AFINIDADE WHERE REGIAO = :regiao AND ESTADO = :estado", nativeQuery = true)
	Optional<Afinidade> findByRegiaoEstado(@Param("regiao") String regiao, @Param("estado") String estado);

}
