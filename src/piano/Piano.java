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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
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
    private JInternalFrame fenetre;
    /**
     * Creates new form InterfacePiano
     */
    public Piano(Container parent) {
        super("Piano");
        this.parent= parent;
        partition = new Partition();
        fenetre = new JInternalFrame();
        fenetre.setVisible(true);
        initComponents();
    }
    
    public Piano() {
        super("Piano");
        this.parent = null;
        partition = new Partition();
        fenetre = new JInternalFrame();
        initComponents();
        
        
    }
     @SuppressWarnings("unchecked")                       
    private void initComponents() {
        
        jMenuBar = new JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Load = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        jMenu1.setText("File");

        Load.setText("Load");
        Load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadMouseClicked(evt);
            }
        });
        
        jMenu1.add(Load);

        jMenuItem1.setText("Save");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar.add(jMenu1);

        fenetre.setJMenuBar(jMenuBar);
        
        try{
        JPanel pan = new ImagePane(ImageIO.read(new File(("user.dir") + "/src/piano/img/piano.png")));
        }
        catch(IOException e){
            System.out.println("Erreur : "+ e.getMessage());
        }
        
        fenetre.add(jMenuBar);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(parent);
        parent.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup())
                .addComponent(fenetre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        );
 
    }   
    
    private void LoadActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
    }                                    

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        filtreFichier filtre = new filtreFichier();
        JFileChooser choix = new JFileChooser();
        choix.addChoosableFileFilter(filtre);
        choix.setCurrentDirectory(new java.io.File("/home/antoine/NetBeansProjects/Piano/src/piano/partitions"));
        int retour=choix.showOpenDialog(this.parent);
        if(retour==JFileChooser.APPROVE_OPTION){
            partition.loadPartition(choix.getSelectedFile());
        }
        else {} ;// pas de fichier choisi
    } 
    
    private void LoadMouseClicked(java.awt.event.ActionEvent evt) {
        
        filtreFichier filtre = new filtreFichier();
        JFileChooser choix = new JFileChooser();
        choix.addChoosableFileFilter(filtre);
        choix.setCurrentDirectory(new java.io.File("/home/antoine/NetBeansProjects/Piano/src/piano/partitions"));
        int retour=choix.showOpenDialog(this.parent);
        if(retour==JFileChooser.APPROVE_OPTION){
            partition.savePartition(choix.getSelectedFile());
        }
        else {} ;// pas de fichier choisi
        
       
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
    private javax.swing.JMenuItem Load;
    private javax.swing.JMenu jMenu1;
    private JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItem1;
}    

