package sucriberss;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableCellRenderer;
/**
 * @web http://www.jc-mouse.net
 * @author Mouse
 * to give style to the table and choose channels 
 */
public class CellRenderer extends DefaultTableCellRenderer {
 
    private String tipo="text";
    private Font courier = new Font( "Courier New",Font.PLAIN ,12 );
    private Font normal = new Font( "Arial",Font.PLAIN ,12 );
    private Font bold = new Font( "Arial",Font.BOLD ,12 );
    private JLabel label = new JLabel();
    
    /** Constructor de clase
     * @param tipo String
     * Ej.: "text", "text center", "hour" , "num" , "icon"
     */
    public CellRenderer( String tipo )
    {
        this.tipo = tipo;
    }
    
    
    @Override
    public Component getTableCellRendererComponent ( JTable table, Object value, boolean selected, boolean focused, int row, int column )
    {   
        this.setFont(new java.awt.Font("Roboto Light", 0, 11));
        this.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 2, new java.awt.Color(255, 255, 255)));
        if (selected) {                
            this.setBackground( new Color( 150, 153 , 254) );                        
        }
        else
        {
                this.setBackground(new Color( 245, 245 , 245));
        }
        
        if( tipo.equals("check"))
        {
            this.setHorizontalAlignment( JCheckBox.CENTER );
            JCheckBox comboBox = new JCheckBox();
            comboBox.setSelected((Boolean)value);
            comboBox.setLocation(0, 15);
            this.setText("");
            return comboBox;
        }
        
        if( tipo.equals("text"))
        {
            this.setHorizontalAlignment( JLabel.LEFT );
            this.setText( (String) value );
            this.setForeground( (selected)?new Color(255,255,255):new Color(0,0,0) );            
            return this;
        }
      
        if( tipo.equals("imagen"))
        {
            try{
                this.setHorizontalAlignment( JLabel.CENTER );
                String cadena= (String) value ;
                String linea = cadena+".png";
                //Image image1 = Image.getInstance(linea);
                File fichero = new File(linea);
                if(fichero.exists()){
                    BufferedImage b = (BufferedImage)ImageIO.read(fichero);
                    javax.swing.ImageIcon  img  = new javax.swing.ImageIcon(b.getScaledInstance(80, 80, 1));
                    this.setIcon(img);
                }else{
                    BufferedImage b = (BufferedImage)ImageIO.read(getClass().getResource("/Login/imagenes/no_image.jpg"));
                    javax.swing.ImageIcon  img  = new javax.swing.ImageIcon(b.getScaledInstance(80, 80, 1));
                    this.setIcon(img);
                }
                
                return this;
            }catch(Exception io){
            
            }
            
        }
        if( tipo.equals("text center"))
        {
            this.setHorizontalAlignment( JLabel.CENTER );
            if(value!=null){
                this.setText( (String) value.toString() );
            }else{
                this.setText( "" );
            }
            this.setForeground( (selected)?new Color(255,255,255):new Color(0,0,0) );            
            return this;
        }
                
        if( tipo.equals("text izquierda"))
        {
            this.setHorizontalAlignment( JLabel.LEFT );
            this.setText( (String) value.toString() );
            this.setForeground( (selected)?new Color(255,255,255):new Color(0,0,0) );            
            return this;
        }
        if( tipo.equals("fecha"))
        {
            this.setHorizontalAlignment( JLabel.CENTER );
            this.setText( (String) value.toString() );
            this.setForeground( (selected)?new Color(255,255,255):new Color(0,0,0) );            
            return this;
        }
        if( tipo.equals("text derecha"))
        {
            this.setHorizontalAlignment( JLabel.RIGHT );
            this.setText( (String) value );
            this.setForeground( (selected)?new Color(255,255,255):new Color(0,0,0) );            
            return this;
        }
        
        if( tipo.equals("parrafo"))
        {
            String cadena = (String)value;
            String prev="";
            JTextArea jt = new JTextArea(20,30);
            jt.setWrapStyleWord(true);
            jt.setLineWrap(true);
            jt.setText(cadena);
            return jt;
        }
        
        if( tipo.equals("num"))
        {           
            this.setHorizontalAlignment( JLabel.CENTER );
            this.setText( (String) value );            
            this.setForeground( (selected)?new Color(255,255,255):new Color(32,117,32) );            
            return this;   
        }        
        
        return this;
    }
}
