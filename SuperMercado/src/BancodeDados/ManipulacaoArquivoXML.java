package BancodeDados;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import Handler.XMLHandlerProdutos;
import Modelos.Produto;
import Util.ListaDeProdutos;

public class ManipulacaoArquivoXML {
	
	private static String nomeDoArquivo = "RelacãoDeProdutos.xml";//Nome Padrão do Arquivo
	
	public static void SalvarXML() throws ParserConfigurationException, UnsupportedEncodingException, FileNotFoundException, IOException, TransformerException {
		
		//Salva as alterações feitas na lista no arquivo XML
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		DocumentBuilder db = dbf.newDocumentBuilder(); //Construtor de Documentos / Criador de Documentos
		
		Document doc = db.newDocument(); //Cria um novo arquivo
		
		Element prodtag = doc.createElement("Produtos");
		doc.appendChild(prodtag);
		
		
		
		for(Produto a : ListaDeProdutos.getInstance()) {
			Element produtotag = doc.createElement("Produto");
			produtotag.setAttribute("id", "1");
			prodtag.appendChild(produtotag);
			
			Element nometag = doc.createElement("Nome");
			nometag.setTextContent(a.getNome());
			prodtag.appendChild(nometag);
			
			Element categoriatag = doc.createElement("Categoria");
			categoriatag.setTextContent(a.getCategoria());
			prodtag.appendChild(categoriatag);
			
			Element marcatag = doc.createElement("Marca");
			produtotag.appendChild(marcatag);
			
			Element marcanometag = doc.createElement("NomeMarca");
			marcanometag.setTextContent(a.getMarca().getNome());
			marcatag.appendChild(marcanometag);
			
			Element precotag = doc.createElement("Preco");
			precotag.setTextContent(String.valueOf(a.getMarca().getPreco()));
			marcatag.appendChild(precotag);
			
			
		}
		
		TransformerFactory tf = TransformerFactory.newInstance();
		
		Transformer trans = tf.newTransformer();
		
		trans.setOutputProperty(OutputKeys.INDENT, "yes");//Declara que haverá identação no arquivo
		trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");//Tipo da identação
		
		DOMSource source = new DOMSource(doc);
		
		try(OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(nomeDoArquivo),"ISO-8859-1")){
			
			StreamResult result = new StreamResult(osw);
			
			trans.transform(source, result);
			
		}
		
	}
	
	public static void LerArquivoXML () throws ParserConfigurationException, SAXException, UnsupportedEncodingException, FileNotFoundException, IOException {
		
		//Lê o arquivo XML
		
		SAXParserFactory spf = SAXParserFactory.newInstance();//Biblioteca do Parse
		SAXParser parser = spf.newSAXParser();
		
		try(InputStreamReader isr = new InputStreamReader(new FileInputStream(nomeDoArquivo), "ISO-8859-1")){
			
			InputSource source = new InputSource(isr);
			
			XMLHandlerProdutos handler = new XMLHandlerProdutos();
		
			parser.parse(source, handler);
			
		}
		
	}
	
}
