/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piano;

/**
 *
 * @author antoine
 */
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
 
public class ImagePane extends JPanel {
     
    protected Image buffer;    
     
    public ImagePane(Image buffer){
        this.buffer = buffer;
    }  
         
    public void paintComponent(Graphics g) {
       g.drawImage(buffer,0,0,null);
     }
}
