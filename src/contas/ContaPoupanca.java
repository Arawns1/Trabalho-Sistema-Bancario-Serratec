package contas;

import banco.Agencia;
import banco.TipoConta;
import pessoas.Pessoa;

public class ContaPoupanca extends Conta{
	
	public ContaPoupanca(int numero, Pessoa titular, double saldo, TipoConta tipo, Agencia agencia) {
		super(numero, titular, saldo, tipo, agencia);
		
	}

	public final double TAXA_RENDIMENTO = 0.1;

	public void simularRendimento(double valorSimulado, int dias) {};

	}
	
	

