package pessoas;

public abstract  class Funcionario {
	private String nome;
	private String cpf;
	private double salario;
	private String Matricula;
	public String Cargo;
	private int Senha;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getMatricula() {
		return Matricula;
	}

	public void setMatricula(String matricula) {
		Matricula = matricula;
	}
	public String toString() {
		return "Nome =" this.nome + ", Cargo =" + Cargo + ", CPF =" + this.cpf + ", salario=" + this.salario
				
				+ ", Matricula=" + this.Matricula + "Cargo:" this.Cargo;}
	
	
	
