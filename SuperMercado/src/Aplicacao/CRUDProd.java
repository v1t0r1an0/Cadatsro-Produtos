package Aplicacao;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.cert.CRLException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import BancodeDados.ManipulacaoArquivoTXT;
import BancodeDados.ManipulacaoArquivoXML;
import Modelos.Marca;
import Modelos.Produto;
import Util.ListaDeProdutos;
import View.View;

public class CRUDProd {
	
	public static Produto SalvarProduto (BufferedReader reader) throws IOException, ParserConfigurationException, TransformerException{
		/*
		 * Basicamente salva as informações feitas pelo usuário via teclado
		 * guarda essas informações em uma posição de um vetor e passa o vetor
		 * para os atributos do objeto através do set
		 */	
		
		System.out.println();
		
		Produto produto = new Produto();
		Marca marca = new Marca();
		
		String[] dadosProdutos = View.ViewMenuSalvarProdutos(reader);
		
		produto.setNome(dadosProdutos[0]);
		produto.setCategoria(dadosProdutos[1]);
		marca.setNome(dadosProdutos[2]);
		marca.setPreco(Double.parseDouble(dadosProdutos[3]));
		produto.setMarca(marca);
		
		ListaDeProdutos.getInstance().add(produto);
		
		ManipulacaoArquivoTXT.SalvarArquivoTXT();
		ManipulacaoArquivoXML.SalvarXML();
		
		View.ViewMsgFinal(0);
		
		return produto;
		
	}
	
	
	public static void ListarProdutos() throws FileNotFoundException, IOException, ParserConfigurationException, SAXException{
		
		/*
		 * Cria uma lista de objetos para guaradar os objetos produto cadastrados
		 * Lê o arquivo XML e realiza a uma listagem editada dos objetos e seus atributos
		 * */
		
		ListaDeProdutos.getInstance().clear();//Faz parte do array list, toda vez que uma lista de objetos é criada, ele apaga todos os objetos dentro da lista
		ManipulacaoArquivoXML.LerArquivoXML();
		View.ViewListaDeProdutosEditada();
	}
	
	public static void DeletarProduto(BufferedReader reader) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException, CRLException, SAXException {

		/*
		 * Realiza uma listagem de todos os objetos da lista e define indices para cada um deles
		 * Atraves dos indices o usuario seleciona qual deseja excluir
		 * Os arquivos XML e TXT são salvos com as exclusões
		 * */
		
		int indice = View.ViewMenuEditarOuDeletarProduto("deletar", reader);
	
		int confirm = View.ViewConfirm(" DELETAR ", reader);
		
		if(confirm == 1) {
			
			ListaDeProdutos.getInstance().remove(indice);
			ManipulacaoArquivoTXT.SalvarArquivoTXT();
			ManipulacaoArquivoXML.SalvarXML();
			
			View.ViewMsgFinal(1);
			
		}else if(confirm == 2) {
			
			Main.main(null);
			
		}

	}
	
	public static void EditarProduto(BufferedReader reader) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException, CRLException, SAXException {
		
		/*
		 * Realiza uma listagem de todos os objetos da lista e define indices para cada um deles
		 * Atraves dos indices o usuario seleciona qual deseja editar
		 * Um vetor guarda a "categoria" da nova informação e a nova informação em si inserida pelo usuário
		 * São listados os atributos do objeto que o usuário selecionou anteriormente
		 * O usuário entra com os novos valores para o atributo selecionado
		 * Os arquivos XML e TXT são salvos
		 * */
		
		int indice = View.ViewMenuEditarOuDeletarProduto("editar", reader);
		
		int confirm = View.ViewConfirm(" EDITAR ", reader);
		
		if(confirm == 1) {
			
			Produto produto = ListaDeProdutos.getInstance().get(indice);
			
			String[] infosEditadas = {"",""};
			
			infosEditadas = View.ViewOpcaoEdicao(reader);
			
			switch(Integer.parseInt(infosEditadas[0]))
			{
			
				case 1:
					produto.setNome(infosEditadas[1]);
					break;
				case 2:
					produto.setCategoria(infosEditadas[1]);
					break;
				case 3:
					produto.getMarca().setNome(infosEditadas[1]);
				break;
				case 4:
					produto.getMarca().setPreco(Double.parseDouble(infosEditadas[1]));
					break;
			
			}
			
			ListaDeProdutos.getInstance().set(indice, produto);
			
			ManipulacaoArquivoTXT.SalvarArquivoTXT();
			ManipulacaoArquivoXML.SalvarXML();
			
			View.ViewMsgFinal(1);
			
		}else if(confirm == 2) {
			
			Main.main(null);
			
		}
		
	}
	
}
