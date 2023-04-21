package app;

import java.util.Scanner;

import banco.Banco;
import banco.TipoConta;
import contas.Conta;
import contas.ContaCorrente;
import contas.ContaPoupanca;
import pessoas.funcionarios.Funcionario;

public class Menu {
	Scanner sc = new Scanner(System.in);

	public void mostrarLogo() {
		/*
		 * System.out.println("\r\n" +
		 * " ██████  ███████  █████  ███  ██    █ █  █    \r\n" +
		 * "██       ██       █   █ █   █ ███   █ █  █     \r\n" +
		 * "██   ███ ██████   ████  █████ █ ██  █ ███       \r\n" +
		 * "██    ██      ██  █   █ █   █ █  ██ █ █  █      \r\n" +
		 * " ██████  ██████   ████  █   █ █   ███ █   █    \r\n");
		 */

		System.out.print("\r\n" + "██████████████████████████████████████████" + "\r\n"
				+ "██      ██       █████████████████████████" + "\r\n" + "█  ███████  ███████ ██████████████████████"
				+ "\r\n" + "█  ███   █      ███    ███    ██   ██ ██ █" + "\r\n"
				+ "█  ████  ██████  ██ ███ █ ███ ██ ██ █   ██" + "\r\n" + "██      ██      ███    ███   █ █ ██ █ ██ █"
				+ "\r\n" + "██████████████████████████████████████████" + "\r\n"
				+ "███ O BANCO QUE IMPULSIONA SEUS SONHOS! ██" + "\r\n" + "██████████████████████████████████████████"
				+ "\r\n");
		/*
		 * System.out.println("\r\n" +
		 * "  ██████  ███████                           \r\n" +
		 * " ██       ██       █                        \r\n" +
		 * " ██   ███ ██████   ████   ████  ███  █  █       \r\n" +
		 * " ██    ██      ██  █   █ █   █  █  █ ███        \r\n" +
		 * "  ██████  ██████   ████   ███ █ █  █ █  █    \r\n");
		 */
	}

	public void Login() {
		int escolha = 0;
		do {
			mostrarLogo();
			System.out.println("-".repeat(40));
			System.out.println("\tBEM-VINDO(A) AO G5 BANK");
			System.out.println("-".repeat(40));

			System.out.println("|-> 1. Clientes");
			System.out.println("|-> 2. Painel Administrativo");
			System.out.print("| Digite uma Opção: ");

			escolha = sc.nextInt();
			if (escolha == 1) {
				fazerLoginCliente();
			} else if (escolha == 2) {
				fazerLoginAdministrativo();
			} else {
				System.out.println("|❌ Opção Inválida, tente novamente!");
			}
			System.out.println("=".repeat(40));
			System.out.println(" Obrigado por utilizar nossos serviços!");
			System.out.println("\t\tG5 BANK ©");
			System.out.println("=".repeat(40));
		} while (escolha != 1 || escolha != 2);

	}

	public void fazerLoginCliente() {
		System.out.println("-".repeat(40));
		System.out.println("\t    LOGIN CLIENTES");
		System.out.println("-".repeat(40));
		// Pegando dados do Cliente
		System.out.println("FAÇA LOGIN ");
		System.out.println("|-> Digite seu CPF (apenas números) ");
		System.out.print("| CPF: ");
		String cpf = sc.next();
		System.out.println("|-> Digite sua Senha: ");
		System.out.print("| Senha: ");
		int senha = sc.nextInt();

		// Verificando na listaCliente se ela contém o CPF e se a Senha digitada está
		// correta.
		if (Banco.getListaCliente().containsKey(cpf)) {
			if (Banco.getListaCliente().get(cpf).getTitular().getSenha() == senha) {
				mostrarOpcoesClientes(Banco.getListaCliente().get(cpf));
			} else {
				System.out.println("|⚠ Senha incorreta, tente novamente!");
			}
		} else {
			System.out.println("|⚠ CPF não identificado");
		}
	}

