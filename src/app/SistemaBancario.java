package app;

import java.util.Iterator;

import banco.Agencia;
import banco.Banco;
import banco.Operacao;
import banco.TipoConta;
import contas.Conta;
import contas.ContaCorrente;
import contas.ContaPoupanca;
import pessoas.Cliente;
import pessoas.Pessoa;
import pessoas.funcionarios.Cargo;
import pessoas.funcionarios.Gerente;
import pessoas.funcionarios.Presidente;

public class SistemaBancario {

	public static void main(String[] args) {
		//------------------------------//
		//		CRIANDO UM NOVO BANCO			//
		//------------------------------//
		
		//Atribuimos o nome do banco com o Set Banco
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
      
		System.out.println("O presidente é " + Banco.getPresidente()); 
		
	//------------------------------//
	//	  CRIANDO UM AGENCIA	    //
	//------------------------------//

	//Para criarmos uma nova agencia precisamos instanciá-la através de:
	// Agencia nomeDaAgencia = new Agencia(numeroDaAgencia, GerenteDaAgencia);
	// Então antes de criarmos de fato uma agencia, precisamos definir qual será o número dela
	// E quem será o gerente dele.

	//Agora vamos dar um número para a agencia
	//Nossa classe Banco conta com um atributo chamado ContadorAgencia
	//O intuito dele é que toda vez que uma nova agencia seja adicionada ao banco
	//esse contador aumente.
	//Vamos pegar esse contador através do get dele;

	//A variavel numeroagencia irá receber o número do contador atual
		int numeroagencia = Banco.getContadorAgencia();
		
		
		//Criando um gerente
		//O construtor de Gerente não é o mesmo de Presidente
		//Construtor do presidente: (nome, CPF, senha, cargo)
		//Mas por que?
		//Porque Gerente precisa ter uma agencia especifica em que ele é resposável
		//Já o presidente não precisa, visto que ele comanda todas as agencias.
		//Construtor de Gerente: Gerente(nome, cpf, senha, Cargo, numeroDaAgencia)
			Gerente G1 = new Gerente("Mariane", "12345678910", 12345, Cargo.GERENTE, numeroagencia);
			System.out.println(G1);
			
	//Testando qual número a variavel numeroagencia pegou;
		System.out.println("O contador agencia é: " + numeroagencia);
		
	//Como não temos nenhuma agencia ai o resultado esperado é que seja 0;
		
	//Agora com o número da agencia e gerente criados, vamos criar uma nova agencia usando
	//o construtor dele
	//Construtor de agencia: Agencia nomeDaAgencia = new Agencia(numeroDaAgencia, GerenteDaAgencia);
		Agencia A1 = new Agencia(numeroagencia, G1);

	//Criamos a agencia, agora precisamos vincular ela ao nosso banco.
	//Para isso iremos utilizar o método addNovaAgencia.
	//Esse método espera que seja passado uma agencia.
		Banco.addNovaAgencia(A1);
	//Agora vá PARA A CLASSE BANCO NO MÉTODO addNovaAgencia(), linha 20;
	
	//---------------------//
	
	//Agora que implementamos o método addNovaAgencia() podemos criar e adicionar quantas agencias
	//quisermos, lembrando sempre de passar um número para a agencia e um gerente.

		//CRIANDO 3 NOVAS AGENCIA USANDO REPETIÇÃO
		for (int i = 0; i < 3; i++) {
			int numeroagencia2 = Banco.getContadorAgencia();
			Gerente G2 = new Gerente("Bruna", "10545698712", 678901, Cargo.GERENTE, numeroagencia2);
			System.out.println("O contador agencia é: " + numeroagencia2);
			Agencia A2 = new Agencia(numeroagencia2, G2);
			Banco.addNovaAgencia(A2);
		}

		//Agora vamos ver se as agencias que criamos estão no HashMap ListaAgencias
		//Podemos fazer isso chamando o método getListaAgencias();
			System.out.println("Lista de Agencias: ");
			System.out.println(Banco.getListaAgencias());

		//Uma outra forma de criarmos novas agencias é sem criarmos a variável numeroagencia
		//Dessa forma passariamos diretor o método Banco.getContadorAgencia() nos locais em que usamos
		//a variável.
			Gerente G3 = new Gerente("Larissa", "1242123213", 13212, Cargo.GERENTE, Banco.getContadorAgencia());
			System.out.println("O contador agencia é: " + Banco.getContadorAgencia());
			Agencia A3 = new Agencia(Banco.getContadorAgencia(), G3);
			Banco.addNovaAgencia(A3);

		//Por fim, imagine que nosso banco cresceu e temos diversas agencias criadas por petrópolis
		//Como saberei a quantidade de agencias que tenho cadastradas?
		//Podemos utilizar o método .size() que é próprio do HashMap
		//Apenas recapitulando:
		//Banco.getListaAgencias() nos tras a lista de agencias, ou mais especificamente, o HashMap com
		//a lista de agencias.
		//Todo algoritmo segue uma ordem de execução: de cima para baixo, da esquerda para direita.
		//Então ele irá executar Banco.getListaAgencias(), retornar o hashmap e então executar .size() dele.
		// Dessa forma podemos saber quantas agencias temos
		System.out.println("O número de agencias é: ");
		System.out.println(Banco.getListaAgencias().size());
		
		//---------------------------//
		//		CRIANDO UMA CONTA 	 	//
		//---------------------------//

		//O construtor de Conta é o seguinte:
		//Conta(Numero da Conta, o titular do tipo Pessoa, saldo, tipo e agencia)
		//Então antes de criarmos a Classe conta, precisamos criar o titular da conta:
		//O Construtor de Pessoa é (nome, cpf, senha, cargo)
		//Pode-se perceber que utilizamos Polimorfismo nos dois casos, ao criarmos uma variavel
		//chamada "pessoa" e definirmos o tipo dela como Pessoa porém instanciamos um tipo Cliente.
		//Em conta, a mesma coisa.
		//Fizemos assim pois será importante no futuro.
		Pessoa pessoa = new Cliente("Joice", "12345678910", 123456, Cargo.CLIENTE);

		ContaCorrente conta = new ContaCorrente(1234, pessoa, 100.50, TipoConta.CONTA_CORRENTE, A3);

		//Após abrirmos uma nova conta, precisamos adicioná-la na agencia e o método addNovaConta faz
		//exatamente isso
		//Ele é responsável por adicionar a conta que criamos na lista de contas que a nossa agencia tem 
		//sob sua responsabilidade.

		A3.addNovaConta(conta);

		//Agora vamos testar se a conta foi realmente adicionada, chamando a lista de contas da agencia
	  System.out.println(A3.getContas());
		//Agora vamos ver quantas contas estão vinculadas a agencia A3
		System.out.println(A3.getNumContas(G3));
		
		//Testando métodos de conta
		conta.sacar(100.00);
		conta.depositar(1000.0);

		//Criando uma nova conta para realizar a transferencia
		Pessoa pessoa2 = new Cliente("Maria", "12345678910", 123456, Cargo.CLIENTE);
		Conta conta2 = new ContaCorrente(1234, pessoa2, 1000.50, TipoConta.CONTA_CORRENTE, A1);

		conta.transferir(conta2, 100.0);

		System.out.println("O saldo da " + conta.getTitular().getNome() + " é: " + String.format("%.2f", conta.getSaldo()));
		System.out.println("O saldo da " + conta2.getTitular().getNome() + " é: " + conta2.getSaldo());
		
		System.out.println(conta.getTransacoes());
		
		conta.TirarRelatorioTaxa();
		conta.tirarExtrato();
		
		ContaPoupanca cp = new ContaPoupanca(7656, pessoa2, 33, TipoConta.CONTA_POUPANCA, A3);
			cp.simularRendimento(2000, 3);
	}

}
