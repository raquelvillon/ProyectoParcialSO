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
import panels.mainPanel;

/**
 *
 * @author Raquel Villon
 */
public class refresh extends Thread
{
 private mainPanel main;
 private int periodo;
 
    public refresh(mainPanel main) {
        this.main=main;
        periodo=main.getFrecuencia();
    }
 public void run()
 {
    try {
        sleep(2000);
        while(true){
            sleep(periodo*1000);
            main.refresh();
        }
    } catch (Exception e) {
     
    }
 }
 
}
