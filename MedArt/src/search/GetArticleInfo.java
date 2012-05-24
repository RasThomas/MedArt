package search;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class GetArticleInfo {
	private static final String link = "http://eutils.ncbi.nlm.nih.gov/entrez/eutils/efetch.fcgi?db=pubmed&id=";
	private static final String format = "&retmode=xml";
	
	public static Document articleInfo(String Id) throws IOException, ParserConfigurationException, SAXException, TransformerException {
		Document articleDoc = CommitSearch.commitSearch(link + Id + format);
		PubMedSearch.printFile(articleDoc, "Article.txt");

			
		return articleDoc;
		}
	
}
