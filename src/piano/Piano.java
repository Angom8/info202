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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import javafx.embed.swing.JFXPanel;


/**
 *
 * @author Antoine
 */
public class Piano extends Game {
    
    private Container parent;
    private Partition partition;
    private JPanel fenetre;
    private TypeNote NOTE_SELECTED;
    private boolean recording;
    /**
     * Creates new form InterfacePiano
     */
    public Piano(Container parent) {
        super("Piano");
        this.parent= parent;
        partition = new Partition();
        fenetre = new JPanel();
        fenetre.setVisible(true);
        NOTE_SELECTED = TypeNote.JAZZ;
        recording = false;
        initComponents();

    }
    
    public Piano() {
        super("Piano");
        JFrame temp = new JFrame();
        temp.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        temp.setSize(1000, 1000);
        temp.setResizable(true);
        temp.setLocationRelativeTo(null);
        temp.setVisible(true);
        parent = temp.getContentPane();
        partition = new Partition();
        fenetre = new JPanel();
        initComponents();
        
        
    }
    
    @SuppressWarnings("unchecked")                       
    private void initComponents() {
        
        jPanel2 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();

        jButton4.setText("");

        jButton5.setText("");

        jButton6.setText("");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });

        jButton8.setText("");
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });

        jButton7.setText("");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });

        jButton9.setText("");
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton9MouseClicked(evt);
            }
        });

        jButton10.setText("");
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton10MouseClicked(evt);
            }
        });
        
        
        jButton11.setText("");
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton11MouseClicked(evt);
            }
        });

        jButton12.setText("");
        jButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton12MouseClicked(evt);
            }
        });

        jButton13.setText("");
        jButton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton13MouseClicked(evt);
            }
        });

        try{
            
            System.out.println(System.getProperty("user.dir") + "/src/piano/img/piano.png");
            jPanel2 = new ImagePane(ImageIO.read(new File(System.getProperty("user.dir") + "/src/piano/img/piano.png")));
        }
        catch(IOException e){
            System.out.println("Erreur : "+ e.getMessage());
        }
        
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButton4, 80,80, 80)
                .addGap(1, 1, 1)
                .addComponent(jButton6, 75,75, 75)
                .addGap(1, 1, 1)
                .addComponent(jButton8, 80,80, 80)
                .addGap(1, 1, 1)
                .addComponent(jButton9, 80,80, 80)
                .addGap(1, 1, 1)
                .addComponent(jButton11, 80,80, 80)
                .addGap(1, 1, 1)
                .addComponent(jButton13, 76,76, 76))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96,96)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0))
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE) )))
                .addContainerGap())
        );

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Piano", "Jazz", "BIT", "???" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jToolBar1.setRollover(true);

        jButton1.setText("REC");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setText("STOP");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton3.setText("PLAY");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton3);

        jToolBar1.add(jComboBox1);
        
        javax.swing.GroupLayout fenetreLayout = new javax.swing.GroupLayout(fenetre);
        fenetre.setLayout(fenetreLayout);
        fenetreLayout.setHorizontalGroup(
            fenetreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fenetreLayout.createSequentialGroup()
                .addGroup(fenetreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        fenetreLayout.setVerticalGroup(
            fenetreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fenetreLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(parent);
        parent.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 819, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(fenetre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 469, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(fenetre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
 
    }   
    
     private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }   
  
    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {   
        
        String note = "";
        
        switch(NOTE_SELECTED){
            case PIANO:
                note += "p";
                break;
            case BIT:
                note += "b";
                break;
            case JAZZ:
                note += "j";
                break;
            case SECRET:
                note += "s";
                break; 
            default:
                note += "s";
                break;   
        }
        
        final JFXPanel fxPanel = new JFXPanel();
        Media sound = new Media(new File(System.getProperty("user.dir") + "/src/piano/notes/"+note+"/"+3+".wav").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }    
    
    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {   
        
        String note = "";
        
        switch(NOTE_SELECTED){
            case PIANO:
                note += "p";
                break;
            case BIT:
                note += "b";
                break;
            case JAZZ:
                note += "j";
                break;
            case SECRET:
                note += "s";
                break; 
            default:
                note += "s";
                break;   
        }
        
        final JFXPanel fxPanel = new JFXPanel();
        Media sound = new Media(new File(System.getProperty("user.dir") + "/src/piano/notes/"+note+"/"+4+".wav").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }
    
    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {   
        
        String note = "";
        
        switch(NOTE_SELECTED){
            case PIANO:
                note += "p";
                break;
            case BIT:
                note += "b";
                break;
            case JAZZ:
                note += "j";
                break;
            case SECRET:
                note += "s";
                break; 
            default:
                note += "s";
                break;   
        }
        
        final JFXPanel fxPanel = new JFXPanel();
        Media sound = new Media(new File(System.getProperty("user.dir") + "/src/piano/notes/"+note+"/"+5+".wav").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }
    
    private void jButton9MouseClicked(java.awt.event.MouseEvent evt) {   
        
        String note = "";
        
        switch(NOTE_SELECTED){
            case PIANO:
                note += "p";
                break;
            case BIT:
                note += "b";
                break;
            case JAZZ:
                note += "j";
                break;
            case SECRET:
                note += "s";
                break; 
            default:
                note += "s";
                break;   
        }
        
        final JFXPanel fxPanel = new JFXPanel();
        Media sound = new Media(new File(System.getProperty("user.dir") + "/src/piano/notes/"+note+"/"+6+".wav").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }
    
    private void jButton10MouseClicked(java.awt.event.MouseEvent evt) {   
        
        String note = "";
        
        switch(NOTE_SELECTED){
            case PIANO:
                note += "p";
                break;
            case BIT:
                note += "b";
                break;
            case JAZZ:
                note += "j";
                break;
            case SECRET:
                note += "s";
                break; 
            default:
                note += "s";
                break;   
        }
        
        final JFXPanel fxPanel = new JFXPanel();
        Media sound = new Media(new File(System.getProperty("user.dir") + "/src/piano/notes/"+note+"/"+7+".wav").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }
    
    private void jButton11MouseClicked(java.awt.event.MouseEvent evt) {   
        
        String note = "";
        
        switch(NOTE_SELECTED){
            case PIANO:
                note += "p";
                break;
            case BIT:
                note += "b";
                break;
            case JAZZ:
                note += "j";
                break;
            case SECRET:
                note += "s";
                break; 
            default:
                note += "s";
                break;   
        }
        
        final JFXPanel fxPanel = new JFXPanel();
        Media sound = new Media(new File(System.getProperty("user.dir") + "/src/piano/notes/"+note+"/"+8+".wav").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }

    private void jButton12MouseClicked(java.awt.event.MouseEvent evt) {   
        
        String note = "";
        
        switch(NOTE_SELECTED){
            case PIANO:
                note += "p";
                break;
            case BIT:
                note += "b";
                break;
            case JAZZ:
                note += "j";
                break;
            case SECRET:
                note += "s";
                break; 
            default:
                note += "s";
                break;   
        }
        
        final JFXPanel fxPanel = new JFXPanel();
        Media sound = new Media(new File(System.getProperty("user.dir") + "/src/piano/notes/"+note+"/"+9+".wav").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }

    private void jButton13MouseClicked(java.awt.event.MouseEvent evt) {   
        
        String note = "";
        
        switch(NOTE_SELECTED){
            case PIANO:
                note += "p";
                break;
            case BIT:
                note += "b";
                break;
            case JAZZ:
                note += "j";
                break;
            case SECRET:
                note += "s";
                break; 
            default:
                note += "s";
                break;   
        }
        
        final JFXPanel fxPanel = new JFXPanel();
        Media sound = new Media(new File(System.getProperty("user.dir") + "/src/piano/notes/"+note+"/"+10+".wav").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }     
    
    public void saveGame(java.io.File file){

        filtreFichier filtre = new filtreFichier();
        JFileChooser choix = new JFileChooser();
        choix.addChoosableFileFilter(filtre);
        choix.setCurrentDirectory(new java.io.File("/"));
        int retour=choix.showOpenDialog(this.parent);
        if(retour==JFileChooser.APPROVE_OPTION){
            partition.loadPartition(choix.getSelectedFile());
        }
        else {} ;// pas de fichier choisi
       
    }
    
     /**
     *
     * @param file The file from where the game as to be restored
     */
    public void loadGame(java.io.File file){
        
        filtreFichier filtre = new filtreFichier();
        JFileChooser choix = new JFileChooser();
        choix.addChoosableFileFilter(filtre);
        choix.setCurrentDirectory(new java.io.File("/"));
        int retour=choix.showOpenDialog(this.parent);
        if(retour==JFileChooser.APPROVE_OPTION){
            partition.savePartition(choix.getSelectedFile());
        }
        else {} ;// pas de fichier choisi
        
    }
    
    public  void startGame(){}
    public  void stopGame(){}
    public void pauseGame(){}
//start, stop and pause are useless since the Piano is not a "true" game;//useless since the Piano is not a "true" game
    
    public String getName()
    {
        return super.getName();
    }
    
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToolBar jToolBar1;
    
    
}    



