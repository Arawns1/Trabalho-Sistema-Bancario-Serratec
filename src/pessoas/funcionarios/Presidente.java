package pessoas.funcionarios;

import java.io.IOException;

import banco.Agencia;
import banco.Banco;
import banco.utils.EscreverArquivos;
import contas.Conta;

public class Presidente extends Diretor {
	
	public Presidente(String nome, String cpf, int senha) {
		super(nome, cpf, senha);
		this.tipo = Cargo.PRESIDENTE;
	}

	public void cadastrarAgencia(){
		System.out.print("|-> Digite o nome do gerente: ");
		String nome = sc.next();
		System.out.print("|-> Digite o CPF: ");
		String cpf = sc.next();
		System.out.println("|-> Digite a Senha: ");
		int senha = sc.nextInt();
		Agencia a1 = new Agencia(new Gerente(nome, cpf, senha));
		Banco.getListaAgencias().put(Banco.getContadorAgencia(), a1);
		try {
			EscreverArquivos.escreverAgencias();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void gerarRelatorioCapitalTotal() {
		double saldoTotal = 0;
		for (Integer i : Banco.getListaAgencias().keySet()) {
			for (Conta j : Banco.getListaAgencias().get(i).getContas()) {
				saldoTotal += j.getSaldo();
			}
		}
		Banco.setSaldoTotal(saldoTotal);
		System.out.println("| O saldo total do banco é: R$" + String.format("%.2f", saldoTotal));
	}

	@Override
	public String toString() {
		return "Presidente," + nome + "," + cpf + "," + senha;
	}
	
	
	
	
	
	

}


