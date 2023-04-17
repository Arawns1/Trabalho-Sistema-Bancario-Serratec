package app;

import banco.Agencia;
import banco.Banco;
import contas.Conta;
import pessoas.funcionarios.Cargo;
import pessoas.funcionarios.Gerente;
import pessoas.funcionarios.Presidente;

public class SistemaBancario {

	public static void main(String[] args) {
		//Atribuimos o nome do banco de Set Banco
		Banco.setNome("G5 bank");
		//Escrever o nome do banco na tela
		System.out.println(Banco.getNome());
		
		//Criando um novo presidente com construtor
		//Construtor do presidente: (nome, CPF, senha, cargo)
		Presidente presidente = new Presidente("Gabriel", "11154378900", 234532, Cargo.PRESIDENTE);
		
		//Definindo o presidente do banco.
        Banco.setPresidente(presidente); 
       
        //Como criamos com o construtor não precisamos utilizar os sets abaixo.
		
        /*
		 * presidente.setNome("Gabriel"); 
		 * presidente.setCpf("11154378900");
		 * presidente.setTipo(Cargo.PRESIDENTE); 
		 * presidente.setSenha(234532);
		 */
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
