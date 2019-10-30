package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexao {
	private static String uri = "jdbc:postgresql:projeto1";
	private static String usuario = "lcs";
	private static String senha = "";

	private Connection connection;

	public Connection getConnection() {
		return connection;
	}

	public Conexao() {
		try {
			connection = DriverManager.getConnection(uri, usuario, senha);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int executeSQL(String sql) {
		try {
			Statement stm = connection.createStatement();
			int res = stm.executeUpdate(sql);
			connection.close();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public ResultSet executeBusca(String sql) {
		try {
			Statement stm = connection.createStatement();
			ResultSet res = stm.executeQuery(sql);
			connection.close();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
