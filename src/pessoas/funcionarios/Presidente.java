package pessoas.funcionarios;

public class Presidente extends Diretor {
	
	public Presidente(String nome, String cpf, int senha, Cargo tipo) {
		super(nome, cpf, senha, tipo);
	}

	public void gerarRelatorioCapitalTotal() {
		
	}

	@Override
	public String toString() {
		return "Presidente [nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + ", tipo=" + tipo + "]";
	}
	
	
	
	
	
	

}


