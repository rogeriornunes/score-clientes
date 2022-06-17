package br.com.gerenciamento.scoreclientes.services;

import java.util.List;

import br.com.gerenciamento.scoreclientes.entities.Afinidade;

public interface AfinidadeService {
	
	void  cadastrarAfinidade(Afinidade afinidade);

	List<Afinidade> buscarAfinidadeRegiaoDaPessoa(String regiao);
}
