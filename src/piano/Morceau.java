/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piano;

/*Un morceau dure 5 secondes, soit 10 ticks. Un tick correspond a 0.5 secondes. Une case de tableau vers la droite correspond a un tick.
Si un utilisateur souhaite faire une partition de plus de 5 secondes, un deuxieme morceaun est creee. L'ensemble final sera a sauvegarder.*/

/**
 *La partition, un ensemble de notes dans un tableau a deux dimensions.
 * @author antoine
 */
public class Morceau {
    
    private int duree;
    private Note[] morceau;
    final int MAXTICK = 20;
    
  /**
 *Construc par defaut
 */    
    
    public Morceau(){
        
        morceau = new Note[MAXTICK];//!!!!0 a 49
        duree = 0;
        
    }
  /**
 *Construc par copie
 * @param m le morceau de base
 */     
    public Morceau(Morceau m){
        
        morceau = new Note[MAXTICK];//copie profonde pour le morceau, surface pour les notes
        
        for(int i = 0; i<MAXTICK ; i++){
               
            this.ajouterNote(m.getNote(i), i);    
            
        }
        
        
        this.duree = m.getDuree();
        
    }
    
      /**
 *Construc par init
 * @param notes le tableau de note
 */ 
    public Morceau(Note[] notes){
        
        morceau = new Note[MAXTICK];
        
        for(int i = 0; i<MAXTICK ; i++){
       
           this.ajouterNote(notes[i], i );
   
        }
        
        nouvelleDuree();
        
    }
    
      /**
 *Getter du morceau
 * @return le tableau de notes
 */     
    
    public Note[] getMorceau(){return morceau;}
    
      /**
 *Getter de la duree du morceau
 * @return la duree
 */    
    
    public int getDuree(){return duree;}
    
       /**
 *Getter de la note a partir d'une position
 * @param x la position
 * @return la note
 */   

    public Note getNote(int x){return morceau[x];}
    
       /**
 *Setter de la note a partir d'une position et d'une note (ofc)
 * @param n la note
 * @param x la position
 */      
    
    public void ajouterNote(Note n, int x){
        
        if(duree<x){duree=x;}
        
        morceau[x] = n;
            
    }
        /**
 *Setter inverse de la note a partir d'une position
 * @param x la position
 */     
        
    public void retirerNote(int x){
        
        morceau[x] = null;
        
         nouvelleDuree();
            
    }
/**
 *Reset le morceau
 */   
    public void reset(){
        
        for(int i = 0; i<MAXTICK; i++){
         morceau[i] = null;
        }
        
         nouvelleDuree();
            
    }
/**
 *Definir la duree automatiquement
 */      
    public void nouvelleDuree(){
        
        int max = 0;
        int i = 0;
                
        
        while(i<MAXTICK){
                if(morceau[i]!=null){
                    max = i;
                }
                i++;
        }
            
        this.duree = max;
        
    }
    
}
