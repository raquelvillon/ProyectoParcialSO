/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Raquel Villon
 * Class to store each message or item read in channels
 */
public class FeedMessage {
    String title;
    String description;
    String link;
    String author;
    String guid;
    String pubdate;

    public String getTitle() {
      return title;
    }

    public void setTitle(String title) {
      this.title = title;
    }

    public String getDescription() {
      return description;
    }

    public void setDescription(String description) {
      this.description = description;
    }

    public String getLink() {
      return link;
    }

    public void setLink(String link) {
      this.link = link;
    }

    public String getAuthor() {
      return author;
    }

    public void setAuthor(String author) {
      this.author = author;
    }

    public String getGuid() {
      return guid;
    }

    public void setGuid(String guid) {
      this.guid = guid;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    @Override
    public String toString() {
      return "\nFeedMessage [\nTitle=" + title + "\nDescription=" + description
          + "\nLink=" + link + "\nAuthor=" + author + "\nGuid=" + guid
          + "]";
    }
}
