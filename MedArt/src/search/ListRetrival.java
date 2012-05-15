package search;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ListRetrival {

	private static final String link = "http://eutils.ncbi.nlm.nih.gov/entrez/eutils/efetch.fcgi?db=pubmed&id=";
	private static final String format = "&retmode=xml";

	
	public static Document findArticles(Document docList) {
		Document fullList = null;
		
		NodeList articleIdList = docList.getElementsByTagName("Id");
		System.out.println(articleIdList.getLength());
		for (int i = 0; i < articleIdList.getLength(); i++) { 
			Node node = articleIdList.item(i);
			
			System.out.println("ID : " + (node.getNodeValue()));
			
			
		  }
		
		return fullList;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
