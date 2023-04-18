package banco;

import java.util.ArrayList;
import java.util.List;
import contas.Conta;
import pessoas.funcionarios.Gerente;

public class Agencia {

	private int numero;
	private Gerente gerente;
	private List<Conta> contas = new ArrayList<Conta>();

	public Agencia(int numero, Gerente gerente) {
		super();
		this.numero = numero;
		this.gerente = gerente;

	}

	public void addNovaConta(Conta conta) {
		contas.add(conta);

	}

	public int getNumContas(Gerente gerente) {
		return contas.size();

	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	
	 public Gerente getGerente() { return gerente; }
	  
	 public void setGerente(Gerente gerente) { this.gerente = gerente; }
	 

	public void getContas() {
		for (int i = 0; i < contas.size(); i++) {
			System.out.println (contas.get(i));
		}
		
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

	@Override
	public String toString() {
		return "Agencia [numero=" + numero + ", gerente=" + gerente + ", contas=" + contas + "]";
	}
	
	
}
