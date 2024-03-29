package dao;

import conexao.Conexao;
import entidades.Pessoa;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOPessoa {
	public int inserir(Pessoa pessoa) {
		Conexao c = new Conexao();
		String sql = "INSERT INTO pessoa (nome, cpf, idade, cidade) VALUES ('" +
			pessoa.getNome() + "', '" + pessoa.getCpf() + "', " + pessoa.getIdade() +
			", '" + pessoa.getCidade() + "')";
		int res = c.executeSQL(sql);

		c = new Conexao();
		ResultSet rs = c.executeBusca("SELECT id FROM pessoa ORDER BY id DESC LIMIT 1;");
		try {
			rs.next();
			pessoa.setId(rs.getInt(1));
		} catch(Exception e) {
			String mensagem = e.getMessage();
			System.out.println("ERRO: nao foi possivel inserir a nova pessoa. " + (mensagem == null ? "" : mensagem));
		}

		return res;
	}

	public List<Pessoa> buscarPessoas() {
		List<Pessoa> lista = new ArrayList<Pessoa>();

		Conexao c = new Conexao();
		ResultSet rs = c.executeBusca("SELECT id, nome, cidade, cpf, idade FROM pessoa;");

		try {
			while(rs.next()) {
				Pessoa pessoa = new Pessoa();

				pessoa.setId(rs.getInt("id"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setCidade(rs.getString("cidade"));
				pessoa.setCpf(rs.getString("cpf"));
				pessoa.setIdade(rs.getInt("idade"));

				lista.add(pessoa);
			}
		} catch(Exception e) {
			String mensagem = e.getMessage();
			System.out.println("ERRO: nao foi possivel listar todas as pessoas. " + (mensagem == null ? "" : mensagem));
		}

		return lista;
	}

	public Pessoa buscarPessoaPorId(int id) {
		Pessoa p = new Pessoa();
		Conexao c = new Conexao();

		String sql = "SELECT id, nome, cidade, cpf, idade FROM pessoa WHERE id = " + id + ";";

		ResultSet rs = c.executeBusca(sql);
		try {
			rs.next();
			p.setId(rs.getInt("id"));
			p.setNome(rs.getString("nome"));
			p.setCidade(rs.getString("cidade"));
			p.setCpf(rs.getString("cpf"));
			p.setIdade(rs.getInt("idade"));
		} catch(Exception e) {
			String mensagem = e.getMessage();
			System.out.println("ERRO: nao foi possivel encontrar a pessoa de id " + id + ". " + (mensagem == null ? "" : mensagem));
		}

		return p;
	}

	public int atualizarPessoa(Pessoa pessoa) {
		Conexao c = new Conexao();
		String sql = "UPDATE pessoa SET nome = '" + pessoa.getNome() +
			"', cidade = '" + pessoa.getCidade() +
			"', cpf = '" + pessoa.getCpf() +
			"', idade = " + pessoa.getIdade() +
			" WHERE id = " + pessoa.getId();
		c.executeSQL(sql);
		return 0;
	}

	public int delete(int id) {
		String sql = "DELETE FROM pessoa WHERE id = " + id + ";";
		Conexao c = new Conexao();

		try {
			c.executeSQL(sql);
		} catch (Exception e) {
			String mensagem = e.getMessage();
			System.out.println("ERRO: nao foi possivel remover a pessoa de id " + id + ". " + (mensagem == null ? "" : mensagem));
		}

		return 0;
	}

	public List<Pessoa> pesquisar(String campo, String parametro) {
		List<Pessoa> lista = new ArrayList<Pessoa>();

		String sql = "SELECT id, nome, cidade, cpf, idade FROM pessoa WHERE " + campo + " ILIKE '%" + parametro + "%';";
		Conexao c = new Conexao();
		ResultSet rs = c.executeBusca(sql);

		try {
			while(rs.next()) {
				Pessoa pessoa = new Pessoa();

				pessoa.setId(rs.getInt("id"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setCidade(rs.getString("cidade"));
				pessoa.setCpf(rs.getString("cpf"));
				pessoa.setIdade(rs.getInt("idade"));

				lista.add(pessoa);
			}
		} catch(Exception e) {
			String mensagem = e.getMessage();
			System.out.println("ERRO: pesquisa de pessoas nao concluida com sucesso. " + (mensagem == null ? "" : mensagem));
		}

		return lista;
	}
}
