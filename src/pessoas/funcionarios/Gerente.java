package pessoas.funcionarios;

import banco.Banco;

public class Gerente extends Funcionario {

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
		return "Gerente [nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + "]";
	}

}
