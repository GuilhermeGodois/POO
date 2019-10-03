package THINGSTODO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Pessoa Data Acess Object
 * @author leandersonandre
 *
 */
public class DAO extends basicDAO{
	


	public void insert(Things things) {

		String sql = " insert into things(Nome, Descricao) values(?,?)";
		
		try (Connection conn = getConnection();
			 PreparedStatement statement = conn.prepareStatement(sql)){
			statement.setString(1, things.getNome());
			statement.setString(2, things.getDescricao());
			statement.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Deletar uma pessoa pelo id
	 * @param pessoa
	 */
	public void delete(Things things) {
		
		String sql = " delete from things where id = ?";
		
		try(Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setInt(1, things.getId());
			statement.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Atualizar um item na lista pelo id
	 * @param things
	 */
	public void update(Things things) {
		String sql = " update Things set Nome = ?, Descricao = ? where id = ?";
		
		try (Connection conn = getConnection();
			 PreparedStatement statement = conn.prepareStatement(sql)){
			statement.setString(1, things.getNome());
			statement.setString(2, things.getDescricao());
			statement.setInt(3, things.getId());
			statement.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Obter um item pelo id
	 * @param id
	 * @return
	 */
	public Things getById(int id) {
		Things things = null;
		String sql = " select id, Nome, Descricao from things where id = ?";
		
		try(Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				things = new Things();
				things.setId(resultSet.getInt(1));
				things.setNome(resultSet.getString(2));
				things.setDescricao(resultSet.getString(3));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return things;
	}
	
	/**
	 * Obter todos os itens na lista
	 * @return
	 */
	public List<Things> getAll(){
		List<Things> list = new ArrayList<>();
		String sql = " select id, Nome, Descricao from things order by Nome";
		
		try(Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Things things = new Things();
				things.setId(resultSet.getInt(1));
				things.setNome(resultSet.getString(2));
				things.setDescricao(resultSet.getString(3));
				
				list.add(things);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}