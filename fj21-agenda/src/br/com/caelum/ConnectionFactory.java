package br.com.caelum;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class ConnectionFactory {
 
public Connection getConnection() {
	try {
			Class.forName("com.mysql.jdbc.Driver"); // Essa linha carrega a classe respons�vel por fazer a conex�o com o MySQL.
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/fj21", "root", "ie14ih153");
	} catch (SQLException e) {
		throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
			}
	}
}
