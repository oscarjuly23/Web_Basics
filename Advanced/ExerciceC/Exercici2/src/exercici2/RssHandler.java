/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercici2;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Alumne
 */
class RssHandler extends DefaultHandler {

    private List<New> news;
    private New currentNew;
    private StringBuilder sb;

    public List<New> getNews() {
        return news;
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        news = new ArrayList<New>();
        sb = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, name, attributes);
        if (name.equals("item")) {
            currentNew = new New();
        }
    }

    @Override
    public void characters(char[] chars, int i, int i1) throws SAXException {
        super.characters(chars, i, i1);
        if (this.currentNew != null) {
            String content = new String(chars, i, i1);
            content = content.replaceAll("[\t\n]", "");
            sb.append(content);
        }

    }

    @Override
    public void endElement(String uri, String localName, String name) throws SAXException {
        if (this.currentNew != null) {
            if (name.equals("title")) {
                currentNew.setTitle(sb.toString());
            } else if (name.equals("link")) {
                currentNew.setLink(sb.toString());
            } else if (name.equals("description")) {
                currentNew.setDescription(sb.toString());
            } else if (name.equals("guid")) {
                currentNew.setGuid(sb.toString());
            } else if (name.equals("pubDate")) {
                currentNew.setPubDate(sb.toString());
            } else if (name.equals("item")) {
                news.add(currentNew);
            }
            sb.setLength(0);
        }
    }
}
