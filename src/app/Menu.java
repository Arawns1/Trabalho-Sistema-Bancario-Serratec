package app;

import java.util.Scanner;

import banco.Banco;
import banco.TipoConta;
import contas.Conta;
import contas.ContaCorrente;
import pessoas.Cliente;
import pessoas.Pessoa;
import pessoas.funcionarios.Cargo;
import pessoas.funcionarios.Funcionario;
import pessoas.funcionarios.Gerente;

public class Menu {
	Scanner sc = new Scanner(System.in);

	public void Login() {
		System.out.println("Bem vindo ao " + Banco.getNome());
		System.out.println("1. Cliente");
		System.out.println("2. Painel Administrativo");
		System.out.println("Digite uma Opção:");
		int escolha = sc.nextInt();

		if (escolha == 1) {
			fazerLoginCliente();

		}

		else if (escolha == 2) {
		 fazerLoginAdministrativo();
		} else {
			System.out.println("Opção Inválida, tente novamente!");
			Login();

		}

	}

	public void fazerLoginCliente() {
		Pessoa p = new Cliente("Nelson", "1234", 1234, Cargo.CLIENTE);
		ContaCorrente cc = new ContaCorrente(5463, p, 1020.1, TipoConta.CONTA_CORRENTE, null);
		System.out.println("Faça seu Login ");
		System.out.println("Digite seu CPF: ");
		String cpf = sc.next();
		System.out.println("Digite sua Senha: ");
		int senha = sc.nextInt();
		if (Cliente.listaCliente.containsKey(cpf)) {
			System.out.println("Cpf existe");
			if (Cliente.listaCliente.get(cpf).getTitular().getSenha() == senha) {
				System.out.println("Acesso Permitido!");
				mostrarOpcoesClientes(Cliente.listaCliente.get(cpf));
			} else {
				System.out.println("Senha incorreta!");
			}
		} else {
			System.out.println("CPF não identificado");
		}

	}

	public void fazerLoginAdministrativo() {
		Funcionario Melson = new Gerente("Melson", "1", 1,Cargo.DIRETOR, 123); 
		System.out.println("Faça seu Login ");
		System.out.println("Digite seu CPF: ");
		String cpf = sc.next();
		System.out.println("Digite sua Senha: ");
		int senha = sc.nextInt();
		if (Funcionario.listaFuncionarios.containsKey(cpf)) {
			if (Funcionario.listaFuncionarios.get(cpf).getSenha() == senha) {
				System.out.println("Acesso Permitido!");
				System.out.println(Funcionario.listaFuncionarios.get(cpf).getTipo());
			} else {
				System.out.println("Senha incorreta!");
			}
		} else {
			System.out.println("CPF não identificado");
		}
	}

	public void mostrarOpcoesClientes(Conta contaLogada) {
		
	int opcao = 0;
	do {
		System.out.println("Olá " + contaLogada.getTitular().getNome() + ", Seja Bem-Vindo!");
		System.out.println("\n MENU DO CLIENTE \n");
		System.out.println("1. Movimentações na conta.");
		System.out.println("2. Relatórios.");
		System.out.println("3. Sair. \n");
		System.out.println("Digite sua opção: ");
		opcao = sc.nextInt();
		switch (opcao) {
		case 1:
			movimentacoesConta(contaLogada);
			break;
			
			
		}
	}while (opcao  != 3);
	
		
		
	}
	
	public void movimentacoesConta(Conta contaLogada) {
		System.out.println("\n MOVIMENTAÇÕES NA CONTA \n");
		System.out.println("1. Saque.");
		System.out.println("2. Depósito.");
		System.out.println("3. Transferência para outra conta.");
		System.out.println("4. Extrato.");
		System.out.println("5. Voltar ao Menu principal. ");
		System.out.println("Digite sua opção:");
		int opcao = sc.nextInt();
		switch (opcao) {
		case 1: 
			System.out.println(contaLogada.getSaldo());
			System.out.println("Digite o valor do saque: ");
			double valorSaque = sc.nextDouble();
			contaLogada.sacar(valorSaque);
			break;
		case 2:
			System.out.println("Digite o valor do depósito: ");
			double valorDeposito = sc.nextDouble();
			contaLogada.depositar (valorDeposito);
			break;
			
		case 3:
			System.out.println("Digite o CPF do destinatário: ");
			String CPF = sc.next();
			if (Cliente.listaCliente.containsKey(CPF)){
				System.out.println("Digite o valor da transferência: ");
				double valorTransferencia = sc.nextDouble();
				contaLogada.transferir(Cliente.listaCliente.get(CPF), valorTransferencia);
			}else {
				System.out.println("CPF do destintário não encontrado ");
			}
			break;
		
		case 4:
			contaLogada.tirarExtrato();
			break;
		
		}
	}
	
	public void mostrarOpcoesFuncionarios() {
		
	}
}
