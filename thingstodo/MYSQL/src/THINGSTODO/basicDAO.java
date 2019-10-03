package THINGSTODO;


import java.sql.Connection;


public abstract class basicDAO {
	
	
	public Connection getConnection() {
		return fabrica_conexoes.getInstance().getConnection();
	}

}