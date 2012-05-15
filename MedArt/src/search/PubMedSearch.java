package search;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import search.ListRetrival;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class PubMedSearch {
	private static final String link = "http://eutils.ncbi.nlm.nih.gov/entrez/eutils/esearch.fcgi?db=pubmed&term=";

	public static Document commitSearch(String searchTerm, String searchLink) throws IOException, ParserConfigurationException, SAXException, TransformerException	{

		String search = searchLink + searchTerm.replace(" ", "+");
		URL url = new URL(search);
		URLConnection conn = url.openConnection();

		DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
		domFactory.setNamespaceAware(true);
		DocumentBuilder builder = domFactory.newDocumentBuilder();
		Document doc = builder.parse(conn.getInputStream());

		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");

		StreamResult result = new StreamResult(new StringWriter());
		DOMSource source = new DOMSource(doc);
		transformer.transform(source, result);

		String xmlString = result.getWriter().toString();
	//	System.out.println(xmlString);
		return doc;
	}
	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, TransformerException {
		Document test = commitSearch("Stent Chest Pain", link);
		Document test2 = ListRetrival.findArticles(test);



		try {
			Source source = new DOMSource(test);

			File file = new File("Test.txt");
			Result result = new StreamResult(file);

			Transformer xformer = TransformerFactory.newInstance().newTransformer();
			xformer.transform(source, result);
		} catch (TransformerConfigurationException e) {
		} catch (TransformerException e) {
		}


	}
}
