package Modelos;

public class Marca {
	private String nome;
	private double preco;
	
	/*Faz a organização da categoria de cada dado */
	public Marca(String[] dados) {
		
		String[] mar = dados[3].split(":");
		
		this.nome = mar[1].trim();
		this.preco = Double.parseDouble(dados[4].trim());
	}
	
	public Marca() {
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	@Override
	public String toString() {
		return ""
				+"   o   Marca: .................... " + nome + ",\n"
				+"   o   Preço: .................... R$ " + preco + ",\n";
	}
}
