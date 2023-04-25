package banco.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import banco.Banco;
import contas.Conta;
import contas.ContaCorrente;
import pessoas.funcionarios.Diretor;

public class EscreverArquivos {

	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yy HH-mm-ss");
	private static LocalDateTime data;

	public static void escreverClientes() throws IOException {
		String path = ".//Relatorios//ListaClientes.txt";
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		for (String conta : Banco.getListaCliente().keySet()) {
			buffWrite.write(Banco.getListaCliente().get(conta).toString());
			buffWrite.newLine();
		}
		buffWrite.close();
	}

	public static void escreverFuncionarios() throws IOException {
		String path = ".//Relatorios//ListaFuncionarios.txt";
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		for (String func : Banco.getListaFuncionarios().keySet()) {
			buffWrite.write(Banco.getListaFuncionarios().get(func).toString());
			buffWrite.newLine();
		}
		buffWrite.close();
	}
	
	public static void escreverAgencias() throws IOException {
		String path = ".//Relatorios//Agencias.txt";
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		for (int numAgencia : Banco.getListaAgencias().keySet()) {
			buffWrite.write(Banco.getListaAgencias().get(numAgencia).toString());
			buffWrite.newLine();
		}
		buffWrite.close();
	}

	public static void listaTransacoes(Conta contaLogada) throws IOException {

			String path = ".//Relatorios//Extratos/Extrato_" + contaLogada.getTitular().getNome() + "_"
					+ dtf.format(LocalDateTime.now()) + ".txt";
			BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
			buffWrite.write(contaLogada.tirarExtratoArquivo());
			buffWrite.newLine();
			buffWrite.close();

	}

	public static void gerarRelatorioTaxas(Conta contaLogada) throws IOException {
		
				String path = ".//Relatorios//Taxas/Taxa_" + contaLogada.getTitular().getNome() + "_"
						+ dtf.format(LocalDateTime.now()) + ".txt";

				BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));

				buffWrite.write(((ContaCorrente)(contaLogada)).tirarRelatorioTaxasArquivo());
				buffWrite.newLine();
				buffWrite.close();
	}

	public static void gerarRelatorioClientesDiretor() throws IOException {
		
		String path = ".//Relatorios//"+ dtf.format(LocalDateTime.now()) + " RelatorioContasDiretor.txt";
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		buffWrite.write(Diretor.gerarRelatorioInfoClientesArquivo());
		buffWrite.newLine();
		buffWrite.close();
	}

}
