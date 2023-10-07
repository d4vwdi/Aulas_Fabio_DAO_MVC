package Nodebounty_DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao_MySQL {
	private String sDriver;
	private String sServidor;
	private String sBase;
	private String connStr;
	static Connection conn;

	public Conexao_MySQL() {
		Config config = new Config();
		// conn = null;

		this.sDriver = "com.mysql.jdbc.Driver";
		this.sServidor = config.getConfig("hostname");

		if (config.getConfig("type").equals("local")) {
			this.sServidor = "localhost";
		}
		// Para poder utilizar procedures no mysql com java -
		// ?noAccessToProcedureBodies=true
		// jdbc:mysql://ipaddress:3306/test?noAccessToProcedureBodies=true
		this.sBase = config.getConfig("database");
		this.connStr = "jdbc:mysql://" + sServidor + ":3306/" + sBase + "?noAccessToProcedureBodies=true&useSSL=false";
	}

	public Connection getConexao(String login, String senha) throws SQLException {
		conn = null;
		try {
			Class.forName(sDriver);
			conn = DriverManager.getConnection(connStr, login, senha);
			System.out.println("Conectado");
			return conn;
		}

		catch (ClassNotFoundException e) {
			String errorMsg = "Driver nao encontrado";
			throw new SQLException(errorMsg, e);
		} catch (SQLException e) {
			String errorMsg = "Erro ao obter a conexao";
			throw new SQLException(errorMsg, e);
		}
	}

	public void desconectar() {
		try {
			if (conn != null) {
				conn.close();
				System.out.print("Desconectado passou aqui ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
