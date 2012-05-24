package search;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
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
	private static final String retmax = "&retmax=";
	private static final String retstart = "&retstart=";
	
	public static Document pubMedSearch(String terms, String start, String max) throws IOException, ParserConfigurationException, SAXException, TransformerException{
		String search = link + terms.replace(" ", "+") + retstart + start + retmax + max;
		Document dummy = CommitSearch.commitSearch(search);
		
		return dummy;
	}
	public static void printFile(Document doc, String fileName) {
		try {
			Source source = new DOMSource(doc);

			File file = new File(fileName);
			Result result = new StreamResult(file);

			Transformer xformer = TransformerFactory.newInstance().newTransformer();
			xformer.transform(source, result);
		} catch (TransformerConfigurationException e) {
		} catch (TransformerException e) {
		}
		
	}


	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, TransformerException {

		Document test = pubMedSearch("Stent Chest Pain", "0", "20");
		Document test2 = ListRetrival.findArticles(test);
		printFile(test, "Search.txt");
		GetArticleInfo.articleInfo("22562999");




	}
}
