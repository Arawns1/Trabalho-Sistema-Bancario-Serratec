package banco;

import java.util.HashMap;
import contas.Conta;
import pessoas.funcionarios.Funcionario;
import pessoas.funcionarios.Presidente;

public abstract class Banco {
	private static String nome;
	private static Presidente presidente;
	private static HashMap<String, Conta> listaCliente = new HashMap<>();
	private static HashMap<String, Funcionario> listaFuncionarios = new HashMap<>();
	private static HashMap<Integer, Agencia> listaAgencias = new HashMap<>();
	private static double saldoTotal;
	private static int contadorAgencia = 0;

	public static void addNovaAgencia(Agencia agencia) {
		// Em nossa classe principal (Sistema Bancario), criamos uma agencia e
		// agora queremos vinculá-la ao banco.
		// Como faremos isso?
		// Vamos adicionar essa agencia a uma lista de agencias que o banco administra
		// Nossa lista se chama listaAgencias.
		// Porém para dar mais dinamismo ao nosso sistema utilizaremos o HashMap
		// pensando em utilizações futuras.
		// O HashMap é uma conjunto de [chaves:valor] que quando passamos a chave ele
		// automaticamente retorna
		// o valor dela.

		// Em nosso HashMap listaAgencia, precisamos passar uma chave do tipo Integer e
		// um valor do tipo Agencia
		// Ou seja, quando formos adicionar uma nova agencia a essa lista iremos
		// informar o número dela como
		// chave e ela mesmo como valor.

		// Para adicionar ao map usamos o método .put()
		listaAgencias.put(agencia.getNumero(), agencia);

		// Por fim, ao adicionarmos uma nova agencia ao nosso banco, aumentaremos o
		// contador de agencias
		contadorAgencia++;

		// Volte para o Sistema Bancário, linha 86.

	}

	// Getters e Setters
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

	public static HashMap<String, Conta> getListaCliente() {
		return listaCliente;
	}

	public static void setListaCliente(HashMap<String, Conta> listaCliente) {
		Banco.listaCliente = listaCliente;
	}

	public static HashMap<String, Funcionario> getListaFuncionarios() {
		return listaFuncionarios;
	}

	public static void setListaFuncionarios(HashMap<String, Funcionario> listaFuncionarios) {
		Banco.listaFuncionarios = listaFuncionarios;
	}

	@Override
	public String toString() {
		return "Banco [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
