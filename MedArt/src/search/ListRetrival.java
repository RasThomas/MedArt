package search;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ListRetrival {

	private static final String link = "http://eutils.ncbi.nlm.nih.gov/entrez/eutils/efetch.fcgi?db=pubmed&id=";
	private static final String format = "&retmode=xml";


	public static Document findArticles(Document docList) throws IOException, ParserConfigurationException, SAXException, TransformerException {
		Document fullList = null;

		NodeList articleIdList = docList.getElementsByTagName("IdList");
		System.out.println(articleIdList.getLength());

		Node node = articleIdList.item(0);

		if (node.getNodeType() == Node.ELEMENT_NODE) {
			Element element = (Element) node;
			NodeList nodelist = element.getElementsByTagName("Id");
			for (int i = 0; i < 20; i++) { 
				Element element1 = (Element) nodelist.item(i);
				NodeList fstNm = element1.getChildNodes();
				System.out.println("Id : " + (fstNm.item(0)).getNodeValue());
				String idLink = link + (fstNm.item(0)).getNodeValue() + format;
				Document articleDoc = PubMedSearch.commitSearch("",idLink);
			
				try {
					DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
					DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
					
					NodeList articleNode = articleDoc.getElementsByTagName("Article");

						Node nodeArt = articleNode.item(0);
						if (nodeArt.getNodeType() == Node.ELEMENT_NODE) {
							Element elementArt = (Element) nodeArt;
							NodeList nodelist2 = elementArt.getElementsByTagName("ArticleTitle");
							Element element2 = (Element) nodelist2.item(0);
							NodeList fstNm2 = element2.getChildNodes();
							System.out.println("ArticleName : " + (fstNm2.item(0)).getNodeValue());
							NodeList nodelist1 = elementArt.getElementsByTagName("AbstractText");
							Element element3 = (Element) nodelist1.item(0);
							NodeList fstNm3 = element3.getChildNodes();
							System.out.println("Abstract : " + (fstNm3.item(0)).getNodeValue());
						}
					
					
				} catch (ParserConfigurationException pce) {
					pce.printStackTrace();
				}
			}

		}

		return fullList;
	}


}
