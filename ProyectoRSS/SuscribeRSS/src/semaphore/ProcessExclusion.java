/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaphore;

import Entities.Feed;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import sucriberss.RSSFeedParser;

/**
 *
 * @author Raquel Villon
 * Hilos para manejar los canales y la escritura de las noticias en el buffer
 * fuente: http://www.informit.com/articles/article.aspx?p=1339471&seqNum=2
 */
public class ProcessExclusion extends Thread
{
 private int threadId;
 private Semaphore semaphore;
 private Feed feed;
 
    public ProcessExclusion(Semaphore semaphore) {
      this.semaphore = semaphore;
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
   busyCode();
 }

 private void criticalCode(String message)
 {
//    rss.getEntries().add(message);
//    ltmensaje.add(rss);
      System.out.println(message);

 }

 public void run()
 {
    try {
//        abre el canal
       RSSFeedParser parser = new RSSFeedParser(feed.getLink());
       
       Feed feed = parser.readFeed();
       
       feed.getMessages().stream().forEach((message) -> {
           //por cada noticia leida 
           try {
                semaphore.acquire();
                criticalCode(message.toString());
                semaphore.release();
           } catch (InterruptedException ex) {
               Logger.getLogger(ProcessExclusion.class.getName()).log(Level.SEVERE, null, ex);
           }
       });
    } catch (Exception e) {
       System.out.println("Exception " + e.toString());
    }
   
 }
}
 