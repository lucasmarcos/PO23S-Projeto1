package entidades;

public class Conta {
	private int id;
	private Pessoa pessoa;
	private int numero;
	private String banco;
	private double saldo;

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Conta() {}
	
	public Conta(Pessoa pessoa, int numero, String banco, double saldo) {
		this.pessoa = pessoa;
		this.numero = numero;
		this.banco = banco;
		this.saldo = saldo;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public String getBanco() {
		return banco;
	}
	
	public double getSaldo() {
		return saldo;
	}
}