package THINGSTODO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	public static void main(String args[]) 
	{
	Things s = new Things();
	s.setNome("Padaria");
	s.setDescricao("comprar churros");

	
	DAO x = new DAO();
	x.insert(s);
	s.setId(6);
	x.delete(s);
	s.setId(8);
	s.setNome("casa");
	s.setDescricao("limpar");
	x.update(s);
	
	for(Things t: x.getAll()) {
		System.out.println(t);
		
		
	}
	System.out.println(x.getById(7));
	}
}