package pessoas.funcionarios;

import java.util.Scanner;

import banco.Agencia;
import banco.Banco;
import banco.utils.EscreverArquivos;
import contas.Conta;
import contas.ContaCorrente;
import contas.ContaPoupanca;
import pessoas.Cliente;
import pessoas.Pessoa;

public class Gerente extends Funcionario {
	Scanner sc = new Scanner(System.in);
	private int numeroAgencia;

	public Gerente(String nome, String cpf, int senha, int numeroAgencia) {
		super(nome, cpf, senha);
		this.numeroAgencia = numeroAgencia;
		this.tipo = Cargo.GERENTE;
	}

	public Gerente(String nome, String cpf, int senha) {
		super(nome, cpf, senha);
		this.tipo = Cargo.GERENTE;
	}
	
	public void cadastrarCliente() {
		
		System.out.print("|-> Digite o nome: ");
		String nome = sc.next();
		System.out.print("|-> Digite o CPF: ");
		String cpf = sc.next();
		System.out.print("|-> Digite a senha: ");
		int senha = sc.nextInt();
		System.out.print("|-> Tipo da conta (CC/CP): ");
		String tipoConta = sc.next();
		Pessoa p = new Cliente(nome, cpf, senha);
		Agencia agencia = Banco.getListaAgencias().get(numeroAgencia);
		Conta conta;
		if(tipoConta.equalsIgnoreCase("CC")) {
			conta = new ContaCorrente(134, p, 0.0, agencia);
		}
		else {
			conta = new ContaPoupanca(134, p, 0.0, agencia);
		}
		Banco.getListaCliente().put(cpf, conta);
		agencia.addNovaConta(conta);
		try {
			EscreverArquivos.escreverClientes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("| ✔ Conta criada com sucesso!");
	}
	
	public void gerarRelatorioNumeroContas() {
		System.out.println("O número de contas da agencia "+ this.numeroAgencia + " é " +  Banco.getListaAgencias().get(numeroAgencia).getNumContas());
	}
	
	public int getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(int numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	@Override
	public String toString() {
		return "Gerente," + nome + "," + cpf + "," + senha;
	}

}
