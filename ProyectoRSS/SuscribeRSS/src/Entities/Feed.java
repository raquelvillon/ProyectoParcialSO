/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Raquel Villon
 * This class is supposed to store each feed or channel to get the items 
 */
public class Feed {
    public String id;
    public String title;
    public String link;
    public String author;
    public String description;
    public String language;
    public String copyright;
    public String pubDate;
    public List<FeedMessage> entries = new ArrayList<>();

    public Feed(String id, String title, String link, String author, String description, String language, String copyright, String pubDate) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.author = author;
        this.description = description;
        this.language = language;
        this.copyright = copyright;
        this.pubDate = pubDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }
    public List<FeedMessage> getMessages() {
      return entries;
    }
    public List<FeedMessage> getEntries() {
        return entries;
    }
    @Override
    public String toString() {
      return "Feed [copyright=" + copyright + "\ndescription=" + description
          + "\nlanguage=" + language + "\nlink=" + link + "\npubDate="
          + pubDate + "\ntitle=" + title + "]";
    }
    
    
}
