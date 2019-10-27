package main;

import java.util.Scanner;

import dao.DAOConta;
import dao.DAOPessoa;

public class Main {
	private static Scanner scanner;

	public static void main(String[] args) {
		DAOConta daoConta = new DAOConta();
		DAOPessoa daoPessoa = new DAOPessoa();

		scanner = new Scanner(System.in);
		boolean continuar = true;
		while(continuar) {
			System.out.println("MENU");
			System.out.println("I - Inserir");
			System.out.println("M - Mostrar");
			System.out.println("A - Atualizar");
			System.out.println("R - Remover");
			System.out.println("Q - Sair");

			String opcao = scanner.next().toLowerCase();
			switch(opcao) {
			case "q":
				System.out.println("tchau fudido!");
				continuar = false;
				break;
			}
		}
	}
}