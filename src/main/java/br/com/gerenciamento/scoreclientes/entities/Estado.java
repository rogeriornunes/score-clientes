package br.com.gerenciamento.scoreclientes.entities;

import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;

@Data
public class Estado {

	private String estado;
	
	public Estado(String estado) {
		this.estado = estado;
	}
	
	public Estado() {
	}

	public List<Estado> retornaEstados(List<Afinidade> listaAfinidade) {
		List<Estado> lista = listaAfinidade.stream()
						.map(afinidade -> new Estado(afinidade.getEstado()))
						.collect(Collectors.toList());
		return lista;
	}
}
