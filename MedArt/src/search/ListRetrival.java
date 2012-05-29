package search;  



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

	private static final String link = "http://eutils.ncbi.nlm.nih.gov/entrez/eutils/esummary.fcgi?db=pubmed&id=";
	private static final String format = "&retmode=xml";
	private static final String version = "&&version=2.0";


	public static Document findArticles(Document docList) throws IOException, ParserConfigurationException, SAXException, TransformerException {
		Document doc = null;

		NodeList articleIdList = docList.getElementsByTagName("IdList");
		System.out.println(articleIdList.getLength());

		Node node = articleIdList.item(0);
		List<String> idListe = new ArrayList<String> ();
		String id = "";
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			//			Element element = (Element) node;
			NodeList nodelist = docList.getElementsByTagName("Id");
			for (int i = 0; i < 20; i++) { 
				Element element1 = (Element) nodelist.item(i);
				NodeList fstNm = element1.getChildNodes();
				System.out.println("Id : " + (fstNm.item(0)).getNodeValue());
				id = id	+ (fstNm.item(0)).getNodeValue() + ",";
				String tester = record.Article.matchArticleNumber( Integer.valueOf((fstNm.item(0)).getNodeValue()));
				idListe.add(tester); 

			}
			id = id.substring(0, id.length()-1);

			String idLink = link + id + format + version;
			System.out.println(idLink);
			Document articleDoc = CommitSearch.commitSearch(idLink);

			NodeList idList = articleDoc.getElementsByTagName("DocumentSummary");
			System.out.println(idList.getLength());

			for(int i=0;i<idList.getLength();i++)
			{
				Node idNode = idList.item(i);

				Element ArticleID = articleDoc.createElement("ArticleID");

				ArticleID.appendChild(articleDoc.createTextNode(idListe.get(i)));

				idNode.appendChild(ArticleID);		    		   		    		   
			}

			PubMedSearch.printFile(articleDoc, "ArticleList.txt");

			//			try {
			//				DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			//				DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			//				
			//				doc = docBuilder.newDocument();
			//				Element rootElement = doc.createElement("Search");
			//				doc.appendChild(rootElement);
			//
			//				NodeList countList = docList.getElementsByTagName("Count");
			//				Node venueNode = countList.item(0);
			//				Element count2 = (Element) venueNode;
			//				Element count = doc.createElement("Count");
			//				count.appendChild(doc.createTextNode("yong"));
			//				rootElement.appendChild(count);
			//
			//				NodeList maxList = docList.getElementsByTagName("RetMax");
			//				Element max = (Element) maxList.item(0);
			//				NodeList fstNm4 = max.getChildNodes();
			//				System.out.println("ArticleName : " + (countList.item(0).getNodeValue()));
			//				NodeList startList = docList.getElementsByTagName("Count");
			//
			//
			//				System.out.println(docList.getElementsByTagName("RetStart").getLength());
			//
			//				NodeList articleNode = articleDoc.getElementsByTagName("DocumentSummary");
			//				int size = articleDoc.getElementsByTagName("DocumentSummary").getLength();
			//
			//				for (int i = 0; i < size; i++) {
			//					Node nodeArt = articleNode.item(i);
			//					if (nodeArt.getNodeType() == Node.ELEMENT_NODE) {
			//						Element elementArt = (Element) nodeArt;
			//						NodeList nodelistTitle = elementArt.getElementsByTagName("Title");
			//						Element elementTitle = (Element) nodelistTitle.item(0);
			//						NodeList fstNm2 = elementTitle.getChildNodes();
			////						System.out.println("ArticleName : " + (fstNm2.item(0)).getNodeValue());
			//						NodeList nodelistAbstract = elementArt.getElementsByTagName("Attributes");
			//						Element elementAbstract = (Element) nodelistAbstract.item(0);
			//						//Not all documents have an abstract
			//						if(elementAbstract != null) {
			//							NodeList fstNm3 = elementAbstract.getChildNodes();
			////							System.out.println("Abstract : " + (fstNm3.item(0)).getNodeValue());
			//						}
			//					}
			//
			//				}
			//			} catch (ParserConfigurationException pce) {
			//				pce.printStackTrace();
			//			}
		}



		return doc;
	}
	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, TransformerException {

		Document test = PubMedSearch.pubMedSearch("Stent Chest Pain", "0", "20");
		Document test2 = ListRetrival.findArticles(test);
		//		printFile(test, "Search.txt");
		//		GetArticleInfo.articleInfo("22562999");




	}

}
