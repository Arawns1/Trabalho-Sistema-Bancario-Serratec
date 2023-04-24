 package contas;

import java.io.IOException;
import java.time.LocalDateTime;

import banco.Agencia;
import banco.TipoConta;
import banco.utils.EscreverArquivos;
import pessoas.Pessoa;

public class ContaCorrente extends Conta {
	
	private boolean possuiSeguro = false;
	private double valorSeguro;
	
	public static final double TAXA_SAQUE = 0.10;
	public static final double TAXA_DEPOSITO = 0.10;
	public static final double TAXA_TRANSFERENCIA = 0.20;

	public double totalTaxaSaque;
	public double totalTaxaDeposito;
	public double totalTaxaTransferencia;

	public ContaCorrente(int numero, Pessoa titular, double saldo, Agencia agencia) {
		super(numero, titular, saldo, agencia);
		this.tipo = TipoConta.CONTA_CORRENTE;
	}

	@Override
	public void transferir(Conta contaDestino, double valor) {
		if (valor > 0 && this.saldo >= valor + TAXA_TRANSFERENCIA) {
			momentoOperacao = LocalDateTime.now();
			this.saldo -= valor + TAXA_TRANSFERENCIA;
			transacoes.add(momentoOperacao.format(dtf) + " Transferiu R$" + valor);
			totalTaxaTransferencia += TAXA_TRANSFERENCIA;
			contaDestino.getTransacoes().add(momentoOperacao.format(dtf) + " Recebeu R$" + valor);
			contaDestino.saldo += valor;
			try {
				EscreverArquivos.listaTransacoes(contaDestino);
			} catch (IOException e) {
				System.out.println("| ❌ Não foi possível gerar o extrato da conta destino!");
			}
			System.out.println("| ✔ Trasferência realizada com sucesso!");
		} else {
			System.out.println("| ❌ Saldo insuficiente para realizar a operação!");
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
			System.out.println("| ✔ Seu deposito foi realizado com sucesso!");
		} else {
			System.out.println("| ❌ Não foi possivel realizar o deposito!");
		}
	}

	@Override
	public void sacar(Double valor) {
		if (valor > 0 && this.saldo >= valor + TAXA_SAQUE) {
			this.saldo -= valor + TAXA_SAQUE;
			totalTaxaSaque += TAXA_SAQUE;
			momentoOperacao = LocalDateTime.now();
			transacoes.add(momentoOperacao.format(dtf) + " Sacou R$" + valor);
			System.out.println("| ✔ Seu saque foi realizado com sucesso!");

		} else {
			System.out.println("| ❌ Não foi possivel realizar o saque!");
		}
	}

	public void tirarRelatorioTaxa() {
		System.out.println("| Total gasto com taxas de saque: R$" + String.format("%.2f", this.totalTaxaSaque));
		System.out.println("| Total gasto com taxas de depósito: R$" + String.format("%.2f", this.totalTaxaDeposito));
		System.out.println("| Total gasto com taxas de transferência: R$" + String.format("%.2f", this.totalTaxaTransferencia));
		System.out.println("| O somatório total das taxas: R$"+ String.format("%.2f", (this.totalTaxaSaque + this.totalTaxaDeposito + this.totalTaxaTransferencia)));
		if(this.possuiSeguro == true) {
			System.out.println("| O valor do seu seguro é: " + this.valorSeguro);
		}
	}
	
	public String tirarRelatorioTaxasArquivo() {
		String textoSeguro = "";
		if(this.possuiSeguro == true) {
			textoSeguro = "O valor do seu seguro é: " + this.valorSeguro;
		}
		return "Total gasto com taxas de saque: R$" + String.format("%.2f", this.totalTaxaSaque) + 
 		  "\n" + "Total gasto com taxas de depósito: R$" + String.format("%.2f", this.totalTaxaDeposito) +
 		  "\n" + "Total gasto com taxas de transferência: R$" + String.format("%.2f", this.totalTaxaTransferencia) +
 		  "\n" +  "O somatório total das taxas: R$" + String.format("%.2f", (this.totalTaxaSaque + this.totalTaxaDeposito + this.totalTaxaTransferencia))+
 		  "\n" + textoSeguro;
		
	}
	

	public double getTotalTaxaSaque() {
		return totalTaxaSaque;
	}

	public void setTotalTaxaSaque(double totalTaxaSaque) {
		this.totalTaxaSaque = totalTaxaSaque;
	}

	public double getTotalTaxaDeposito() {
		return totalTaxaDeposito;
	}

	public void setTotalTaxaDeposito(double totalTaxaDeposito) {
		this.totalTaxaDeposito = totalTaxaDeposito;
	}

	public double getTotalTaxaTransferencia() {
		return totalTaxaTransferencia;
	}

	public void setTotalTaxaTransferencia(double totalTaxaTransferencia) {
		this.totalTaxaTransferencia = totalTaxaTransferencia;
	}

	public boolean possuiSeguro() {
		return possuiSeguro;
	}

	public void setPossuiSeguro(boolean possuiSeguro) {
		this.possuiSeguro = possuiSeguro;
	}

	public double getValorSeguro() {
		return valorSeguro;
	}

	public void setValorSeguro(double valorSeguro) {
		this.valorSeguro = valorSeguro;
	}

	@Override
	public String toString() {
		return "ContaCorrente," + numero + "," + titular + "," + this.getAgencia().getNumero() + "," + saldo;
	}

}
