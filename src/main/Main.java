package main;

import dao.DAOConta;
import dao.DAOPessoa;
import entidades.Conta;
import entidades.Pessoa;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static Scanner scanner;

	public static void main(String[] args) {
		DAOConta daoConta = new DAOConta();
		DAOPessoa daoPessoa = new DAOPessoa();

		scanner = new Scanner(System.in);
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
				break;

			case 2:
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
				break;

			case 6:
				break;
				
			case 7:
				System.out.println("remover Pessoa com id: ");
				daoPessoa.delete(scanner.nextInt());
				break;

			case 8:
				System.out.println("remover Conta com id: ");
				daoConta.delete(scanner.nextInt());
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
