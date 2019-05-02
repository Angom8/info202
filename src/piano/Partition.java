/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piano;
import java.util.Vector;
import java.util.Iterator;
        
/**
 *
 * @author antoine
 */
public class Partition implements Serializable{

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
    
}
