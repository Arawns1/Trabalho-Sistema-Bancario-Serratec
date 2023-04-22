package pessoas.funcionarios;

import banco.Banco;

public class Gerente extends Funcionario {

	private int numeroAgencia;

	public Gerente(String nome, String cpf, int senha, Cargo tipo, int numeroAgencia) {
		super(nome, cpf, senha, tipo);
		this.numeroAgencia = numeroAgencia;
	}

	public Gerente(String nome, String cpf, int senha, Cargo tipo) {
		super(nome, cpf, senha, tipo);
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
		return "Gerente [numeroAgencia=" + numeroAgencia + ", nome=" + nome + ", cpf=" + cpf + ", senha=" + senha
				+ ", tipo=" + tipo + "]";
	}

}