	public void fazerLoginAdministrativo() {
		System.out.println("-".repeat(40));
		System.out.println("\t  LOGIN ADMINISTRATIVO");
		System.out.println("-".repeat(40));
		// Pegando dados do Funcionário
		System.out.println("FAÇA LOGIN ");
		System.out.println("|-> Digite seu CPF (apenas números) ");
		System.out.print("| CPF: ");
		String cpf = sc.next();
		System.out.println("|-> Digite sua Senha: ");
		System.out.print("| Senha: ");
		int senha = sc.nextInt();
		if (Banco.getListaFuncionarios().containsKey(cpf)) {
			if (Banco.getListaFuncionarios().get(cpf).getSenha() == senha) {
				System.out.println("Acesso Permitido!");
				mostrarOpcoesFuncionarios(Banco.getListaFuncionarios().get(cpf));
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
			System.out.println("-".repeat(40));
			System.out.println("\t   MENU PRINCIPAL");
			System.out.println("-".repeat(40));
			System.out.println("| Olá " + contaLogada.getTitular().getNome() + ", seja bem-vindo!");
			System.out.println("+");
			System.out.println("| O que deseja fazer?");
			System.out.println("|-> 1. Movimentações na conta.");
			System.out.println("|-> 2. Relatórios.");
			System.out.println("|-> 3. Sair.");
			System.out.println("+");
			System.out.print("| Digite sua opção: ");
			opcao = sc.nextInt();
			switch (opcao) {
			case 1:
				movimentacoesContaCliente(contaLogada);
				break;
			case 2:
				relatoriosContaCliente(contaLogada);
				break;
			case 3:
				break;
			default:
				System.out.println("|❌ Opção Inválida, tente novamente!");
				break;
			}
		} while (opcao != 3);
	}

	public void movimentacoesContaCliente(Conta contaLogada) {
		int opcao = 0;
		do {
			System.out.println("-".repeat(40));
			System.out.println("\tMOVIMENTAÇÕES NA CONTA");
			System.out.println("-".repeat(40));
			System.out.println("| Seu saldo é: R$" + String.format("%.2f", contaLogada.getSaldo()));
			System.out.println("+");
			System.out.println("|-> 1. Saque.");
			System.out.println("|-> 2. Depósito.");
			System.out.println("|-> 3. Transferência para outra conta.");
			System.out.println("|-> 4. Extrato.");
			System.out.println("|-> 5. Voltar ao Menu principal. ");
			System.out.println("+");
			System.out.print("| Digite sua opção: ");
			opcao = sc.nextInt();
			switch (opcao) {
			case 1:
				System.out.println("+- SAQUE -+");
				System.out.print("|-> Digite o valor do saque: R$");
				double valorSaque = sc.nextDouble();
				contaLogada.sacar(valorSaque);
				break;
			case 2:
				System.out.println("+- DEPÓSITO -+");
				System.out.print("|-> Digite o valor do depósito: R$");
				double valorDeposito = sc.nextDouble();
				contaLogada.depositar(valorDeposito);
				break;

			case 3:
				System.out.println("+- TRANSFERÊNCIA -+");
				System.out.println("|-> Digite o CPF do destinatário (apenas números)");
				System.out.print("| CPF: ");
				String CPF = sc.next();
				if (Banco.getListaCliente().containsKey(CPF) && !CPF.equals(contaLogada.getTitular().getCpf()) ) {
					System.out.println("|-> Digite o valor da transferência");
					System.out.print("| Valor: R$");
					double valorTransferencia = sc.nextDouble();
					contaLogada.transferir(Banco.getListaCliente().get(CPF), valorTransferencia);
				} else {
					System.out.println("Não foi possível transferir para esse CPF");
				}
				break;

			case 4:
				contaLogada.tirarExtrato();
				break;
			case 5:
				break;
			default:
				System.out.println("|❌ Opção Inválida, tente novamente!");
				break;

			}
		} while (opcao != 5);
	}

	public void relatoriosContaCliente(Conta contaLogada) {
		System.out.println("-".repeat(40));
		System.out.println("\t      RELATÓRIOS");
		System.out.println("-".repeat(40));
		System.out.println("|-> 1. Ver saldo e informações da conta");
		
		if (contaLogada.getTipo() == TipoConta.CONTA_CORRENTE) {
			System.out.println("|-> 2. Relatório de Tributações.");

		} else {
			System.out.println("|-> 2. Relatório de Rendimentos.");
		}
		System.out.println("|-> 3. Voltar ao Menu principal.");
		System.out.println("+");
		System.out.print("| Digite uma opção: ");
		int escolha = sc.nextInt();
		System.out.println("+");
		switch (escolha) {
		case 1:
			System.out.println("| Seu saldo é: R$" + String.format("%.2f", contaLogada.getSaldo()));
			System.out.println("| Sua Agência é: " + contaLogada.getAgencia().getNumero());
			System.out.println("| O número da sua conta é: " + contaLogada.getNumero());
			break;
		case 2:
			if (contaLogada.getTipo() == TipoConta.CONTA_CORRENTE) {
				((ContaCorrente)(contaLogada)).tirarRelatorioTaxa();
			}
			else {
				System.out.println("|-> Digite um valor para ser simulado ");
				System.out.print("| Valor: R$ ");
				double valor = sc.nextDouble();
				System.out.println("|-> Digite a quantidade de dias que deseja deixa esse dinheiro render ");
				System.out.print("| Quantidade dias: ");
				int dias = sc.nextInt();
				System.out.println("+");
				((ContaPoupanca)(contaLogada)).simularRendimento(valor, dias);
				
			}

			break;
		case 3:

			break;

		default:
			break;
		}

	}

	public void mostrarOpcoesFuncionarios(Funcionario funcionario) {
		switch (funcionario.getTipo()) {
		case GERENTE:
			System.out.println("|-> 1. Gerar Relatório Contas da Agencia");
			System.out.println("|-> 2. Sair");
			System.out.println("| Digite uma opção: ");
			break;
		case DIRETOR:
			System.out.println("TU É DIRETOR");
			break;
		case PRESIDENTE:
			System.out.println("TU É PRESIDENTE");
			break;

		default:
			break;
		}
	}
}
