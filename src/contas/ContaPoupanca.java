package contas;

import banco.Agencia;
import banco.TipoConta;
import pessoas.Pessoa;

public class ContaPoupanca extends Conta{
	
	public ContaPoupanca(int numero, Pessoa titular, double saldo, Agencia agencia) {
		super(numero, titular, saldo, agencia);
		this.tipo = TipoConta.CONTA_POUPANCA;
	}

	public static final double TAXA_RENDIMENTO = 0.001;
	public void simularRendimento(double valorSimulado, int dias) {
		double montante = valorSimulado * Math.pow((1 + TAXA_RENDIMENTO), dias);
		System.out.println("| O valor após " + dias + " dias será de R$" + String.format("%.2f", montante));
		System.out.println("| Os juros totais serão de R$" + String.format("%.2f", (montante - valorSimulado)) );
	}
	@Override
	public String toString() {
		return "ContaPoupanca," + numero + "," + titular +"," + this.getAgencia().getNumero() +  "," + saldo;
	}
	
}
	
	

