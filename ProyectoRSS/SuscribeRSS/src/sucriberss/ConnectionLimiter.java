/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sucriberss;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Raquel Villon
 * this is supposed to manage the semaphores
 */
public class ConnectionLimiter {
   private final Semaphore semaphore;
    
    public ConnectionLimiter(int maxConcurrentRequests) {
        
        semaphore = new Semaphore(maxConcurrentRequests);
    }
    
    public URLConnection acquire(URL url) throws InterruptedException, IOException {
        semaphore.acquire();
        return url.openConnection();
    }
    
    public void release(URLConnection conn) {
        
        try {
            
            /*
            
            * ... clean up here
            
            */
            
        } finally {
            
            semaphore.release();
            
        }
    } 
}
