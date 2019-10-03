package THINGSTODO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class fabrica_conexoes {

	public Connection getConnection(){
		try {
			return DriverManager.getConnection( "jdbc:mysql://localhost:3306/"+"todolist?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
					,"root"
					,"univille");
		}catch (SQLException e) {
			throw new RuntimeException(e);}
	}
	private static fabrica_conexoes instance;
	private fabrica_conexoes() {}
	public static fabrica_conexoes getInstance() {
		if(instance == null) {
			instance = new fabrica_conexoes();
		}
		return instance;
	}

}



