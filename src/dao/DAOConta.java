package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import entidades.Conta;

public class DAOConta {
	public int inserir(Conta conta) {
		Conexao c = new Conexao();
		String sql = "INSERT INTO conta(pessoa, numero, banco, saldo) VALUES (" +
				conta.getPessoa().getId() + ", " + conta.getNumero() + ", '" + conta.getBanco() + "', " + conta.getSaldo() + ")";
		int res = c.executeSQL(sql);
		
		c = new Conexao();
		ResultSet rs = c.executeBusca("SELECT id FROM conta ORDER BY id DESC LIMIT 1;");
		try {
			rs.next();
			conta.setId(rs.getInt(1));
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	public List<Conta> buscarContas() {
		List<Conta> lista = new ArrayList<Conta>();
		
		Conexao c = new Conexao();
		ResultSet rs = c.executeBusca("SELECT * FROM conta;");
		
		try { 
			while(rs.next()) {
				Conta conta = new Conta();

				conta.setId(rs.getInt("id"));
				conta.setBanco(rs.getString("banco"));
				conta.setSaldo(rs.getDouble("saldo"));
				conta.setNumero(rs.getInt("numero"));
				
				// falta pessoa
				
				lista.add(conta);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return lista;
	}
	
	public Conta buscarContaPorId(int id) {
		return new Conta();
	}
	
	public int atualizarConta(Conta conta) {
		return 0;
	}
	
	public int delete(int id) {
		return 0;
	}
}
