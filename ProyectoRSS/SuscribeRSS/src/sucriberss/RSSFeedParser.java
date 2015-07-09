/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * this is taken from:
 * http://www.vogella.com/tutorials/RSSFeed/article.html
 * to read and parse the content of the .rss
 */

package sucriberss;

import Entities.Feed;
import Entities.FeedMessage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.XMLEvent;

/**
 *
 * @author Raquel Villon
 * 
 */
public class RSSFeedParser {
//    Variables to parse the content of an RSS
    static final String TITLE = "title";
    static final String DESCRIPTION = "description";
    static final String CHANNEL = "channel";
    static final String LANGUAGE = "language";
    static final String COPYRIGHT = "copyright";
    static final String LINK = "link";
    static final String AUTHOR = "author";
    static final String ITEM = "item";
    static final String PUB_DATE = "pubDate";
    static final String ID = "id";
    ArrayList<Feed> ltfseed = new ArrayList<>();
    final URL url; // this open the url
    
    
    public RSSFeedParser() {
        this.url=null; //this needs to be initaliced 
    }
    
    
    public RSSFeedParser(String feedUrl) {
        try {
            
          this.url = new URL(feedUrl);
          
        } catch (MalformedURLException e) {
          throw new RuntimeException(e);
        }
    }
/*    
 *   Function to read the list of channels
 */
    public Feed readFeedfile() {
        Feed feed = null;
        try {
          boolean isFeedHeader = true;
          // Set header values intial to the empty string
          String description = "";
          String title = "";
          String id = "";
          String link = "";
          String language = "";
          String copyright = "";
          String author = "";
          String pubdate = "";
          String guid = "";

          // First create a new XMLInputFactory
          XMLInputFactory inputFactory = XMLInputFactory.newInstance();
          XMLEventReader eventReader=null;
          try{
            eventReader = inputFactory.createXMLEventReader(new FileInputStream(new File("channels.rss")));
            //this is the list of channels predefined
          }catch(Exception io){
              System.out.println(io);
          }
          // read the XML document
          while (eventReader.hasNext()) {
            XMLEvent event = eventReader.nextEvent();
        if (event.isStartElement()) {
              String localPart = event.asStartElement().getName()
                  .getLocalPart();

              switch (localPart) {
              case ID:
                id = getCharacterData(event, eventReader);
                break;
              case TITLE:
                title = getCharacterData(event, eventReader);
                break;
              case DESCRIPTION:
                description = getCharacterData(event, eventReader);
                break;
              case LINK:
                link = getCharacterData(event, eventReader);
                  
                break;          
              case LANGUAGE:
                language = getCharacterData(event, eventReader);
                break;
              case AUTHOR:
                  
                    author = getCharacterData(event, eventReader);
                    feed = new Feed(id,title, link,author, description, language,
                          copyright, pubdate);
                    
                    ltfseed.add(feed);
                break;
              case PUB_DATE:
                pubdate = getCharacterData(event, eventReader);
                break;
              case COPYRIGHT:
                copyright = getCharacterData(event, eventReader);
                break;
              }
            } 
          }
        } catch (XMLStreamException e) {
          throw new RuntimeException(e);
        }
        return feed;
    }

    /*Function to read selected chanels*/
    
    public Feed readFeed() {
        Feed feed = null;
        try {
          boolean isFeedHeader = true;
          // Set header values intial to the empty string
          String description = "";
          String id = "";
          String title = "";
          String link = "";
          String language = "";
          String copyright = "";
          String author = "";
          String pubdate = "";
          String guid = "";

          // First create a new XMLInputFactory
          XMLInputFactory inputFactory = XMLInputFactory.newInstance();
          // Setup a new eventReader
          InputStream in = read();
          XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
          // read the XML document
          while (eventReader.hasNext()) {
            XMLEvent event = eventReader.nextEvent();
            if (event.isStartElement()) {
              String localPart = event.asStartElement().getName()
                  .getLocalPart();
              switch (localPart) {
              case ITEM:
                if (isFeedHeader) {
                  isFeedHeader = false;
                  feed = new Feed(id,title, link,author, description, language,
                      copyright, pubdate);
                }
                event = eventReader.nextEvent();
                break;
              case TITLE:
                title = getCharacterData(event, eventReader);
                break;
              case DESCRIPTION:
                description = getCharacterData(event, eventReader);
                break;
              case LINK:
                link = getCharacterData(event, eventReader);
                break;
              case ID:
                id = getCharacterData(event, eventReader);
                break;
              case LANGUAGE:
                language = getCharacterData(event, eventReader);
                break;
              case AUTHOR:
                author = getCharacterData(event, eventReader);
                break;
              case PUB_DATE:
                pubdate = getCharacterData(event, eventReader);
                break;
              case COPYRIGHT:
                copyright = getCharacterData(event, eventReader);
                break;
              }
            } else if (event.isEndElement()) {
              if (event.asEndElement().getName().getLocalPart() == (ITEM)) {
                FeedMessage message = new FeedMessage();
                message.setAuthor(author);
                message.setDescription(description);
                message.setGuid(guid);
                message.setLink(link);
                message.setTitle(title);
                feed.getMessages().add(message);
                event = eventReader.nextEvent();
                continue;
              }
            }
          }
        } catch (XMLStreamException e) {
          throw new RuntimeException(e);
        }
        return feed;
    }
    
    private String getCharacterData(XMLEvent event, XMLEventReader eventReader)
        throws XMLStreamException {
        String result = "";
        event = eventReader.nextEvent();
        if (event instanceof Characters) {
          result = event.asCharacters().getData();
        }
        return result;
    }

    private InputStream read() {
      try {
        return url.openStream();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
    
    public ArrayList<Feed> getLtfeed() {
        return ltfseed;
    }

    public void setLtfeed(ArrayList<Feed> ltfeed) {
        this.ltfseed = ltfeed;
    }

    @Override
    public String toString() {
        return "RSSFeedParser{" + "ltfseed=" + ltfseed + '}';
    }
    
    
}
