/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piano;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

/**
 *Class Note jouant des sons en fonction de la position du fichier avec un type de note (piano, bit) et une freq aigue, grave, 123456789
 * @author antoine
 */
public class Note {
    
    private TypeNote type;
    private String ul;
    private int freq;
    private Media son;
    
  /**
 *Construc par init
 */
    
    public Note(TypeNote t, int f){
        
        this.type = t;
        this.ul = "notes/"+type+"/"+freq+".wav";
        this.freq = f;
        this.son = new Media(new File(ul).toURI().toString());
        
    }
    
    public Note(){
        
        this.type = null;
        this.ul = null;
        this.freq = 0;
        this.son =null;
        
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
    
    public void setType(TypeNote t){

        this.type = t;

    }
        
    public void setURL(){

        this.ul = "/notes/"+type+"/"+freq+".wav";

    }
    
    public void setSon(){

        this.son = new Media(new File(ul).toURI().toString());

    }
    
    public void setFreq(int f){

        this.freq = f;

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
    public String toString(){//utile pour la sauvegarde de fichier uniquement
        
        String retour = "";
        
        switch(this.type){
            case PIANO:
                retour += "p";
                break;
            case BIT:
                retour += "b";
                break;
            case JAZZ:
                retour += "j";
                break;
            case SECRET:
                retour += "s";
                break; 
            default:
                retour += "s";
                break;   
        }
        
        retour += this.freq;
                
        return(retour);       
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
