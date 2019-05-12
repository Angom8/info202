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
    
/**
 * Constructeur par defaut
 */    
  
    public Partition(){
        
        partition = new Vector<Morceau>();
        
    }

/**
 * Constructeur par copie
 * @param p la partition de base
 */ 
    
    public Partition(Partition p){//copie profonde
        
        Iterator<Morceau> it = p.getPartition().iterator();
        
        while(it.hasNext()){
            
            partition.add(it.next());
            
        }
                
    }
 
 /**
 * Getter de la partition
 * @return la partition
 */    
    public Vector<Morceau> getPartition(){return partition;}
    
 /**
 * Sauvegarde de la partition
 * @param fichier de destination
 */      
    
    public void savePartition(java.io.File fichier){
         
        Iterator<Morceau> e = this.partition.iterator();
        Note[] tab;
        int i;
        
        try{
            BufferedWriter out = new BufferedWriter(new FileWriter(fichier, true));
            
            while(e.hasNext()){
                tab = e.next().getMorceau();
                
                for(i=0;i<tab.length;i++){
                        out.write(tab[i].toString());
                }
                out.write("|");
            }
            out.write("#");
            
            out.flush();
            out.close();

        }
        catch (IOException err) {
            System.out.println("Probleme de fichier : " + err.getMessage());
        }
        
     }

 /**
 * Chargement de la partition
 * @param fichier de base
 */ 
    public void loadPartition(java.io.File fichier){
        
        char[] contenu;
        int i = 0; 
        int j;
        int g = 0;
        
        try{
	    	BufferedReader in = new BufferedReader(new FileReader(fichier));
                contenu = in.readLine().toCharArray();
	    	in.close();
                
                while(contenu[i]!='#'){//fichier fini?
                    
                    this.partition.add(g, new Morceau());
                    
                    while(contenu[i]!='|'){//nouveau morceau ?
                        
                        j = 0;
                        
                        while(contenu[i]!='|'){//nouvelle ligne de tableau ?
                            
                            this.partition.get(g).ajouterNote(new Note(), j);
                            
                            switch(contenu[i]){
                                  case 'p':
                                    this.partition.get(g).getNote(j).setType(TypeNote.PIANO);
                                    break;
                                  case 'b':
                                    this.partition.get(g).getNote(j).setType(TypeNote.BIT);
                                    break;
                                  case 'j':
                                    this.partition.get(g).getNote(j).setType(TypeNote.JAZZ);
                                    break; 
                                  case 's':
                                    this.partition.get(g).getNote(j).setType(TypeNote.SECRET);
                                    break; 
                                  default:
                                    this.partition.get(g).getNote(j).setType(TypeNote.SECRET);
                                    break;                                     
                            }
                        
                            i++;
                            
                            this.partition.get(g).getNote(j).setFreq((int)(contenu[i]));
                            this.partition.get(g).getNote(j).setURL();
                            this.partition.get(g).getNote(j).setSon();
                            
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
 /**
 * Reset la partition
 */     
    public void reset(){
        
        Iterator<Morceau> e = this.partition.iterator(); 
        
        while(e.hasNext()){
                e.next().reset();
         }
    } 
 /**
 * Change le style de toute la fichier
 * @param t le nouveau style
 */     
    public void resetstyle(TypeNote t){
        
        Iterator<Morceau> e = this.partition.iterator(); 
        int i;
        Note[] tab; 
        
        while(e.hasNext()){
               tab =  e.next().getMorceau();
               
               for (i = 0; i<tab.length; i++){
                   
                   tab[i].setType(t);
                   tab[i].setURL();
                   tab[i].setSon();
               }
         }
    } 
}
