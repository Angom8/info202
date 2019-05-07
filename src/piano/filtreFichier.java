/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piano;
import java.io.File;
/**
 *
 * @author antoine
 */
public class filtreFichier extends javax.swing.filechooser.FileFilter {
   private final String suffix = ".note";
   public filtreFichier(){
   }
   public boolean accept(java.io.File f) {
      if (f.isDirectory())  return true;
      String s = f.getName();
      String suffixe;
      int i = s.lastIndexOf('.');
      if(i > 0 &&  i < s.length() - 1)
         suffixe =s.substring(i+1).toLowerCase();
      else suffixe = null;
      return suffixe.equals(suffix);
      
      
   }
   
   public String getDescription(){return null;}
}