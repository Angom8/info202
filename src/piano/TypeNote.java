/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piano;
import java.io.Serializable;

/**
 *Le type de note
 * @author antoine
 */
public enum TypeNote implements Serializable {
    
    PIANO, BIT, JAZZ, SECRET;
    
    private final String atr;
    
    TypeNote(String atr){
        
        this.atr = atr;
    }
    
    @Override
    public String toString(){
        
        return(atr);
    }
    
}
