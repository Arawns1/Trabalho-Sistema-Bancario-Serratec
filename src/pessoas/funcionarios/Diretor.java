package pessoas.funcionarios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import banco.Banco;
import contas.Conta;

public class Diretor extends Gerente{
	
	public Diretor(String nome, String cpf, int senha, int numeroAgencia) {
		super(nome, cpf, senha, numeroAgencia);
		this.tipo = Cargo.DIRETOR;
	}
	
	public Diretor(String nome, String cpf, int senha) {
		super(nome, cpf, senha);
		this.tipo = Cargo.DIRETOR;
	}
	
	
	public void gerarRelatorioInfoClientes() 
	{
		List<List<String>> matriz = new ArrayList<>();
		for (Integer i : Banco.getListaAgencias().keySet()) {
			for (Conta j : Banco.getListaAgencias().get(i).getContas()) {
				List<String> linha = new ArrayList<>();
				linha.add(j.getTitular().getNome());
				linha.add(j.getTitular().getCpf());
				linha.add(Integer.toString(j.getAgencia().getNumero()));
				linha.add(j.getAgencia().getGerente().getNome());
				matriz.add(linha);
			}
		}
		Collections.sort(matriz, new Comparator<List<String>>(){
			@Override
			public int compare(List<String> o1, List<String> o2) {
					String nome1 = o1.get(0);
					String nome2 = o2.get(0);
				return nome1.compareTo(nome2);
			}
		});
		System.out.println(" Nome | CPF | NumAgencia | Gerente");
		for(List<String> linha : matriz) {
			System.out.println(linha.get(0) + "," + linha.get(1) + "," + linha.get(2) + "," + linha.get(3));
		}
	}
	
	public static String gerarRelatorioInfoClientesArquivo() 
	{
		List<List<String>> matriz = new ArrayList<>();
		for (Integer i : Banco.getListaAgencias().keySet()) {
			for (Conta j : Banco.getListaAgencias().get(i).getContas()) {
				List<String> linha = new ArrayList<>();
				linha.add(j.getTitular().getNome());
				linha.add(j.getTitular().getCpf());
				linha.add(Integer.toString(j.getAgencia().getNumero()));
				linha.add(j.getAgencia().getGerente().getNome());
				matriz.add(linha);
			}
		}
		Collections.sort(matriz, new Comparator<List<String>>(){
			@Override
			public int compare(List<String> o1, List<String> o2) {
					String nome1 = o1.get(0);
					String nome2 = o2.get(0);
				return nome1.compareTo(nome2);
			}
		});
		
		String clientesTXT = "";
		
		for(List<String> linha : matriz) {
			clientesTXT += linha.get(0) + "," + linha.get(1) + "," + linha.get(2) + "," + linha.get(3) + "\n";
		}
			return " Nome | CPF | NumAgencia | Gerente" + "\n"
				+ clientesTXT;
	}
	
	@Override
	public String toString() {
		return "Diretor," + nome + "," + cpf + "," + senha;
	}
}
