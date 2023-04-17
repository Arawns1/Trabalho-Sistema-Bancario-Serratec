
package contas;

import java.util.ArrayList;
import java.util.List;

import banco.Agencia;
import banco.Operacao;
import banco.TipoConta;
import pessoas.Pessoa;

public abstract class Conta {

	protected int numero;
	protected Pessoa titular;
	protected double saldo;
	protected TipoConta tipo;
	protected Agencia agencia;
	protected List<List<String>> transacoes = new ArrayList<>();



	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Pessoa getTitular() {
		return titular;
	}

	public void setTitular(Pessoa titular) {
		this.titular = titular;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public TipoConta getTipo() {
		return tipo;
	}

	public void setTipo(TipoConta tipo) {
		this.tipo = tipo;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public List<List<String>> getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(List<List<String>> transacoes) {
		this.transacoes = transacoes;
	}

	protected void depositar(Double valor) {
		if (valor > 0) {
			this.saldo += valor;
			System.out.println("Seu deposito foi realizado com sucesso");
		} else {
			System.out.println("Não foi possivel realizar o deposito");
		}
	}

	protected void sacar(Double valor) {
		if (valor > 0 && this.saldo >= valor) {
			this.saldo -= valor;
			System.out.println("Seu saque foi realizado com sucesso");

		} else {
			System.out.println("Não foi possivel realizar o saque");
		}

	}

	protected void transferir(Conta contaDestino, double valor) {

		if (verificarSaldo(valor)) {
			System.out.println("Trasferência realizada com sucesso");
			this.saldo -= valor;
			contaDestino.saldo += valor;
			System.out.println("Seu saldo é de: " + this.saldo);
		} else {
			System.out.println("Saldo insuficiente para realizar a operação");
		}
	}

	public double consultarSaldo() {

		return this.saldo;

	}

	protected boolean verificarSaldo(double valor) {
		if (this.saldo >= valor && valor > 0) {
			return true;
		} else {
			return false;
		}

	}

	protected void tirarExtrato() {

		System.out.println(transacoes);

	}

	protected void addTransacao(Operacao tipo, double valor) {

	}

}
