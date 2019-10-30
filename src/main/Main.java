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
				System.out.println("modificar Pessoa com id: ");
				Pessoa p = daoPessoa.buscarPessoaPorId(scanner.nextInt());

				System.out.print("Nome [" + p.getNome() + "]: ");
				String novoNome = scanner.next();
				if(!novoNome.isBlank()) {
					p.setNome(novoNome);
				}

				System.out.print("CPF [" + p.getCpf() + "]: ");
				String novoCPF = scanner.next();
				if(!novoCPF.isBlank()) {
					p.setCpf(novoCPF);
				}

				System.out.print("Idade [" + p.getIdade() + "]: ");
				String novaIdade = scanner.next();
				if(!novoCPF.isBlank()) {
					p.setIdade(Integer.getInteger(novaIdade));
				}

				System.out.print("Cidade [" + p.getCidade() + "]: ");
				String novaCidade = scanner.next();
				if(!novaCidade.isBlank()) {
					p.setCidade(novaCidade);
				}

				daoPessoa.atualizarPessoa(p);
				p = daoPessoa.buscarPessoaPorId(p.getId());
				p.mostrar();

				break;

			case 6:
				System.out.println("modificar Pessoa com id: ");
				Conta c = daoConta.buscarContaPorId(scanner.nextInt());

				System.out.print("Banco [" + c.getBanco() + "]: ");
				String novoBanco = scanner.next();
				if(!novoBanco.isBlank()) {
					c.setBanco(novoBanco);
				}

				System.out.print("Numero [" + c.getBanco() + "]: ");
				String novoNumero = scanner.next();
				if(!novoNumero.isBlank()) {
					c.setNumero(Integer.getInteger(novoNumero));
				}

				System.out.print("Saldo [" + c.getSaldo() + "]: ");
				String novoSaldo = scanner.next();
				if(!novoSaldo.isBlank()) {
					c.setSaldo(Double.parseDouble(novoSaldo));
				}

				System.out.print("Pessoa [ " + c.getPessoa().getId() +"]: ");
				String novaPessoa = scanner.next();
				if(!novaPessoa.isBlank()) {
					c.setPessoa(daoPessoa.buscarPessoaPorId(Integer.getInteger(novaPessoa)));
				}

				daoConta.atualizarConta(c);
				c = daoConta.buscarContaPorId(c.getId());
				c.mostrar();

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
