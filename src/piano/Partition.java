/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piano;
import java.util.Vector;
import java.util.Iterator;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;   
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author antoine
 */
public class Partition{

    private Vector<Morceau> partition;
    
    public Partition(){
        
        partition = new Vector<Morceau>();
        
    }
    
    public Partition(Partition p){//copie profonde
        
        Iterator<Morceau> it = p.getPartition().iterator();
        
        while(it.hasNext()){
            
            partition.add(it.next());
            
        }
                
    }
    
    public Vector<Morceau> getPartition(){return partition;}
    
    public boolean savePartition(String nomFichier){
         
        Iterator<Morceau> e = this.partition.iterator();
        Note[][] tab = null;
        int i, j = 0;
        boolean retour = false;
        
        try{
            BufferedWriter out = new BufferedWriter(new FileWriter(nomFichier, true));
            
            while(e.hasNext()){
                tab = e.next().getMorceau();
                
                for(i=0;i<tab.length;i++){
                    for(j=0;j<tab[i].length;j++){
                        out.write(tab[i][j].toString() + ",");
                    
                    }
                    out.write("|");
                }
            }
            
            retour = true;
            out.flush();
            out.close();

        }
        catch (IOException err) {
            System.out.println("Probleme de fichier : " + err.getMessage());
        }
        
        return(retour);
     }
    
    public void loadPartition(String nomFichier){
         
        Iterator<Morceau> e = this.partition.iterator();
        String contenu = null;
        
        try{
	    	BufferedReader in = new BufferedReader(new FileReader(nomFichier));
	    	contenu = in.readLine();
	    	in.close();
        }
        catch (FileNotFoundException f) {
	    	System.out.println("Probleme de fichier avec " + nomFichier);
        }
        catch (IOException err) {
	    	System.out.println("Probleme de lecture : " + err.getMessage());
        }
            
     } 
    
    
}
