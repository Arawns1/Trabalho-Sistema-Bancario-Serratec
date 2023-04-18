package banco;

import java.util.HashMap;

import pessoas.Pessoa;
import pessoas.funcionarios.Presidente;

public abstract class Banco {
	private static String nome;
	private static Presidente presidente;
	private static HashMap<Integer, Agencia> listaAgencias = new HashMap<Integer, Agencia>();
	private static double saldoTotal;
	private static int contadorAgencia = 0;
	
	public static Agencia getAgencia(int numAgencia) {
		return null;
		
	}
	public static void addNovaAgencia(Agencia agencia) {
		//[chave:valor]
		contadorAgencia ++;
		listaAgencias.put(agencia.getNumero(),agencia);

		
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
	public static int getContadorAgencia() {
		return contadorAgencia;
	}
	public static void setContadorAgencia(int numeroAgencias) {
		Banco.contadorAgencia = numeroAgencias;
	}
	@Override
	public String toString() {
		return "Banco [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
