/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piano;

/**
 *
 * @author Antoine THEBAULT
 * @author Jean-Charles BOISSON
 */
class Run{
    
    public static void main(String args[]){
        
        javax.swing.JFrame jFrame = new javax.swing.JFrame("Piano");
        
	jFrame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(500, 500);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        
        Piano game = new Piano(jFrame.getContentPane());
        
        jFrame.setVisible(true);
    }
    
}
