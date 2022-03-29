package View;

import java.io.BufferedReader;
import java.io.IOException;
import java.security.cert.CRLException;

import Modelos.Produto;
import Util.ListaDeProdutos;

public class View {

	public static int ViewMenuPrincipal(BufferedReader reader) throws NumberFormatException, CRLException, IOException {

		//Menu principal
		
			System.out.println();
			System.out.println("||=o=o=o=o=o MERCADINHO MANGUEIRA o=o=o=o=o=o=||");
			System.out.println("||                                            ||");
			System.out.println("||            [1] para CADASTRAR;");
			System.out.println("||            [2] para LISTAR;");
			System.out.println("||            [3] para DELETAR;");
			System.out.println("||            [4] para EDITAR;");
			System.out.println("||            [5] para SAIR;");
			System.out.println("||                                            ||");
			System.out.println("||=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o||");
			System.out.println();
			System.out.print(  "||-----------------> ");
			
			return Integer.parseInt(reader.readLine());
		
	}

	public static void ViewListaDeProdutosEditada() {
		
		//Pega os atributos do objeto e os exibe para o usuário de maneira organizada na tela
		
		for(Produto p : ListaDeProdutos.getInstance()) {
	
			System.out.println();
			System.out.println("||=o=o=o=o=o RELAÇÃO DE PRODUTOS o=o=o=o=o=o=o||");
			System.out.println("||                                            ||");
			System.out.println("||   Nome do Produto: " + p.getNome());
			System.out.println("||   Categoria: " + p.getCategoria());
			System.out.println("||   Marca: " + p.getMarca().getNome());
			System.out.println("||   Preço: R$ " + p.getMarca().getPreco());
			System.out.println("||                                            ||");
			System.out.println("||- - - - - - - - - - - - - - - - - - - - - - ||");
			System.out.println("||                                            ||");
			System.out.println("||=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o||");
			
		}
	}

	public static String[] ViewMenuSalvarProdutos(BufferedReader reader) throws IOException {
		
		/* 
		 * São criadas dois vetores, um para guardar a "categoria" das informações que serão inseridos pelo usuário
		 * Outro para guardar as informações inseridas em si
		 * */
		
		/* 
		 * O for tem como objetivo verificar os campos do vetor de categoria, enquanto esses campos forem != de vazio
		 * O conteúdo desses campos do vetor serão exibidos para o usuário no console
		 * */
		
		/*
		 * É exibida a "categoria" ao usuário no console e posteriormente ele entra com as informações via teclado
		 * Essas informações são salvas na posição equivalente da categoria no segundo vetor
		 * */
		
		/*
		 * O vetor dadosProdutos é retornado para o método SalvarProduto no CRUD
		 * */
		
		
		String[] menuProdutos = {"   o   Nome do Produto: ...... ", "   o   Categoria: ............ ", "   o   Marca: ................ ","   o   Preço: ................ R$ "};
		String[] dadosProdutos = {"","","",""};
		
		for(int i=0; i < menuProdutos.length; i++) {
			System.out.print(menuProdutos[i]);
			dadosProdutos[i] = reader.readLine();
		}
		
		return dadosProdutos;
	}

	public static void ViewMsgFinal(int op) {
		
		//Mensagens guradadas em um vetor que podem ser exibidas variando das ações do usuário durante a execução do programa
		// TODO Auto-generated method stub
		String[] msgFinal = {"\n"
							+"||=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o||\n"
							+"||- - - - - - - - - - - - - - - - - - - - - - ||\n"
							+"||       CADASTRO REALIZADO COM SUCESSO       ||\n"
							+"||- - - - - - - - - - - - - - - - - - - - - - ||\n"
							+"||=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o||\n",
									 "\n"
									+"||=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o||\n"
									+"||- - - - - - - - - - - - - - - - - - - - - - ||\n"
									+"||       PRODUTO DELETADO COM SUCESSO         ||\n"
									+"||- - - - - - - - - - - - - - - - - - - - - - ||\n"
									+"||=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o||\n",
											 "\n"
											+"||=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o||\n"
											+"||- - - - - - - - - - - - - - - - - - - - - - ||\n"
											+"||       PRODUTO EDITADO COM SUCESSO         ||\n"
											+"||- - - - - - - - - - - - - - - - - - - - - - ||\n"
											+"||=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o||\n",
													 "\n"
													+"||=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o||\n"
													+"||- - - - - - - - - - - - - - - - - - - - - - ||\n"
													+"||               FIM DE PROGRAMA              ||\n"
													+"||- - - - - - - - - - - - - - - - - - - - - - ||\n"
													+"||=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o||\n",};

		System.out.println(msgFinal[op]);
	}

	public static int ViewMenuEditarOuDeletarProduto(String editar_deletar, BufferedReader reader) throws NumberFormatException, IOException{
		
		//Recebe uma string que muda entre editar ou deletar dependendo da escolha do usuário
		//Exibe de maneira organizada os indices dos objetos cadastrados na lista
		
		for(int i = 0; i < ListaDeProdutos.getInstance().size(); i++) {
			System.out.println();
			System.out.println("   o   Índice: ................... " + i + ListaDeProdutos.getInstance().get(i));
		}
		
			System.out.println();
			System.out.println("||----------< Dentre a lista acima, escolha o indice do Produto que deseja " + editar_deletar + " >----------||");
			System.out.println();
			System.out.print(  "||-----------------> ");
			
		return Integer.parseInt(reader.readLine());
	}

	public static String[] ViewOpcaoEdicao(BufferedReader reader) throws IOException{
		// TODO Auto-generated method stub
		
		//Recebe do usuário o tipo do dados que será modificado e as modificações desejadas
		
		String[] infosEditadas = {"",""};
		
		System.out.println();
		System.out.println("||=o=o=o=o=o=o=o=o=o=o=o=o= EDITAR =o=o=o=o=o=o=o=o=o=o=o=o||");
		System.out.println("||                                                         ||");
		System.out.println("||--------< Escolha o Atributo que deseja editar: >--------||");
		System.out.println("||                                                         ||");
		System.out.println("||                   [1] - Nome do Produto                 ||");
		System.out.println("||                   [2] - Categoria                       ||"); 
		System.out.println("||                   [3] - Marca                           ||"); 
		System.out.println("||                   [4] - Preço                           ||"); 
		System.out.println("||                                                         ||");
		System.out.println("||=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=||");
		System.out.println();
		System.out.print(  "||-----------------> ");
		
		infosEditadas[0] = reader.readLine();
		System.out.println();
		System.out.println("||-----------< Digite o novo valor do atributo: >----------||");
		System.out.println();
		System.out.print(  "||-----------------> ");
		System.out.println();
		infosEditadas[1] = reader.readLine();
		
		return infosEditadas;
	}
	
	public static int ViewConfirm(String confirmacao, BufferedReader reader) throws NumberFormatException, IOException{
		
		//Recebe uma string que muda entre editar ou deletar dependendo da escolha do usuário
		
			System.out.println(	 "\n"
								+"||=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=||\n"
								+"||- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -||\n"
								+"||   Tem certeza que deseja" + confirmacao + " esse produto?\n"
								+"||                                                             ||\n"
								+"||                         [1] SIM;                            ||\n"
								+"||                         [2] NÃO;                            ||\n"
								+"||- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -||\n"
								+"||=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=||\n");
			System.out.println();
			System.out.print("||-----------------> ");
			
			
		return Integer.parseInt(reader.readLine());
	}
	
}
