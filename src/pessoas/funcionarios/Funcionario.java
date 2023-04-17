package pessoas.funcionarios;

import java.util.HashMap;

import pessoas.Pessoa;

public abstract class Funcionario extends Pessoa{
	private HashMap<String,Funcionario> listaFuncionarios = new HashMap<String, Funcionario>();
	
	public void addNovaConta() {}

	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + ", tipo=" + tipo + "]";
	}

}
	
	
