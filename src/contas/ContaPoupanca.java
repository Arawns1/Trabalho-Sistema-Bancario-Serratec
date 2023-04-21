package contas;

import banco.Agencia;
import banco.TipoConta;
import pessoas.Pessoa;

public class ContaPoupanca extends Conta{
	
	public ContaPoupanca(int numero, Pessoa titular, double saldo, TipoConta tipo, Agencia agencia) {
		super(numero, titular, saldo, tipo, agencia);
		
	}

	public final double TAXA_RENDIMENTO = 0.001;
	public void simularRendimento(double valorSimulado, int dias) {
		double montante = valorSimulado * Math.pow((1 + TAXA_RENDIMENTO), dias);
		System.out.println("| O valor após " + dias + " dias será de R$" + String.format("%.2f", montante));
		System.out.println("| Os juros totais setão de R$" + String.format("%.2f", (montante - valorSimulado)) );
	}
	
}
	
	

