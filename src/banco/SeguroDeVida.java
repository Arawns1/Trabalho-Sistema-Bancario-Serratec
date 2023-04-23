package banco;

import java.util.Scanner;

import contas.Conta;
import contas.ContaCorrente;

public abstract class SeguroDeVida {
	public static void contratarSeguro(Conta conta) {
		Scanner sc = new Scanner(System.in);
		System.out.println("-".repeat(40));
		System.out.println("\t\t SEGURO");
		System.out.println("-".repeat(40));
		System.out.print("| Digite o valor a ser segurado: R$ ");
		double valor = sc.nextDouble();
		double entrada = valor * 0.2;
		if (conta.getSaldo() > entrada) {
		conta.setSaldo(conta.getSaldo() - entrada);
		((ContaCorrente)(conta)).setPossuiSeguro(true);
		((ContaCorrente)(conta)).setValorSeguro(valor);
		System.out.println("| ✔ Seguro no valor de R$" + valor + " contratado com sucesso!");
	}
		else {
			System.out.println("| ❌ Saldo insuficiente para contratar o seguro!");
		}
	}
}
