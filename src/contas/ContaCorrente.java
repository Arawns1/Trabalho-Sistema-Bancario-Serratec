package contas;

public class ContaCorrente extends Conta {

	public static final double TAXA_SAQUE = 0.10;
	public static final double TAXA_DEPOSITO = 0.10;
	public static final double TAXA_TRANSFERENCIA = 0.20;
	
	public double totalTaxaSaque;
	public double totalTaxaDeposito;
	public double totalTaxaTransferencia;
	public double taxasTotais;
	
	//public void addTransaçao(EnumOperaçoes tipo, double valor) {
		
	//}

	public void TirarRelatorioTaxa() {
	}
}
