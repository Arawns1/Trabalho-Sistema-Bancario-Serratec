package pessoas;

import pessoas.funcionarios.Cargos;

public abstract class Pessoa {
	protected String nome;
	protected String cpf;
	protected int senha;
	protected Cargos tipo;

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

	public Cargos getTipo() {
		return tipo;
	}

	public void setTipo(Cargos tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + ", tipo=" + tipo + "]";
	}
	
}
