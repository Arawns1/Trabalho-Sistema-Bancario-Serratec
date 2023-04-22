package pessoas.funcionarios;

import banco.Agencia;
import banco.Banco;

public class Diretor extends Gerente{
	
	public Diretor(String nome, String cpf, int senha, Cargo tipo, int numeroAgencia) {
		super(nome, cpf, senha, tipo, numeroAgencia);
	}
	
	public Diretor(String nome, String cpf, int senha, Cargo tipo) {
		super(nome, cpf, senha, tipo);
	}
	
	public void cadastrarGerente() {}
	
	public void gerarRelatorioInfoClientes() 
	{
		
		System.out.println(Banco.getListaCliente());
		//System.out.println(Banco.getListaAgencias().get(1).getContas());
		
		
	};
	
	
	
	@Override
	public String toString() {
		return "Diretor [nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + ", tipo=" + tipo + "]";
	}
}
