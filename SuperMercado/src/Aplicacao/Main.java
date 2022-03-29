package Aplicacao;
import java.io.BufferedReader; //Importação da classe responsável por preparar os dados a serem enviados ou guardados
import java.io.IOException; //Importação da classe para exceções geradas ao acessar informações usando fluxos, arquivos e diretórios
import java.io.InputStreamReader; //Importação da classe responsável por captar o que é inserido e enviar para o buffer
import java.security.cert.CRLException;
import java.util.ArrayList; //Importação da classe responsável por gerar uma lista expansível de vetores
import java.util.List; //Importação da classe responsável por gerar uma lista 

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import Modelos.Produto;//Importação da classe encontrada em outro pacote
import View.View;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException, CRLException, ParserConfigurationException, TransformerException, SAXException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		List<Produto> ListaDeProdutos = new ArrayList<Produto>();
		
		int menu = 0;
		
		//Maneja as escolhas do usuário dentro das possibilidades oferecidas eplo programa
		
		while(menu != 5) {
		
			menu = View.ViewMenuPrincipal(reader);
			
			try {
				
				switch(menu) {
				
				case 1:
					ListaDeProdutos.add(CRUDProd.SalvarProduto(reader));
					break;
				case 2:
					CRUDProd.ListarProdutos();
					break;
				case 3:
					CRUDProd.DeletarProduto(reader);
					break;
				case 4:
					CRUDProd.EditarProduto(reader);
					break;
				case 5:
					View.ViewMsgFinal(3);
					break;
				}
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
		}
		
	}
}
