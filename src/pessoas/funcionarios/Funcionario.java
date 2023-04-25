package pessoas.funcionarios;

import banco.Banco;
import pessoas.Pessoa;

public abstract class Funcionario extends Pessoa{
	
	
	protected Funcionario(String nome, String cpf, int senha, Cargo tipo) {
		super(nome, cpf, senha, tipo);
		Banco.getListaFuncionarios().put(cpf, this);
	}
	protected Funcionario(String nome, String cpf, int senha) {
		super(nome, cpf, senha);
		Banco.getListaFuncionarios().put(cpf, this);
		this.tipo = null;
	}

	@Override
	public String toString() {
		return "Funcionario," + nome + "," + cpf + "," + senha + ",";
	}

}
	
	
