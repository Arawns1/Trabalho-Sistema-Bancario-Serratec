
package contas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
	protected List<String> transacoes = new ArrayList<>();
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");
	LocalDateTime momentoOperacao;

	public Conta(int numero, Pessoa titular, double saldo, TipoConta tipo, Agencia agencia) {
		super();
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
		this.tipo = tipo;
		this.agencia = agencia;
	}

		public void sacar(Double valor) {
		if (valor > 0 && this.saldo >= valor) {
			this.saldo -= valor;
			momentoOperacao = LocalDateTime.now();
			transacoes.add(momentoOperacao.format(dtf) + " Sacou R$" + valor);
			System.out.println("Seu saque foi realizado com sucesso");

		} else {
			System.out.println("Não foi possivel realizar o saque");
		}
	}

	public void depositar(Double valor) {
		if (valor > 0) {
			momentoOperacao = LocalDateTime.now();
			this.saldo += valor;
			transacoes.add(momentoOperacao.format(dtf) + " Depositou R$" + valor);
			System.out.println("Seu deposito foi realizado com sucesso");
		} else {
			System.out.println("Não foi possivel realizar o deposito");
		}
	}

	public void transferir(Conta contaDestino, double valor) {
		if (valor > 0 && this.saldo >= valor){
			momentoOperacao = LocalDateTime.now();
			this.saldo -= valor;
			transacoes.add(momentoOperacao.format(dtf) + " Transferiu R$" + valor);
			System.out.println("Trasferência realizada com sucesso");
			contaDestino.saldo += valor;
		
		} else {
			System.out.println("Saldo insuficiente para realizar a operação");
		}
	}

	protected void tirarExtrato() {
		System.out.println(transacoes);

	}

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

	public List<String>  getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(List<String> transacoes) {
		this.transacoes = transacoes;
	}

	@Override
	public String toString() {
		return "Conta [numero=" + numero + ", titular=" + titular + ", saldo=" + saldo + ", tipo=" + tipo + ", agencia="
				+ agencia + "]";
	}

	}
	

