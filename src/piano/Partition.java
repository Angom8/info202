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
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;

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
        partition.addElement(new Morceau());
        
        
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
                        if (tab[i] == null){
                            out.write("00");
                        }
                        else{
                            out.write(tab[i].toString());
                        }
                        
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
        
        this.partition = new Vector<Morceau>();
        char[] contenu = new char[0];
        String reading = ""; String temp;
        int i = 0; 
        int j;
        int g = 0;
        try{
                
               
                Scanner sc = new Scanner(new FileInputStream(fichier.getAbsolutePath()));
                    while (sc.hasNextLine()){
                        reading = sc.nextLine();
                        
                    }
                contenu = reading.toCharArray();
                        }
        catch (FileNotFoundException f) {
	    	System.out.println("Probleme de fichier avec " + fichier.getName() + f.getMessage());
        }   
                
                while(contenu.length > 1 && i<contenu.length && contenu[i]!='#'){//fichier fini?
                    
                    this.partition.add(g, new Morceau());
                        
                        j = 0;
                        
                        while(contenu.length > 1 && i<contenu.length && contenu[i]!='|' && contenu[i]!='#'){//nouveau morceau
                            
                            if(contenu[i]!='0'){
                            
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
                                         temp = "" + contenu[i];
                                     this.partition.get(g).getNote(j).setFreq((((Integer.parseInt(temp)))));
                                     this.partition.get(g).getNote(j).setURL();
                                     this.partition.get(g).getNote(j).setSon();
                                     
                                     
                                     i++;
                            }
                            else{
                                i += 2;
                            }
                            j++;
                        
                    }
                    this.partition.get(g).nouvelleDuree();
                    
                    if(contenu[i]!='#' && i<contenu.length){
                        i++;
                    }
                    
                    g++;
                    
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
                   
                   if(tab[i]!=null){
                   
                     tab[i].setType(t);
                     tab[i].setURL();
                     tab[i].setSon();
                   }
               }
         }
    } 
     /**
 * Faire apparaitre les notes (pour test)
 * @return les notes
 */     
    public String toString(){
        
        Iterator<Morceau> e = this.partition.iterator(); 
        int i;
        Note[] tab; 
        String retour = "" ;
        
        while(e.hasNext()){
               tab =  e.next().getMorceau();
               
               for (i = 0; i<tab.length; i++){
                   if(tab[i]!=null){
                      retour += tab[i].toString(); 
                   }
                   else{retour += "00";}
                   
               }
         }
        
        return(retour);
        
    }
}
