package pessoas;

import java.util.HashMap;

import contas.Conta;
import pessoas.funcionarios.Cargo;

public class Cliente extends Pessoa {
	
	public Cliente(String nome, String cpf, int senha, Cargo tipo) {
		super(nome, cpf, senha, tipo);
		listaCliente.put(cpf, this);
		
	}

	public static HashMap<String, Cliente> listaCliente = new HashMap<String, Cliente>();

	public HashMap<String, Cliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(HashMap<String, Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + ", tipo=" + tipo + "]";
	}
	
}
