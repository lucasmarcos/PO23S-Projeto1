package main;

import java.util.List;

import dao.DAOConta;
import entidades.Conta;

public class Main {
	public static void main(String[] args) {
		DAOConta c = new DAOConta();
		List<Conta> lista = c.buscarContas();

		for(int i = 0; i < lista.size(); i++) {
			Conta conta = lista.get(i);
			System.out.println("CONTA ID: " + conta.getId());
		}
		
/*		ContaBancaria conta1 = new ContaBancaria();
		conta1.depositar(10.0);
		conta1.sacar(1.5);
		conta1.sacar(4.2);
		conta1.depositar(0.1);

		ContaBancaria conta2 = new ContaBancaria("Michael Myers", 2, 1978.0);
		ContaBancaria conta3 = new ContaBancaria("Naomi Watts", 3, 10.35);

		ContaBancaria conta4 = new ContaBancaria();
		conta4.setNomeCliente("Liquid Ocelot");
		conta4.setNumero(4);
		conta4.setSaldo(-10.0);
		conta4.sacar(199.99);

		System.out.println("# " + conta1.getNumero()
				+ ", " + conta1.getNomeCliente()
				+ ": saldo = " + conta1.getSaldo());

		System.out.println("# " + conta2.getNumero()
				+ ", " + conta2.getNomeCliente()
				+ ": saldo = " + conta2.getSaldo());

		System.out.println("# " + conta3.getNumero()
				+ ", " + conta3.getNomeCliente()
				+ ": saldo = " + conta3.getSaldo());

		System.out.println("# " + conta4.getNumero()
				+ ", " + conta4.getNomeCliente()
				+ ": saldo = " + conta4.getSaldo()); */
	}
}