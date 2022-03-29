package Modelos;

public class Produto {
	private String categoria;
	private String nome;
	private Marca marca;
	
	/*Faz a organização da categoria de cada dado */
	public Produto(String dados) {
		String[] atributos = dados.split(",");
		String[] nome = atributos[1].split(":");
		String[] categoria = atributos[2].split(":");
		
		Marca marcas = new Marca(atributos);
		
		this.nome = nome[1].trim();
		this.categoria = categoria[2].trim();
		this.marca = marcas;
		
	}
	
	public Produto() {
	}
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	@Override
	public String toString() {
		return 	 ",\n"
				+"   o   Nome do Produto: .......... " + nome + ",\n"
				+"   o   Categoria: ................ " + categoria + ",\n"
				+marca;
	}
}
