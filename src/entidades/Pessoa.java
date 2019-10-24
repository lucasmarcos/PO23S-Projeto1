package entidades;

public class Pessoa {
	private int id;
	private String nome;
	private String cpf;
	private int idade;
	private String cidade;
	
	public Pessoa() {}

	public Pessoa(String nome, String cpf, int idade, String cidade) {
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.cidade = cidade;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public String getCidade() {
		return cidade;
	}
}
