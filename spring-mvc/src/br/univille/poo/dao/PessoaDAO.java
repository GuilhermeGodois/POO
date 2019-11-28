package br.univille.poo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.univille.poo.mvc.model.PessoaModel;

/**
 * Pessoa Data Acess Object
 * 
 *
 */
public class PessoaDAO extends BasicoDAO{
	

	/**
	 * Inserir uma nova pessoa
	 * @param pessoa
	 */
	public void insert(PessoaModel pessoa) {

		String sql = " insert into pessoa(nome, cpf, email) values(?,?,?)";
		
		try (Connection conn = getConnection();
			 PreparedStatement statement = conn.prepareStatement(sql,
                     Statement.RETURN_GENERATED_KEYS)){

			statement.setString(1, pessoa.getNome());
			statement.setString(2, pessoa.getCpf());
			statement.setString(3, pessoa.getEmail());
			statement.execute();
			
			 try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	            	pessoa.setId(generatedKeys.getLong(1));
	            }
	            else {
	                throw new SQLException("Creating user failed, no ID obtained.");
	            }
	        }
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Deletar uma pessoa pelo id
	 * @param pessoa
	 */
	public void delete(PessoaModel pessoa) {
		
		String sql = " delete from pessoa where id = ?";
		
		try(Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setLong(1, pessoa.getId());
			statement.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Atualizar uma pessoa pelo id
	 * @param pessoa
	 */
	public void update(PessoaModel pessoa) {
		String sql = " update pessoa set nome = ?, cpf = ?, email = ? where id = ?";
		
		try (Connection conn = getConnection();
			 PreparedStatement statement = conn.prepareStatement(sql)){
			statement.setLong(4, pessoa.getId());
			statement.setString(1, pessoa.getNome());
			statement.setString(2, pessoa.getCpf());
			statement.setString(3, pessoa.getEmail());
			statement.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Obter uma pessoa pelo id
	 * @param id
	 * @return
	 */
	public PessoaModel getById(int id) {
		PessoaModel pessoa = null;
		String sql = " select id, nome, cpf, email from pessoa where id = ?";
		
		try(Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				pessoa = new PessoaModel();
				pessoa.setId(resultSet.getLong(1));
				pessoa.setNome(resultSet.getString(2));
				pessoa.setCpf(resultSet.getString(3));
				pessoa.setEmail(resultSet.getString(4));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return pessoa;
	}
	
	/**
	 * Obter todas as pessoas da tabel
	 * @return
	 */
	public List<PessoaModel> getAll(){
		List<PessoaModel> list = new ArrayList<>();
		String sql = " select id, nome, cpf, email from pessoa order by nome";
		
		try(Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				PessoaModel pessoa = new PessoaModel();
				pessoa.setId(resultSet.getLong(1));
				pessoa.setNome(resultSet.getString(2));
				pessoa.setCpf(resultSet.getString(3));
				pessoa.setEmail(resultSet.getString(4));
				list.add(pessoa);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}