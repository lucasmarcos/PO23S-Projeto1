package dao;

import conexao.Conexao;
import entidades.Conta;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOConta {
	public int inserir(Conta conta) {
		Conexao c = new Conexao();
		String sql = "INSERT INTO conta (pessoa, numero, banco, saldo) VALUES (" +
				conta.getPessoa().getId() + ", " + conta.getNumero() + ", '" + conta.getBanco() + "', " + conta.getSaldo() + ");";
		int res = c.executeSQL(sql);

		c = new Conexao();
		ResultSet rs = c.executeBusca("SELECT id FROM conta ORDER BY id DESC LIMIT 1;");
		try {
			rs.next();
			conta.setId(rs.getInt(1));
		} catch(Exception e) {
			String mensagem = e.getMessage();
			System.out.println("ERRO: a nova conta nao pode ser inserida. " + (mensagem == null ? "" : mensagem));
		}

		return res;
	}

	public List<Conta> buscarContas() {
		List<Conta> lista = new ArrayList<Conta>();

		Conexao c = new Conexao();
		ResultSet rs = c.executeBusca("SELECT id, banco, saldo, numero, pessoa FROM conta;");

		try {
			while(rs.next()) {
				Conta conta = new Conta();

				conta.setId(rs.getInt("id"));
				conta.setBanco(rs.getString("banco"));
				conta.setSaldo(rs.getDouble("saldo"));
				conta.setNumero(rs.getInt("numero"));

				DAOPessoa dao = new DAOPessoa();
				conta.setPessoa(dao.buscarPessoaPorId(rs.getInt("pessoa")));

				lista.add(conta);
			}
		} catch(Exception e) {
			String mensagem = e.getMessage();
			System.out.println("ERRO: ao lista todas as contas. " + (mensagem == null ? "" : mensagem));
		}

		return lista;
	}

	public Conta buscarContaPorId(int id) {
		Conta conta = new Conta();
		Conexao c = new Conexao();

		String sql = "SELECT id, banco, numero, saldo, pessoa FROM conta WHERE id = " + id + ";";
		ResultSet rs = c.executeBusca(sql);

		try {
			rs.next();
			conta.setId(rs.getInt("id"));
			conta.setBanco(rs.getString("banco"));
			conta.setSaldo(rs.getDouble("saldo"));
			conta.setNumero(rs.getInt("numero"));

			DAOPessoa dao = new DAOPessoa();
			conta.setPessoa(dao.buscarPessoaPorId(rs.getInt("pessoa")));
		} catch(Exception e) {
			String mensagem = e.getMessage();
			System.out.println("ERRO: nao foi possivel retornar a conta de id " + id + ". " + (mensagem == null ? "" : mensagem));
		}

		return conta;
	}

	public int atualizarConta(Conta conta) {
		Conexao c = new Conexao();
		String sql = "UPDATE conta SET banco = '" + conta.getBanco() +
			"', saldo = " + conta.getSaldo() +
			", numero = " + conta.getNumero() +
			", pessoa = " + conta.getPessoa().getId() +
			" WHERE id = " + conta.getId();

		// System.out.println(sql);
		c.executeSQL(sql);
		return 0;
	}

	public int delete(int id) {
		String sql = "DELETE FROM conta WHERE id = " + id + ";";
		Conexao c = new Conexao();

		try {
			c.executeSQL(sql);
		} catch (Exception e) {
			String mensagem = e.getMessage();
			System.out.println("ERRO: nao foi possivel deletar a pessoa de id " + id + ". " + (mensagem == null ? "" : mensagem));
		}

		return 0;
	}

	public List<Conta> pesquisar(String campo, String parametro) {
		List<Conta> lista = new ArrayList<Conta>();

		String sql = "SELECT id, banco, numero, saldo, pessoa FROM conta WHERE " + campo + " ILIKE '%" + parametro + "%';";
		Conexao c = new Conexao();
		ResultSet rs = c.executeBusca(sql);

		try {
			while(rs.next()) {
				Conta conta = new Conta();

				conta.setId(rs.getInt("id"));
				conta.setBanco(rs.getString("banco"));
				conta.setSaldo(rs.getDouble("saldo"));
				conta.setNumero(rs.getInt("numero"));

				DAOPessoa dao = new DAOPessoa();
				conta.setPessoa(dao.buscarPessoaPorId(rs.getInt("pessoa")));

				lista.add(conta);
			}
		} catch(Exception e) {
			String mensagem = e.getMessage();
			System.out.println("ERRO: pesquisa nao executada. " + (mensagem == null ? "" : mensagem));
		}

		return lista;
	}
}
