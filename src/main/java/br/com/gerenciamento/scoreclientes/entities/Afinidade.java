package br.com.gerenciamento.scoreclientes.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "AFINIDADE")
public class Afinidade {

	@Column()
	private String regiao;
	
	private List<String> estados;
}
