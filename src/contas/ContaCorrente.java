package contas;

import banco.Agencia;
import banco.TipoConta;
import pessoas.Pessoa;

public class ContaCorrente extends Conta {

	public static final double TAXA_SAQUE = 0.10;
	public static final double TAXA_DEPOSITO = 0.10;
	public static final double TAXA_TRANSFERENCIA = 0.20;
	
	public double totalTaxaSaque;
	public double totalTaxaDeposito;
	public double totalTaxaTransferencia;
	public double taxasTotais;
	
	//public void addTransa�ao(EnumOpera�oes tipo, double valor) {
		
	//}

	public ContaCorrente(int numero, Pessoa titular, double saldo, TipoConta tipo, Agencia agencia) {
		super(numero, titular, saldo, tipo, agencia);
		
	}

	public void TirarRelatorioTaxa() {
		
	}

	@Override
	public String toString() {
		return "ContaCorrente [numero=" + numero + ", saldo=" + saldo + ", tipo=" + tipo + "]";
	}

	
	} 
	
	
 
	

	

