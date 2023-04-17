package contas;

import pessoas.Pessoa;

public abstract  class Conta {
	
	private int numero;
	private Pessoa pessoa;
	private double saldo;
	private String  tipoConta;
	private String transacao;
	public int agencia;
	public Conta(int numero, Pessoa pessoa, double saldo, String tipoConta, String transacao) {
		this.numero = numero;
		this.pessoa = pessoa;
		this.saldo = saldo;
		this.tipoConta = tipoConta;
		this.transacao = transacao;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getTipoConta() {
		return tipoConta;
	}
	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}
	public String getTransacao() {
		return transacao;
	}
	public void setTransacao(String transacao) {
		this.transacao = transacao;
	}
	
	
	public String toString() {
		return  " Numero da Conta =" + this.numero +" Numero da Agência=" + this.agencia + " titular="  this.pessoa.getNome(); " saldo=" + this.saldo +
			    " tipo=" + this.tipoConta;
	}
	
	public void  depositar (Double valor) {
		if (valor > 0) {
			this.saldo +=valor;
			System.out.println("Seu deposito foi realizado com sucesso");
		}else {
			System.out.println("Não foi possivel realizar o deposito");
		}
	}
	
	public void sacar (Double valor) {
		if(valor >0 && this.saldo >= valor) {
			this.saldo -=valor;
			System.out.println("Seu saque foi realizado com sucesso");
					
		}else {
			System.out.println("Não foi possivel realizar o saque");
		}
			
	}
    public void transferir(Conta contaDestino, double valor) {
		
		if(this.saldo > valor && valor > 0) {
			System.out.println("Trasferência realizada com sucesso");
			this.saldo -=valor;
			contaDestino.saldo += valor;
			System.out.println("Seu saldo é de: " + this.saldo);
		}else {
			System.out.println("Saldo insuficiente para realizar a operação");
		}
		
			
	}
	
	
	


