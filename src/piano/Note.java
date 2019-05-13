/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piano;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import javafx.embed.swing.JFXPanel;

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
 * @param t type de la note
 * @param f sa frequence
 */
    
    public Note(TypeNote t, int f){
        
        this.type = t;
        
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
        
        this.freq = f;
        if(f==0){
            
            this.freq = 10;
        }
        
        
        this.ul = System.getProperty("user.dir") + "/src/piano/notes/"+retour+"/"+freq+".wav";

        
        
        this.son = new Media(new File(ul).toURI().toString());
        
    }
   /**
 *Construc par init
 */   
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
 *Definir le type de la note
 * @param t le type
 **/
    
    public void setType(TypeNote t){

        this.type = t;

    }
         /**
 *Definir automatiquement le lien vers le son
 **/       
    public void setURL(){

        
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
        this.ul = System.getProperty("user.dir") + "/src/piano/notes/"+retour+"/"+freq+".wav";

    }
         /**
 *Definir automatiquement le son
 **/     
    public void setSon(){

        this.son = new Media(new File(ul).toURI().toString());

    }
/**
 *Definir automatiquement la frequence
 * @param f la frequence
 **/    
    public void setFreq(int f){

        this.freq = f;
        if (f == 0){
               this.freq = 10;
        }
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
 * @return la note sous forme type+frequence en bref
 **/
    @Override
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
        
        if (freq == 10){
            retour += 0;
        }
        else{
            retour += this.freq;
        }
                
        return(retour);       
    }
/**
 *Jouer la note
 **/    
    public void jouer() {
        final JFXPanel fxPanel = new JFXPanel();
        MediaPlayer mediaPlayer = new MediaPlayer(son);
        mediaPlayer.play();
    }
    
}
