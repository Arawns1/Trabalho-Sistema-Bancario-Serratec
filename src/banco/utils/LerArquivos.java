package banco.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import banco.Banco;
import contas.Conta;

public class LerArquivos {
	public static void ler(String path) throws IOException {

		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String linha = "";
	}

	public static void atualizarSaldos() throws IOException {
		String path = ".//Relatorios//ListaClientes.txt";
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String linha = "";

		while (true) {
			linha = buffRead.readLine();
			
			if (linha != null) {
				  int ultimoIgual = linha.lastIndexOf("="); 
				  int ultimaChave = linha.lastIndexOf("]"); 
				  String saldo = linha.substring(ultimoIgual+1, ultimaChave);
				  double saldoDouble = Double.parseDouble(saldo);
				  
				  int primeiraPalavraCpf = linha.indexOf("cpf")+4;
				  int primeiraVirgulaCpf = linha.indexOf(",", primeiraPalavraCpf);
				  String CPF = linha.substring(primeiraPalavraCpf, primeiraVirgulaCpf);
				  
				  int primeiraPalavraAgencia = linha.indexOf("Agencia")+8;
				  int primeiraVirgulaAgencia = linha.indexOf(",", primeiraPalavraAgencia);
				  String agencia = linha.substring(primeiraPalavraAgencia,primeiraVirgulaAgencia);
				
				  Integer agenciaInt = Integer.parseInt(agencia);
				  
				  for(Conta conta : Banco.getListaAgencias().get(agenciaInt).getContas()) {
					  if((conta.getTitular().getCpf()).equals(CPF)) {
						  conta.setSaldo(saldoDouble);
					  }
				  }
				  
			} else {
				break;
			}
		}
		buffRead.close();
	}

}
