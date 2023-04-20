package pessoas.funcionarios;

import java.util.HashMap;

import pessoas.Pessoa;

public abstract class Funcionario extends Pessoa{
	public static HashMap<String,Funcionario> listaFuncionarios = new HashMap<String, Funcionario>();
	
	
	public Funcionario(String nome, String cpf, int senha, Cargo tipo) {
		super(nome, cpf, senha, tipo);
		listaFuncionarios.put(cpf, this);
		
		
	}

	public void addNovaConta() {}

	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + ", tipo=" + tipo + "]";
	}

}
	
	
