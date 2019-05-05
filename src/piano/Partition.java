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
    
    public void savePartition(java.io.File fichier){
         
        Iterator<Morceau> e = this.partition.iterator();
        Note[][] tab = null;
        int i, j = 0;
        
        try{
            BufferedWriter out = new BufferedWriter(new FileWriter(fichier, true));
            
            while(e.hasNext()){
                tab = e.next().getMorceau();
                
                for(i=0;i<tab.length;i++){
                    for(j=0;j<tab[i].length;j++){
                        out.write(tab[i][j].toString());
                    
                    }
                    out.write("|");
                }
                out.write("%");
            }
            
            out.flush();
            out.close();

        }
        catch (IOException err) {
            System.out.println("Probleme de fichier : " + err.getMessage());
        }
        
     }
    
    public void loadPartition(java.io.File fichier){
        
        char[] contenu = null;
        int i = 0; 
        int j = 0;
        int k = 0;
        int g = 0;
        
        try{
	    	BufferedReader in = new BufferedReader(new FileReader(fichier));
                contenu = in.readLine().toCharArray();
	    	in.close();
                
                while(contenu[i]!='#'){//fichier fini?
                    
                    this.partition.add(g, new Morceau());
                    
                    while(contenu[i]!='%'){//nouveau morceau ?
                        
                        j = 0;
                        k++;
                        
                        while(contenu[i]!='|'){//nouvelle ligne de tableau ?
                            
                            this.partition.get(g).ajouterNote(new Note(), j , k);
                            
                            switch(contenu[i]){
                                  case 'p':
                                    this.partition.get(g).getNote(j, k).setType(TypeNote.PIANO);
                                    break;
                                  case 'b':
                                    this.partition.get(g).getNote(j, k).setType(TypeNote.BIT);
                                    break;
                                  case 'j':
                                    this.partition.get(g).getNote(j, k).setType(TypeNote.JAZZ);
                                    break; 
                                  case 's':
                                    this.partition.get(g).getNote(j, k).setType(TypeNote.SECRET);
                                    break; 
                                  default:
                                    this.partition.get(g).getNote(j, k).setType(TypeNote.SECRET);
                                    break;                                     
                            }
                        
                            i++;
                            
                            this.partition.get(g).getNote(j, k).setFreq((int)(contenu[i]));
                            this.partition.get(g).getNote(j, k).setURL();
                            this.partition.get(g).getNote(j, k).setSon();
                            
                            i++;
                            j++;
                        }
                        
                        i++;
                        
                    }
                    this.partition.get(g).nouvelleDuree();
                    
                    i++;
                    g++;
                    
                    
                }
                
            in.close();
            
        }
        catch (FileNotFoundException f) {
	    	System.out.println("Probleme de fichier avec " + fichier.getName());
        }
        catch (IOException err) {
	    	System.out.println("Probleme de lecture : " + err.getMessage());
        }
           
     } 
    
    
}
