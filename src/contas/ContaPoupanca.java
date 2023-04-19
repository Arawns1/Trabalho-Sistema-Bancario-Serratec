package contas;

import banco.Agencia;
import banco.TipoConta;
import pessoas.Pessoa;

public class ContaPoupanca extends Conta{
	
	public ContaPoupanca(int numero, Pessoa titular, double saldo, TipoConta tipo, Agencia agencia) {
		super(numero, titular, saldo, tipo, agencia);
		
	}

	public final double TAXA_RENDIMENTO = 0.03;
	public void simularRendimento(double valorSimulado, int mes) {
		double montante = valorSimulado * Math.pow((1 + TAXA_RENDIMENTO), mes);
		System.out.println("O valor após " + mes + " meses será de R$" + montante);
		System.out.println("Os juros totais foram de R$" + (montante - valorSimulado));
	}
	

	}
	
	

