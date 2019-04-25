/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piano;
import java.io.Serializable;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

/**
 *Class Note jouant des sons en fonction de la position du fichier avec un type de note (piano, bit) et une freq aigue, grave, 123456789
 * @author antoine
 */
public class Note extends Thread implements Serializable {
    
    private static final long serialVersionUID = 111111111;
    private TypeNote type;
    private URL ul;
    private int freq;
    private AudioClip son;
    
  /**
 *Construc par init
 */
    
    public Note(TypeNote t, int f){
        
        this.type = t;
        this.ul = this.getClass().getClassLoader().getResource("/notes/"+type+"/"+freq+".wav");
        this.freq = f;
        this.son = Applet.nletewAudioClip(this.ul);
        
    }
    /**
 *Obtenir le type de note
 * @return le type de la note (bit, piano)
 **/
    public TypeNote getType(){
        
        
        return(type);
        
        
    }
        /**
 *Obtenir le lien vers le son
 * @return le lien vers le son
 **/
    public URL getURL(){
        
        
        return(ul);
        
        
    }
            /**
 *Obtenir la frequence de son, de 1 a 9
 * @return la frequence
 **/
    public int getFreq(){
        
        
        return(freq);
        
        
    }
    
                /**
 *toString de la classe
 * @return la desc de la note
 **/
    public String toString(){
        
        
        return("La note de type " + type + " avec une frequence de "+ freq + " au repertoire "+ ul);
        
        
    }
    
    public void jouer() {
        son.play();
    }
    public void jouerEnBoucle() {
        son.loop();
    }
    public void arreter() {
        son.stop();
    }
    
}
