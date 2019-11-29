package br.univille.poo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.univille.poo.mvc.model.VeiculoModel;

/**
 * Pessoa Data Acess Object
 * 
 *
 */
public class VeiculoDAO extends BasicoDAO{
	

	/**
	 * Inserir uma nova pessoa
	 * @param veiculo
	 */
	public void insert(VeiculoModel veiculo) {

		String sql = " insert into veiculo(nome, marca, placa) values(?,?,?)";
		
		try (Connection conn = getConnection();
			 PreparedStatement statement = conn.prepareStatement(sql,
                     Statement.RETURN_GENERATED_KEYS)){

			statement.setString(1, veiculo.getNome());
			statement.setString(2, veiculo.getMarca());
			statement.setString(3, veiculo.getPlaca());
			statement.execute();
			
			 try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	            	veiculo.setId(generatedKeys.getLong(1));
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
	 * @param veiculo
	 */
	public void delete(VeiculoModel veiculo) {
		
		String sql = " delete from veiculo where id = ?";
		
		try(Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setLong(1, veiculo.getId());
			statement.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Atualizar uma pessoa pelo id
	 * @param veiculo
	 */
	public void update(VeiculoModel veiculo) {
		String sql = " update veiculo set nome = ?, marca = ?, placa = ? where id = ?";
		
		try (Connection conn = getConnection();
			 PreparedStatement statement = conn.prepareStatement(sql)){
			statement.setLong(4, veiculo.getId());
			statement.setString(1, veiculo.getNome());
			statement.setString(2, veiculo.getMarca());
			statement.setString(3, veiculo.getPlaca());
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
	public VeiculoModel getById(int id) {
		VeiculoModel veiculo = null;
		String sql = " select id, nome, marca, placa from veiculo where id = ?";
		
		try(Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				veiculo = new VeiculoModel();
				veiculo.setId(resultSet.getLong(1));
				veiculo.setNome(resultSet.getString(2));
				veiculo.setMarca(resultSet.getString(3));
				veiculo.setPlaca(resultSet.getString(4));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return veiculo;
	}
	
	/**
	 * Obter todas as pessoas da tabel
	 * @return
	 */
	public List<VeiculoModel> getAll(){
		List<VeiculoModel> list = new ArrayList<>();
		String sql = " select id, nome, marca, placa from veiculo order by nome";
		
		try(Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				VeiculoModel veiculo = new VeiculoModel();
				veiculo.setId(resultSet.getLong(1));
				veiculo.setNome(resultSet.getString(2));
				veiculo.setMarca(resultSet.getString(3));
				veiculo.setPlaca(resultSet.getString(4));
				list.add(veiculo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}