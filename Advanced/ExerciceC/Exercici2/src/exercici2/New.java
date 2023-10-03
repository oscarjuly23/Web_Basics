/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercici2;

/**
 *
 * @author Alumne
 */
public class New {

    private String title;
    private String link;
    private String description;
    private String guid;
    private String pubDate;

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }

    public String getGuid() {
        return guid;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    @Override
    public String toString() {
        return "New{" + "title=" + title + ", link=" + link + ", description=" + description + ", guid=" + guid + ", pubDate=" + pubDate + '}';
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

}
