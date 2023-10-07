package Nodebounty_DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao_MySQL {
	public Connection obj_connection = null;
	static Connection conn;
	private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:3306/nodebounty";
	private final String Login = "root";
	private final String Senha = "";

	public boolean getConnection() {
		try {
			Class.forName(DRIVER);
			obj_connection = DriverManager.getConnection(URL, Login, Senha);
			System.out.println("Conectou");
			return true;
		} catch (ClassNotFoundException erro) {
			System.out.println("Driver nao encontrado" + erro.toString());
			return false;
		} catch (SQLException erro) {
			System.out.println("Falha ao Conectar" + erro.toString());
			return false;
		}
	}
	
	public Connection getConexao() throws SQLException {
		conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, Login, Senha);
			System.out.println("Conectado");
			return conn;
		} 
		
		catch (ClassNotFoundException e) {
				String errorMsg = "Driver nao encontrado";
				throw new SQLException(errorMsg, e);
				} 
		catch (SQLException e) {
		String errorMsg = "Erro ao obter a conexao";
		throw new SQLException(errorMsg, e);
		}
	}	
}