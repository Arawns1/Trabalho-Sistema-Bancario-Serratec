package app;

import java.util.Scanner;

import banco.Banco;



public class Menu {
	Scanner sc = new Scanner(System.in);
	public void Login() {
	System.out.println("Bem vindo ao "+ Banco.getNome());
	System.out.println("1. Cliente");
	System.out.println("2. Painel Administrativo");
	System.out.println("Digite uma Opção");
	int escolha = sc.nextInt();
	
	if(escolha == 1) {
		fazerLoginCliente();
		
	}
	
	else if(escolha==2) {
		fazerLoginAdministrativo();
	}
	else {
		System.out.println("Opção Inválida, tente novamente");
		Login();
		
	}
	
	}
	
	public void fazerLoginCliente(); {
		System.out.println("Faça seu Login: ");
		System.out.println("Digite seu CPF: ");
		String cpf = sc.next();
		System.out.println("Digite sua Senha: ");
		int senha=sc.nextInt();
		
		
	}
		
	}
	
	public void fazerLoginAdministrativo(); {
		
	}
	
	public void mostrarOpcoes (); {
		
	

}