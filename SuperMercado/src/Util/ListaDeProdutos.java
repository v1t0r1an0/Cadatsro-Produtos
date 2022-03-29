package Util;

import java.util.ArrayList;
import java.util.List;

import Modelos.Produto;

public class ListaDeProdutos {

	/*Cria uma lista de objetos para armazenar os objetos produto*/
	private static List<Produto> ListaDeProdutos = new ArrayList<Produto>();
	
	public static List<Produto> getInstance() {
		
		return ListaDeProdutos;
		
	}
	
}
