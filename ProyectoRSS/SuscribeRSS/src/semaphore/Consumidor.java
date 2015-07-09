/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaphore;

import Entities.Feed;
import Entities.FeedMessage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 *
 * @author Raquel Villon
 */
public class Consumidor extends Thread
{
 private int threadId;
 private Semaphore semaphore;
 private BoundedSemaphore mutex;
 int posicion=0;
 JPanel jPanel1;
 JPanel contenedor;
 JScrollPane pane;
 private ArrayList<Feed> feedlt;
 
    public Consumidor(Semaphore semaphore, BoundedSemaphore mutex, JPanel jPanel1, ArrayList<Feed> feedlt) {
      this.semaphore = semaphore;
      this.mutex= mutex;
      this.jPanel1=jPanel1;
      this.feedlt=feedlt;
      jPanel1.removeAll();
            contenedor = new JPanel();
            contenedor.setBackground(Color.white);
            pane = new JScrollPane(contenedor);
            pane.setHorizontalScrollBar(null);
            JScrollBar sb = pane.getVerticalScrollBar();
            sb.setUI(new MyScrollbarUI());
            pane.setBackground(Color.white);
            pane.setSize(jPanel1.getWidth(), jPanel1.getHeight());
            pane.setBorder(null);
            contenedor.setLayout(null);
            jPanel1.add(pane);
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public void setSemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
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
   busyCode(); 
   feed.getMessages().add(message);
 }

 public void run()
 {
    try {
        do{
            semaphore.acquire();
            mutex.take();
            if(feedlt!=null){ 
                try {
                    if(feedlt.get(posicion)!=null){
                        Feed fd = feedlt.remove(posicion);
                        JLabel lb = new JLabel(fd.getTitle());
                        lb.setSize(jPanel1.getWidth(), 100);
                        lb.setLocation(0, (posicion-1)*100);
                        lb.setBackground(Color.white);
                        lb.setForeground(Color.black);
                        contenedor.add(lb);

                        contenedor.setPreferredSize(new Dimension(jPanel1.getWidth(), (posicion*100)));
                        pane.setViewportView(contenedor);

                        posicion++;
                    }
                }catch(Exception io){}
            }
            mutex.release();
        }while(true);
    } catch (Exception e) {
       System.out.println("Exception " + e.toString());
    }
 }
 
 public class MyScrollbarUI extends BasicScrollBarUI {

       private Image imageThumb, imageTrack;
        private JButton b = new JButton() {

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(0, 0);
            }

        };

        MyScrollbarUI() {
            imageThumb = FauxImage.create(32, 32, new Color(0,74,151));
            imageTrack = FauxImage.create(32, 32, Color.lightGray);
        }

        @Override
        protected void paintThumb(Graphics g, JComponent c, java.awt.Rectangle r) {
            g.setColor(Color.blue);
            ((Graphics2D) g).drawImage(imageThumb,
                r.x, r.y, r.width, r.height, null);
        }

        @Override
        protected void paintTrack(Graphics g, JComponent c, java.awt.Rectangle r) {
            ((Graphics2D) g).drawImage(imageTrack,
                r.x, r.y, r.width, r.height, null);
        }

        @Override
        protected JButton createDecreaseButton(int orientation) {
            return b;
        }

        @Override
        protected JButton createIncreaseButton(int orientation) {
            return b;
        }
    }
    
    private static class FauxImage {

        static public Image create(int w, int h, Color c) {
            BufferedImage bi = new BufferedImage(
                w, h, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = bi.createGraphics();
            g2d.setPaint(c);
            g2d.fillRect(0, 0, w, h);
            g2d.dispose();
            return bi;
        }
    }
 
}
