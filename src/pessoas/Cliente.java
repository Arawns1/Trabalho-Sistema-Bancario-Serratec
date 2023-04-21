package pessoas;

import java.util.HashMap;

import contas.Conta;
import contas.ContaPoupanca;
import pessoas.funcionarios.Cargo;

public class Cliente extends Pessoa {
	
	public Cliente(String nome, String cpf, int senha, Cargo tipo) {
		super(nome, cpf, senha, tipo);
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + ", tipo=" + tipo + "]";
	}
	
}
