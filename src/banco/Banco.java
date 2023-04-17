package banco;

import java.util.HashMap;

import pessoas.Pessoa;
import pessoas.Presidente;

public abstract class Banco {
	private static String nome;
	private static Presidente presidente;
	private static HashMap<Integer, Agencia> listaAgencias = new HashMap<Integer, Agencia>();
	private static double saldoTotal;
	private static int numeroAgencias;
	
	public static Agencia getAgencia(int numAgencia) {
		return null;
		
	}
	public static void addNovaAgencia(Pessoa presidente) {
		
	}
	public static String getInfoClientes(Pessoa diretor) {
		//return ;
	}
	//Getters e Setters
	public static String getNome() {
		return nome;
	}
	public static void setNome(String nome) {
		Banco.nome = nome;
	}
	public static Presidente getPresidente() {
		return presidente;
	}
	public static void setPresidente(Presidente presidente) {
		Banco.presidente = presidente;
	}
	public static HashMap<Integer, Agencia> getListaAgencias() {
		return listaAgencias;
	}
	public static void setListaAgencias(HashMap<Integer, Agencia> listaAgencias) {
		Banco.listaAgencias = listaAgencias;
	}
	public static double getSaldoTotal() {
		return saldoTotal;
	}
	public static void setSaldoTotal(double saldoTotal) {
		Banco.saldoTotal = saldoTotal;
	}
	public static int getNumeroAgencias() {
		return numeroAgencias;
	}
	public static void setNumeroAgencias(int numeroAgencias) {
		Banco.numeroAgencias = numeroAgencias;
	}
	@Override
	public String toString() {
		return "Banco [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
