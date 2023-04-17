package pessoas.funcionarios;

public class Diretor extends Gerente{
	
	public void gerarRelatorioInfoClientes() {};
	public void cadastrarGerente() {}
	@Override
	public String toString() {
		return "Diretor [nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + ", tipo=" + tipo + "]";
	}
}
