package br.com.gerenciamento.scoreclientes.insfrastructure.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.gerenciamento.scoreclientes.entities.Score;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Object> {
	
	@Query(value = "SELECT * FROM SCORE WHERE DESCRICAO = :descricao", nativeQuery = true)
	Optional<Score> findByScoreDescricao(@Param("descricao") String descricao);

	@Query(value = "SELECT * FROM SCORE", nativeQuery = true)
	List<Score> listaScores();
}
