/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercici2;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author Alumne
 */
public class RssParserSax {

    private URL rssUrl;

    public RssParserSax(String url) {
        try {
            this.rssUrl = new URL(url);
        } catch (MalformedURLException ex) {
            System.out.println("Error MalformedURL" + ex);
        }
    }

    public List<New> parse() throws IOException {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            RssHandler handler = new RssHandler();
            parser.parse(rssUrl.openConnection().getInputStream(), handler);
            return handler.getNews();
        } catch (SAXException ex) {
            Logger.getLogger(RssParserSax.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error SAX: " + ex);
        } catch (IOException ex) {
            System.out.println("Error IO: " + ex);
        } catch (ParserConfigurationException ex) {
            System.out.println("Error parsing" + ex);
        }
        return null;
    }
}
