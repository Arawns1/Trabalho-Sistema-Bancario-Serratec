package pessoas.funcionarios;

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
		
	}

	
	@Override
	public String toString() {
		return "Gerente [numeroAgencia=" + numeroAgencia + ", nome=" + nome + ", cpf=" + cpf + ", senha=" + senha
				+ ", tipo=" + tipo + "]";
	}
	
	


}
