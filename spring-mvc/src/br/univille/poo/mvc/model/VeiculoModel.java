package br.univille.poo.mvc.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.univille.poo.dao.VeiculoDAO;
import br.univille.poo.mvc.util.Observer;
import br.univille.poo.mvc.util.Subject;

public class VeiculoModel implements  Subject{
	
	private long id;
	private String nome;
	private String marca;
	private String placa;
	private List<Observer> list;
	
	public VeiculoModel() {
		list = new ArrayList<Observer>();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String cpf) {
		this.marca = cpf;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String email) {
		this.placa = email;
	}
	
	
	public void novoRegistro() {
		id = 0;
		nome = "";
		marca = "";
		placa = "";
		notifyObservers();
	}
	
	@Override
	public String toString() {
		return "PessoaModel [id=" + id + ", nome=" + nome + ", marca=" + marca + ", placa=" + placa + "]";
	}
	
	
	@Override
	public void attach(Observer o) {
		list.add(o);
	}

	@Override
	public void detach(Observer o) {
		list.remove(o);
	}

	@Override
	public void notifyObservers() {
		// Avisa cada um dos observadores
		for(Observer o : list) {
			// Atualiza a informacao no observador
			o.update(this, this);
		}
	}

	public void salvar() throws Exception {
		
		if(marca == null || marca.isEmpty()) {
			throw new Exception("CPF é inválido");
		}
		if(nome == null || nome.isEmpty()) {
			throw new Exception("Nome é inválido");
		}
		if(placa == null || placa.isEmpty()) {
			throw new Exception("Email é inválido");
		}
		//Novo registro
		if(id == 0) {
			VeiculoDAO dao = new VeiculoDAO();
			dao.insert(this);
			
		}else {
			// Atualizar no banco de dados
		}
		notifyObservers();
	}
	
	public void deletar() {
		//deletar no banco de dados
		novoRegistro();
		notifyObservers();
	}
	
	

}
