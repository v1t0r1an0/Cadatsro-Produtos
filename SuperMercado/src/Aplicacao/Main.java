package Aplicacao;
import java.io.BufferedReader; //Importa��o da classe respons�vel por preparar os dados a serem enviados ou guardados
import java.io.IOException; //Importa��o da classe para exce��es geradas ao acessar informa��es usando fluxos, arquivos e diret�rios
import java.io.InputStreamReader; //Importa��o da classe respons�vel por captar o que � inserido e enviar para o buffer
import java.security.cert.CRLException;
import java.util.ArrayList; //Importa��o da classe respons�vel por gerar uma lista expans�vel de vetores
import java.util.List; //Importa��o da classe respons�vel por gerar uma lista 

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import Modelos.Produto;//Importa��o da classe encontrada em outro pacote
import View.View;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException, CRLException, ParserConfigurationException, TransformerException, SAXException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		List<Produto> ListaDeProdutos = new ArrayList<Produto>();
		
		int menu = 0;
		
		//Maneja as escolhas do usu�rio dentro das possibilidades oferecidas eplo programa
		
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
