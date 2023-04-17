package app;

import banco.Banco;
import contas.Conta;
import pessoas.funcionarios.Cargo;
import pessoas.funcionarios.Presidente;

public class SistemaBancario {

	public static void main(String[] args) {
		Banco.setNome("G5 bank");
		System.out.println(Banco.getNome());
		
		Presidente presidente = new Presidente();
        Banco.setPresidente(presidente); 
		presidente.setNome("Gabriel");
		presidente.setCpf("11154378900");
		presidente.setTipo(Cargo.PRESIDENTE);
		presidente.setSenha(234532);
		System.out.println(Banco.getPresidente()); 
		
		
	}

}
