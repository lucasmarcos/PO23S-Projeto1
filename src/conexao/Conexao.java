package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexao {
	private static String uri = "jdbc:postgresql:projeto1";
	private static String usuario = "postgres";
	private static String senha = "aluno";

	private Connection connection;

	public Connection getConnection() {
		return connection;
	}

	public Conexao() {
		try {
			connection = DriverManager.getConnection(uri, usuario, senha);
		} catch (Exception e) {
			String mensagem = e.getMessage();
			System.out.println("ERRO: nao foi possivel conectar ao banco de dados. " + (mensagem == null ? "" : mensagem));
		}
	}

	public int executeSQL(String sql) {
		try {
			Statement stm = connection.createStatement();
			int res = stm.executeUpdate(sql);
			connection.close();
			return res;
		} catch (Exception e) {
			String mensagem = e.getMessage();
			System.out.println("ERRO: ao executar alteracao no banco de dados. " + (mensagem == null ? "" : mensagem));
			// System.out.println(sql);
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
			String mensagem = e.getMessage();
			System.out.println("ERRO: a busca não pode ser executada. " + (mensagem == null ? "" : mensagem));
			// System.out.println(sql);
			return null;
		}
	}
}
