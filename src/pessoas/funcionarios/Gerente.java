package pessoas.funcionarios;

public class Gerente extends Funcionario {
	
	private int numeroAgencia;
	
	public void gerarRelatorioNumeroContas() {
		
	}

	@Override
	public String toString() {
		return "Gerente [numeroAgencia=" + numeroAgencia + ", nome=" + nome + ", cpf=" + cpf + ", senha=" + senha
				+ ", tipo=" + tipo + "]";
	}
	
	


}
