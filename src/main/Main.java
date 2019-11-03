package main;

import dao.DAOConta;
import dao.DAOPessoa;
import entidades.Conta;
import entidades.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
	private static Scanner scanner;
	private static DAOConta daoConta;
	private static DAOPessoa daoPessoa;

	private static void inserirPessoa() {
		Pessoa pessoa = new Pessoa();
				
		System.out.print("Nome: ");
		pessoa.setNome(scanner.next());

		System.out.print("CPF: ");
		pessoa.setCpf(scanner.next());

		System.out.print("Idade: ");
		pessoa.setIdade(scanner.nextInt());

		System.out.print("Cidade: ");
		pessoa.setCidade(scanner.next());
		
		daoPessoa.inserir(pessoa);
		pessoa.mostrar();
	}

	private static void inserirConta() {
		Conta conta = new Conta();
				
		System.out.print("Banco: ");
		conta.setBanco(scanner.next());

		System.out.print("Numero: ");
		conta.setNumero(scanner.nextInt());

		System.out.print("Saldo: ");
		conta.setSaldo(scanner.nextDouble());

		System.out.print("Pessoa: ");
		conta.setPessoa(daoPessoa.buscarPessoaPorId(scanner.nextInt()));
		
		daoConta.inserir(conta);
		conta.mostrar();
	}

	private static void atualizarPessoa() {
		System.out.println("modificar Pessoa com id: ");
		Pessoa p = daoPessoa.buscarPessoaPorId(scanner.nextInt());

		System.out.print("Nome [" + p.getNome() + "]: ");
		String novoNome = scanner.next();
		if(!novoNome.isEmpty()) {
			System.out.println(novoNome);
			p.setNome(novoNome);
		}

		System.out.print("CPF [" + p.getCpf() + "]: ");
		String novoCPF = scanner.next();
		if(!novoCPF.isEmpty()) {
			System.out.println(novoCPF);
			p.setCpf(novoCPF);
		}

		System.out.print("Idade [" + p.getIdade() + "]: ");
		String novaIdade = scanner.next();
		if(!novaIdade.isEmpty()) {
			System.out.println(novaIdade);
			p.setIdade(Integer.parseInt(novaIdade));
		}

		System.out.print("Cidade [" + p.getCidade() + "]: ");
		String novaCidade = scanner.next();
		if(!novaCidade.isEmpty()) {
			System.out.println(novaCidade);
			p.setCidade(novaCidade);
		}

		daoPessoa.atualizarPessoa(p);
		p = daoPessoa.buscarPessoaPorId(p.getId());
		p.mostrar();
	}

	private static void atualizarConta() {
		System.out.println("modificar Conta com id: ");
		Conta c = daoConta.buscarContaPorId(scanner.nextInt());

		System.out.print("Banco [" + c.getBanco() + "]: ");
		String novoBanco = scanner.next();
		if(!novoBanco.isEmpty()) {
			System.out.println(novoBanco);
			c.setBanco(novoBanco);
		}

		System.out.print("Numero [" + c.getNumero() + "]: ");
		String novoNumero = scanner.next();
		if(!novoNumero.isEmpty()) {
			System.out.println(novoNumero);
			c.setNumero(Integer.getInteger(novoNumero));
		}

		System.out.print("Saldo [" + c.getSaldo() + "]: ");
		String novoSaldo = scanner.next();
		if(!novoSaldo.isEmpty()) {
			System.out.println(novoSaldo);
			c.setSaldo(Double.parseDouble(novoSaldo));
		}

		System.out.print("Pessoa [ " + c.getPessoa().getId() +"]: ");
		String novaPessoa = scanner.next();
		if(!novaPessoa.isEmpty()) {
			System.out.println(novaPessoa);
			c.setPessoa(daoPessoa.buscarPessoaPorId(Integer.parseInt(novaPessoa)));
		}

		daoConta.atualizarConta(c);
		c = daoConta.buscarContaPorId(c.getId());
		c.mostrar();
	}

	private static void pesquisarPessoa() {
		List<Pessoa> pessoas;

		System.out.println("pesquisar Pessoa por: ");
		System.out.println("[ 1 ] Nome, [ 2 ] Cidade");
		int filto_pessoa = scanner.nextInt();
		switch(filto_pessoa) {
		case 1:
			pessoas = daoPessoa.pesquisar("nome", scanner.next());
			break;

		case 2:
			pessoas = daoPessoa.pesquisar("cidade", scanner.next());
			break;
		
		default:
			pessoas = new ArrayList<Pessoa>();
			break;
		}

		for(int i = 0; i < pessoas.size(); i++)
			pessoas.get(i).mostrar();
	}

	private static void pesquisarConta() {
		List<Conta> contas;

		System.out.println("pesquisar Conta por: ");
		System.out.println("[ 1 ] Banco, [ 2 ] ID_Pessoa");
		int filto_conta = scanner.nextInt();
		switch(filto_conta) {
		case 1:
			contas = daoConta.pesquisar("banco", scanner.next());
			break;

		case 2:
			contas = daoConta.pesquisar("pessoa", scanner.next());
			break;
		
		default:
			contas = new ArrayList<Conta>();
			break;
		}

		for(int i = 0; i < contas.size(); i++)
			contas.get(i).mostrar();
	}

	public static void main(String[] args) {
		daoConta = new DAOConta();
		daoPessoa = new DAOPessoa();
		scanner = new Scanner(System.in);
		
		// scanner.useDelimiter("\\n");

		boolean continuar = true;
		while (continuar) {
			System.out.println(" - Menu Principal -");
			System.out.println("[ 1 ]: inserir nova Pessoa");
			System.out.println("[ 2 ]: inserir nova Conta");
			System.out.println();
			System.out.println("[ 3 ]: mostar todas as Pessoas");
			System.out.println("[ 4 ]: mostrar todas as Contas");
			System.out.println();
			System.out.println("[ 5 ]: atualizar Pessoa");
			System.out.println("[ 6 ]: atualizar Conta");
			System.out.println();
			System.out.println("[ 7 ]: remover Pessoa");
			System.out.println("[ 8 ]: remover Conta");
			System.out.println();
			System.out.println("[ 9 ]: procurar Pessoas");
			System.out.println("[ 10 ]: procurar Contas");
			System.out.println();
			System.out.println("[ 0 ]: Sair");

			int opcao = scanner.nextInt();
			switch (opcao) {
			case 1:
				inserirPessoa();
				break;

			case 2:
				inserirConta();
				break;

			case 3:
				List<Pessoa> pessoas = daoPessoa.buscarPessoas();
				for(int i = 0; i < pessoas.size(); i++)
					pessoas.get(i).mostrar();
				break;

			case 4:
				List<Conta> contas = daoConta.buscarContas();
				for(int i = 0; i < contas.size(); i++)
					contas.get(i).mostrar();
				break;

			case 5:
				atualizarPessoa();
				break;

			case 6:
				atualizarConta();
				break;
				
			case 7:
				System.out.println("remover Pessoa com id: ");
				daoPessoa.delete(scanner.nextInt());
				break;

			case 8:
				System.out.println("remover Conta com id: ");
				daoConta.delete(scanner.nextInt());
				break;

			case 9:
				pesquisarPessoa();
				break;

			case 10:
				pesquisarConta();
				break;

			default:
				System.out.println("FIM");
				continuar = false;
				break;
			}

			System.out.println();
		}
	}
}
