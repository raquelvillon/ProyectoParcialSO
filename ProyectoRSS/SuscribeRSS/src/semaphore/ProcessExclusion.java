/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaphore;

import Entities.Feed;
import Entities.FeedMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import sucriberss.RSSFeedParser;

/**
 *
 * @author Raquel Villon
 */
public class ProcessExclusion extends Thread
{
 private int threadId;
 private Semaphore semaphore;
 private BoundedSemaphore mutex;
 private Feed feed;
 private ArrayList<Feed> feedlt;
 
    public ProcessExclusion(Semaphore semaphore, BoundedSemaphore mutex) {
      this.semaphore = semaphore;
      this.mutex= mutex;
    }

    public ArrayList<Feed> getFeedlt() {
        return feedlt;
    }

    public void setFeedlt(ArrayList<Feed> feedlt) {
        this.feedlt = feedlt;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public void setSemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

 public void setThreadId(int threadId) {
    this.threadId = threadId;
    }

 private int random(int n)
 {
   return (int) Math.round(n * Math.random());
 }

 private void busyCode() {
   int sleepPeriod = random(500);
    try {
       sleep(sleepPeriod);
        
    } catch (InterruptedException e) {
    }
 }

 private void noncriticalCode()
 {
   //busyCode();
 }

 private void criticalCode(Feed feed, FeedMessage message)
 {
   //busyCode(); 
   feed.getMessages().add(message);
   feedlt.add(feed);   
 }

 public void run()
 {
    try {
       RSSFeedParser parser = new RSSFeedParser(feed.getLink());
       Feed feeds = parser.readFeed();
       List<FeedMessage> ltfeed = feeds.getMessages();
       for(FeedMessage i: ltfeed){
           try {
                mutex.take();
                Feed newfeed = new Feed(feeds.getId(),feeds.getTitle(),feeds.getLink(),feeds.getAuthor(),feeds.getDescription(),feeds.getLanguage(),feeds.getCopyright(),feeds.getPubDate());
                criticalCode(newfeed,i);
                mutex.release();
                
                semaphore.release();
//                try{sleep(200);
//                }catch(Exception io){}
           } catch (InterruptedException ex) {
               Logger.getLogger(ProcessExclusion.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    } catch (Exception e) {
       System.out.println("Exception " + e.toString());
    }
   
 }
}
 