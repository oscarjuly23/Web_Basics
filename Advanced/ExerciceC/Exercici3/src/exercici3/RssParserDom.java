/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercici3;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Alumne
 */
public class RssParserDom {

    private URL rssUrl;

    public RssParserDom(String url) {
        try {
            this.rssUrl = new URL(url);

        } catch (MalformedURLException ex) {
            System.out.println("Error MalformedURL: " + ex);
        }

    }

    public List<New> parse() {
        List<New> news = new ArrayList<New>();
        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(rssUrl.openConnection().getInputStream());
            NodeList items = document.getElementsByTagName("item");
            for (int i = 0; i < items.getLength(); i++) {
                Node item = items.item(i);
                New currentNew = new New();
                news.add(currentNew);
                if (item.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) item;
                    NodeList datosNoticia = item.getChildNodes();
                    for (int j = 0; j < datosNoticia.getLength(); j++) {
                        Node dato = datosNoticia.item(j);
                        String etiqueta = dato.getNodeName();
                        String texto;
                        switch (etiqueta) {
                            case "title":
                                texto = getElementText(etiqueta, elemento);
                                currentNew.setTitle(texto);
                                break;
                            case "description":
                                texto = getElementText(etiqueta, elemento);
                                currentNew.setDescription(texto);
                                break;
                            case "link":
                                texto = getElementText(etiqueta, elemento);
                                currentNew.setLink(texto);
                                break;
                            case "guid":
                                texto = getElementText(etiqueta, elemento);
                                currentNew.setGuid(texto);
                                break;
                            case "pubDate":
                                texto = getElementText(etiqueta, elemento);
                                currentNew.setPubDate(texto);
                                break;

                        }
                    }
                }

            }
        } catch (ParserConfigurationException ex) {
            System.out.println("Error ParserConfiguration: " + ex);
        } catch (SAXException ex) {
            System.out.println("Error SAXException: " + ex);
        } catch (IOException ex) {
            System.out.println("Error IOException: " + ex);
        }
        return news;
    }

    private String getElementText(String etiqueta, Element elemento) {
        NodeList nodoList = elemento.getElementsByTagName(etiqueta).item(0).getChildNodes();
        Node nodo = nodoList.item(0);
        return nodo.getNodeValue();
    }

}
