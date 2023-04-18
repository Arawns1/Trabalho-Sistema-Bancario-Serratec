package app;

import java.util.Iterator;

import banco.Agencia;
import banco.Banco;
import banco.TipoConta;
import contas.Conta;
import contas.ContaCorrente;
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
		//		CRIANDO UMA CONTA 	 //
		//---------------------------//
		Pessoa pessoa = new Cliente("Joice", "12345678910", 123456, Cargo.CLIENTE);
		Conta conta = new ContaCorrente(1234, pessoa, 100.50, TipoConta.CONTA_CORRENTE, A3);
		A3.addNovaConta(conta);
	    A3.getContas();
		System.out.println(A3.getNumContas(G3));
		
	}

}
