package app;

import banco.Agencia;
import banco.Banco;
import contas.Conta;
import pessoas.funcionarios.Cargo;
import pessoas.funcionarios.Gerente;
import pessoas.funcionarios.Presidente;

public class SistemaBancario {

	public static void main(String[] args) {
		Banco.setNome("G5 bank");
		System.out.println(Banco.getNome());
		
		Presidente presidente = new Presidente("Gabriel", "11154378900", 234532, Cargo.PRESIDENTE);
        Banco.setPresidente(presidente); 
		presidente.setNome("Gabriel");
		presidente.setCpf("11154378900");
		presidente.setTipo(Cargo.PRESIDENTE);
		presidente.setSenha(234532);
		System.out.println(Banco.getPresidente()); 
		
		int numeroagencia = Banco.getNumeroAgencias();
		System.out.println(numeroagencia);
		Gerente G1 = new Gerente("Mariane", "12345678910", 12345, Cargo.GERENTE, numeroagencia);
		System.out.println(G1);
		
		Agencia A1 = new Agencia(numeroagencia, G1);
		Banco.addNovaAgencia(A1);
		System.out.println(A1);
		
	}

}
