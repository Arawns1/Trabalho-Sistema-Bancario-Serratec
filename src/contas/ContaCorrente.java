package contas;

import java.time.LocalDateTime;

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



	public ContaCorrente(int numero, Pessoa titular, double saldo, TipoConta tipo, Agencia agencia) {
		super(numero, titular, saldo, tipo, agencia);

	}
	
	@Override
	public void transferir(Conta contaDestino, double valor) {
		if (valor > 0 && this.saldo >= valor + TAXA_TRANSFERENCIA){
			momentoOperacao = LocalDateTime.now();
			this.saldo -= valor + TAXA_TRANSFERENCIA;
			transacoes.add(momentoOperacao.format(dtf) + " Transferiu R$" + valor);
			totalTaxaTransferencia += TAXA_TRANSFERENCIA;
			System.out.println("Trasferência realizada com sucesso");
			contaDestino.saldo += valor;
		} else {
			System.out.println("Saldo insuficiente para realizar a operação");
		}
		
	}
	
	@Override
	public void depositar(Double valor) {
		if (valor > 0) {
			momentoOperacao = LocalDateTime.now();
			this.saldo += valor;
			this.saldo -= TAXA_DEPOSITO;
			totalTaxaDeposito += TAXA_DEPOSITO;
			transacoes.add(momentoOperacao.format(dtf) + " Depositou R$" + valor);
			System.out.println("Seu deposito foi realizado com sucesso");
		} else {
			System.out.println("Não foi possivel realizar o deposito");
		}
	}
	
	@Override
	public void sacar(Double valor) {
		if (valor > 0 && this.saldo >= valor + TAXA_SAQUE) {
			this.saldo -= valor + TAXA_SAQUE;
			totalTaxaSaque +=TAXA_SAQUE;
			momentoOperacao = LocalDateTime.now();
			transacoes.add(momentoOperacao.format(dtf) + " Sacou R$" + valor);
			System.out.println("Seu saque foi realizado com sucesso");

		} else {
			System.out.println("Não foi possivel realizar o saque");
		}
	}


	@Override
	protected void tirarExtrato() {
		// TODO Auto-generated method stub
		super.tirarExtrato();
	}


	public void TirarRelatorioTaxa() {
		System.out.println("Total gasto com Taxas de saque: R$" + this.totalTaxaSaque);
		System.out.println("Total gasto com Taxas de depósito: R$" + this.totalTaxaDeposito);
		System.out.println("Total gasto com Taxas de transferência: R$" + this.totalTaxaTransferencia);
		System.out.println("O somatório total das Taxas de saque: R$" + (this.totalTaxaSaque + this.totalTaxaDeposito + this.totalTaxaTransferencia));

	}

	@Override
	public String toString() {
		return "ContaCorrente [numero=" + numero + ", titular=" + titular + ", saldo=" + saldo + ", tipo=" + tipo
				+ ", agencia=" + agencia + "]";
	}
	
	
}
