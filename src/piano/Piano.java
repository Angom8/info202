/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piano;
import launcher.Game;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.WindowConstants;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Antoine
 */
public class Piano extends Game {
    
    private Container parent;
    private Partition partition;
    /**
     * Creates new form InterfacePiano
     */
    public Piano(Container parent) {
        super("Piano");
        this.parent= parent;
        partition = new Partition();
        initComponents();
    }
    
    public Piano() {
        super("Piano");
        this.parent = null;
        partition = new Partition();
        initComponents();
        
    }
     @SuppressWarnings("unchecked")                       
    private void initComponents() {
        
        fenetreGlobal = new JFrame();

        fenetreGlobal.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        fenetreGlobal.setTitle("Piano"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(fenetreGlobal.getContentPane());
        fenetreGlobal.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 741, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 458, Short.MAX_VALUE)
        );

        try {
			lune = ImageIO.read(new File("lune.gif"));
			terre = ImageIO.read(new File("world.gif"));
	}
        
        fenetreGlobal.pack();
    }   
    public void saveGame(java.io.File file){

        partition.savePartition(file);
       
    }
    
     /**
     *
     * @param file The file from where the game as to be restored
     */
    public void loadGame(java.io.File file){
        
        partition.loadPartition(file);
        
    }
    
    public  void startGame(){}
    public  void stopGame(){}
    public void pauseGame(){}
//start, stop and pause are useless since the Piano is not a "true" game;//useless since the Piano is not a "true" game
    
    public String getName()
    {
        return super.getName();
    }
    
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private JFrame fenetreGlobal;
}    

