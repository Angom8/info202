/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piano;
import java.io.Serializable;

/*Un morceau dure 5 secondes, soit 100 ticks. Un tick correspond a 0.1 secondes. Une case de tableau vers la droite correspond a un tick. Il est possible
de mettre jusqu'a 10 Notes par colonne, soit 10 en un tick.
Si un utilisateur souhaite faire une partition de plus de 5 secondes, un deuxieme morceaun est creee. L'ensemble final sera a sauvegarder.*/

/**
 *La partition, un ensemble de notes dans un tableau a deux dimensions.
 * @author antoine
 */
public class Morceau implements Serializable {
    
    private static final long serialVersionUID = 111111111;
    private int duree;
    private Note[][] morceau;
    final int MAXTICK = 50;
    final int MAXNOTE = 10;
    
    public Morceau(){
        
        morceau = new Note[MAXTICK][MAXNOTE];//!!!!0 a 49 et 0 a 9
        duree = 0;
        
    }
    
    public Morceau(Morceau m){
        
        morceau = new Note[MAXTICK][MAXNOTE];//copie profonde pour le morceau, surface pour les notes
        
        for(int i = 0; i<MAXTICK ; i++){
            
            for(int j = 0; j < MAXNOTE ; j++){
                
               this.ajouterNote(m.getNote(i, j), i , j);
                
            }
            
        }
        
        
        this.duree = m.getDuree();
        
    }
    
    public Note[][] getMorceau(){return morceau;}
    public int getDuree(){return duree;}
    public Note getNote(int x, int y){return morceau[x][y];}
    
    public void ajouterNote(Note n, int x, int y){
        
        if(duree<x){duree=x;}
        
        morceau[x][y] = n;
            
    }
    
        
    public void retirerNote(int x, int y){
        
        morceau[x][y] = null;
        
         nouvelleDuree();
            
    }
    
    public void retirerLigne(int y){
        
        for(int i = 0; i<MAXTICK; i++){
         morceau[i][y] = null;
        }
        
         nouvelleDuree();
            
    }
    
        
    public void retirerColonne(int x){
        
        for(int j = 0;j<MAXNOTE; j++){
         morceau[x][j] = null;
        }
        
         nouvelleDuree();
            
    }
    

    public void ajouterNoteRep(Note n, int y, int t){
        
        for(int i = 0; i<MAXTICK; i+=t){
         morceau[i][y] = n;
        }
        
        nouvelleDuree();//redefinit duree
       
            
    }
    
    public void nouvelleDuree(){
        
        int max = 0;
        int j = 0;
        int i;
                
        
        while(j<MAXNOTE&max<MAXTICK){
            for(i = max; i<MAXTICK;i++){
                if(morceau[i][j]!=null){
                    max = i;
                }
            }
            j++;
        }
            
        this.duree = max;
        
    }
    
}
