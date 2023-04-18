package pessoas;

import java.util.HashMap;

import contas.Conta;
import pessoas.funcionarios.Cargo;

public class Cliente extends Pessoa {
	
	public Cliente(String nome, String cpf, int senha, Cargo tipo) {
		super(nome, cpf, senha, tipo);
		
	}

	public HashMap<String, Conta> listaCliente = new HashMap<String, Conta>();

	public HashMap<String, Conta> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(HashMap<String, Conta> listaCliente) {
		this.listaCliente = listaCliente;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + ", tipo=" + tipo + "]";
	}
	
}
