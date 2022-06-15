package br.com.gerenciamento.scoreclientes.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "PESSOA")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PESSOA")
	private Integer id;
	
	@Column(name = "DATA_INCLUSAO")
	private Date dataInclusao;
	
	@Column()
	private String nome;
	
	@Column
	private String telefone; 
	
	@Column()
	private Integer idade;
	
	@Column()
	private String cidade;
	
	@Column()
	private String estado;
	
	@Column()
	private String regiao;
}
