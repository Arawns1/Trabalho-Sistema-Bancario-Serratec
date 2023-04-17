package pessoas;
//TODO descomentar Cargos apos criação de Enum
public abstract class Pessoa {
	private String nome;
	private String cpf;
	private int senha;
	//private Cargos tipo;
	
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome; 
	}
	
	
	public String getCpf() {
		return this.cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf; 
	}
	
	public int getSenha() {
		return this.senha;
	}
	public void setSenha(int senha) {
		this.senha = senha; 
	}
	
	
	//public Cargos getTipo() {
		//return this.tipo;
//	}
	//public void setCargos(Cargos tipo) {
		//this.tipo = tipo; 
	//}

}
