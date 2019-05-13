/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piano;

/**
 *Classe permettant de generer des images via un JPanel
 * @author https://openclassrooms.com/forum/sujet/urgent-comment-afficher-une-image-java
 */
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
 
public class ImagePane extends JPanel {
     
    protected Image buffer;    
    
             /**
 *Construc par init
 * @param buffer le flux de lecture du fichier
 **/ 
    public ImagePane(Image buffer){
        this.buffer = buffer;
    }  
             /**
 *Dessiner le fichier
 * @param g le pane de lecture de l'image
 **/     
    @Override
    public void paintComponent(Graphics g) {
       g.drawImage(buffer,0,0,null);
     }
}
