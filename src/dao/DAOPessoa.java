package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import entidades.Conta;
import entidades.Pessoa;

public class DAOPessoa {
	public int inserir(Pessoa pessoa) {
		Conexao c = new Conexao();
		String sql = "INSERT INTO pessoa(nome, cpf, idade, cidade) VALUES ('" +
				pessoa.getNome() + "', '" + pessoa.getCpf() + "', " + pessoa.getIdade() +
				", '" + pessoa.getCidade() + "')";
		int res = c.executeSQL(sql);
		
		c = new Conexao();
		ResultSet rs = c.executeBusca("SELECT id FROM pessoa ORDER BY id DESC LIMIT 1;");
		try {
			rs.next();
			pessoa.setId(rs.getInt(1));
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	public Pessoa buscarPessoas() {
		List<Pessoa> lista = new ArrayList<Pessoa>();
		
		Conexao c = new Conexao();
		ResultSet rs = c.executeBusca("SELECT * FROM pessoa;");
		
		try { 
			while(rs.next()) {
				Pessoa pessoa = new Pessoa();
				
				pessoa.setId(rs.getInt("id"));
				pessoa.setBanco(rs.getString("banco"));
				pessoa.setSaldo(rs.getDouble("saldo"));
				pessoa.setNumero(rs.getInt("numero"));
				
				// falta pessoa
				
				lista.add(pessoa);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return lista;
	}
	
	public Pessoa buscarContaPorId(int id) {
		return new Pessoa();
	}
	
	public int atualizarConta(Pessoa pessoa) {
		return 0;
	}
	
	public int delete(int id) {
		return 0;
	}
}
