package BancodeDados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import Modelos.Produto;
import Util.ListaDeProdutos;

public class ManipulacaoArquivoTXT {
	
	private static String nomeDoArquivo = "RelaçãoDeProdutos.txt";

	public static void SalvarArquivoTXT() throws IOException{
		
		//Salva as alterações feitas na lista no arquivo TXT
		
		try (BufferedWriter buffer = new BufferedWriter(new FileWriter(nomeDoArquivo));
				PrintWriter pw = new PrintWriter(buffer)) {
			for (Produto p : ListaDeProdutos.getInstance())
				pw.println(p);
		}	
	}
	
	
	public static void LerArquivoTXT() throws IOException {
		
		//Lê o arquivo txt
		
		String line;
		
		try (FileWriter arq = new FileWriter(nomeDoArquivo,true)){};

		try (BufferedReader reader = new BufferedReader(new FileReader(nomeDoArquivo))) {

			while ((line = reader.readLine()) != null && !"".equals(line)) {
					Produto produto = new Produto(line);
					ListaDeProdutos.getInstance().add(produto);
			}
		} 
		
	}

}
