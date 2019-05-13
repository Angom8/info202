/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piano;
import launcher_piano.Game;
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
import java.time.OffsetTime;


/**
 *
 * @author Antoine
 */
public class Piano extends Game {
    
    private Container parent;//Si on le lance par un launcher
    private Partition partition;//LA partition
    private JPanel fenetre;//fenetre de jeu
    private TypeNote NOTE_SELECTED;//type de note en cours (par defaut le piano)
    private boolean recording;//en train de record ?
    private OffsetTime start = null;//pour le record, temps de debut de record
    public final JFXPanel fxPanel = new JFXPanel();//necessaire pour init les sons
    final int MAXTICK = 20;//nombre de notes pour 5 secondes, soit ici 4 par seconde
    /**
     * Initialisation du piano
     * @param parent le Container
     */
    public Piano(Container parent) {
        super("Piano");
        this.parent= parent;
        partition = new Partition();
        fenetre = new JPanel();
        fenetre.setVisible(true);
        NOTE_SELECTED = TypeNote.PIANO;
        recording = false;
        initComponents();

    }
     /**
     * Lancement du piano hors Run ou Launcher
     */
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

     /**
     * Gestion de l'affichage Swing/FX. Le tout fait a la main car Netbeans est *un peu* pas pratique
     */    
    private void initComponents() {
        
        
        //declarations
        jPanel2 = new javax.swing.JPanel();//image du piano
        
        jComboBox1 = new javax.swing.JComboBox<>();//choix du type de Note
        
        jToolBar1 = new javax.swing.JToolBar();//toolbar
        
        jButton1 = new javax.swing.JButton();//REC
        jButton2 = new javax.swing.JButton();//STOP
        jButton3 = new javax.swing.JButton();//PLAY
        
        jButton4 = new javax.swing.JButton();//4 = note 1, 13 = note 10
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
         
        jButton14 = new javax.swing.JButton();//RESET
        jButton15 = new javax.swing.JButton();//RESET STYLE

        /*
        Le son se declenche lorsque la touche est relevee, sinon il est parfois cut sans vrai controle.
        */
        
        
        //init bouton4 (note 1)
        jButton4.setText("");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {jButton4MouseClicked();}
        });
        jButton4.setMnemonic(java.awt.event.KeyEvent.VK_A);
        jButton4.addKeyListener(new java.awt.event.KeyListener(){
            public void keyPressed(java.awt.event.KeyEvent e) {}
            public void keyReleased(java.awt.event.KeyEvent e) {if (e.getKeyCode()== java.awt.event.KeyEvent.VK_A) {jButton4MouseClicked();}}
            public void keyTyped(java.awt.event.KeyEvent e) {}}
        );
        jButton4.setOpaque(false);jButton4.setContentAreaFilled(false);jButton4.setBorderPainted(false);//Invisible
       
        
        //init bouton5 (note 2)
        jButton5.setText("");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {jButton5MouseClicked();}
        });
        jButton5.setMnemonic(java.awt.event.KeyEvent.VK_Z);
        jButton5.addKeyListener(new java.awt.event.KeyListener(){
            public void keyPressed(java.awt.event.KeyEvent e) {}
            public void keyReleased(java.awt.event.KeyEvent e) {if (e.getKeyCode()== java.awt.event.KeyEvent.VK_Z) {jButton5MouseClicked();}}
            public void keyTyped(java.awt.event.KeyEvent e) {}}
        );
        jButton5.setOpaque(false);jButton5.setContentAreaFilled(false);jButton5.setBorderPainted(false);//Invisible
       
        //init bouton6 (note 3)
        jButton6.setText("");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {jButton6MouseClicked();}
        });
        jButton6.setMnemonic(java.awt.event.KeyEvent.VK_E);
        jButton6.addKeyListener(new java.awt.event.KeyListener(){
            public void keyPressed(java.awt.event.KeyEvent e) {}
            public void keyReleased(java.awt.event.KeyEvent e) {if (e.getKeyCode()== java.awt.event.KeyEvent.VK_E) {jButton6MouseClicked();}}
            public void keyTyped(java.awt.event.KeyEvent e) {}}
        );
        jButton6.setOpaque(false);jButton6.setContentAreaFilled(false);jButton6.setBorderPainted(false);//Invisible        

        
        //init bouton7 (note 4)  
        jButton7.setText("");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {jButton7MouseClicked();}
        });
        jButton7.setMnemonic(java.awt.event.KeyEvent.VK_R);
        jButton7.addKeyListener(new java.awt.event.KeyListener(){
            public void keyPressed(java.awt.event.KeyEvent e) {}
            public void keyReleased(java.awt.event.KeyEvent e) {if (e.getKeyCode()== java.awt.event.KeyEvent.VK_R) {jButton7MouseClicked();}}
            public void keyTyped(java.awt.event.KeyEvent e) {}}
        );
        jButton7.setOpaque(false);jButton7.setContentAreaFilled(false);jButton7.setBorderPainted(false);//Invisible   
       
        //init bouton8 (note 5)
        jButton8.setText("");
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {jButton8MouseClicked();}
        });
        jButton8.setMnemonic(java.awt.event.KeyEvent.VK_T);
        jButton8.addKeyListener(new java.awt.event.KeyListener(){
            public void keyPressed(java.awt.event.KeyEvent e) {}
            public void keyReleased(java.awt.event.KeyEvent e) {if (e.getKeyCode()== java.awt.event.KeyEvent.VK_T) {jButton8MouseClicked();}}
            public void keyTyped(java.awt.event.KeyEvent e) {}}
        );       
        jButton8.setOpaque(false);jButton8.setContentAreaFilled(false);jButton8.setBorderPainted(false);//Invisible         
       
        //init bouton 9 (note 6)
        jButton9.setText("");
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {jButton9MouseClicked();}
        });
        jButton9.setMnemonic(java.awt.event.KeyEvent.VK_Y);
        jButton9.addKeyListener(new java.awt.event.KeyListener(){
            public void keyPressed(java.awt.event.KeyEvent e) {}
            public void keyReleased(java.awt.event.KeyEvent e) {if (e.getKeyCode()== java.awt.event.KeyEvent.VK_Y) {jButton9MouseClicked();}}
            public void keyTyped(java.awt.event.KeyEvent e) {}}
        );
        jButton9.setOpaque(false);jButton9.setContentAreaFilled(false);jButton9.setBorderPainted(false);//Invisible          
        
        
        //init bouton 10 (note 7)
        jButton10.setText("");
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {jButton10MouseClicked();}
        });
        jButton10.setMnemonic(java.awt.event.KeyEvent.VK_U);
        jButton10.addKeyListener(new java.awt.event.KeyListener(){
            public void keyPressed(java.awt.event.KeyEvent e) {}
            public void keyReleased(java.awt.event.KeyEvent e) {if (e.getKeyCode()== java.awt.event.KeyEvent.VK_U) {jButton10MouseClicked();}}
            public void keyTyped(java.awt.event.KeyEvent e) {}}
        );        
        jButton10.setOpaque(false); jButton10.setContentAreaFilled(false); jButton10.setBorderPainted(false);   //Invisible            
        
        //init bouton11 (note 8)
        jButton11.setText("");
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {jButton11MouseClicked();}
        });
        jButton11.setMnemonic(java.awt.event.KeyEvent.VK_I);
        jButton11.addKeyListener(new java.awt.event.KeyListener(){
            public void keyPressed(java.awt.event.KeyEvent e) {}
            public void keyReleased(java.awt.event.KeyEvent e) {if (e.getKeyCode()== java.awt.event.KeyEvent.VK_I) {jButton11MouseClicked();}}
            public void keyTyped(java.awt.event.KeyEvent e) {}}
        );     
        jButton11.setOpaque(false);jButton11.setContentAreaFilled(false);jButton11.setBorderPainted(false); //Invisible        
        
        //init bouton12 (note 9)
        jButton12.setText("");
        jButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {jButton12MouseClicked();}
        });
        jButton12.setMnemonic(java.awt.event.KeyEvent.VK_O);
        jButton12.addKeyListener(new java.awt.event.KeyListener(){
            public void keyPressed(java.awt.event.KeyEvent e) {}
            public void keyReleased(java.awt.event.KeyEvent e) {if (e.getKeyCode()== java.awt.event.KeyEvent.VK_O) {jButton12MouseClicked();}}
            public void keyTyped(java.awt.event.KeyEvent e) {}}
        );    
        jButton12.setOpaque(false);jButton12.setContentAreaFilled(false);jButton12.setBorderPainted(false);//Invisible         
        
        //init bouton13 (note 10)
        jButton13.setText("");
        jButton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {jButton13MouseClicked();}
        });
        jButton13.setMnemonic(java.awt.event.KeyEvent.VK_P);
        jButton13.addKeyListener(new java.awt.event.KeyListener(){
            public void keyPressed(java.awt.event.KeyEvent e) {}
            public void keyReleased(java.awt.event.KeyEvent e) {if (e.getKeyCode()== java.awt.event.KeyEvent.VK_P) {jButton13MouseClicked();}}
            public void keyTyped(java.awt.event.KeyEvent e) {}}
        );    
        jButton13.setOpaque(false);jButton13.setContentAreaFilled(false);jButton13.setBorderPainted(false);//Invisible 

        //import de l'image
        try{
            jPanel2 = new ImagePane(ImageIO.read(new File(System.getProperty("user.dir") + "/src/piano/img/piano.png")));
        }
        catch(IOException e){
            System.out.println("Erreur : "+ e.getMessage());
        }
        
        //layout des differents boutons sur le piano
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
                )
        );

        //init de la combobox
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Piano", "Jazz", "BIT", "???" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {jComboBox1ActionPerformed(evt);}
        });
        
        jToolBar1.setRollover(true);//aucune idee de ce que ca fait pour etre honnete

        //init bouton REC
        jButton1.setText("REC");
        jButton1.setFocusable(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {jButton1MouseClicked();}
        });
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton1);

        
        //init bouton STOP
        jButton2.setText("STOP");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {jButton2MouseClicked();}
        });
        jToolBar1.add(jButton2);

        //init bouton PLAY
        jButton3.setText("PLAY");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {jButton3MouseClicked();}
        });
        jToolBar1.add(jButton3); 
        
        
        //init bouton RESET
        jButton14.setText("RESET");
        jButton14.setFocusable(false);
        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton14.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {jButton14MouseClicked();}
        });
        jToolBar1.add(jButton14);
        
        //init bouton RESET STYLE
        jButton15.setText("RESET STYLE");
        jButton15.setFocusable(false);
        jButton15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton15.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {jButton15MouseClicked();}
        });
        jToolBar1.add(jButton15);

        jToolBar1.add(jComboBox1);
        
        //layout general
        javax.swing.GroupLayout fenetreLayout = new javax.swing.GroupLayout(fenetre);
        fenetre.setLayout(fenetreLayout);
        fenetreLayout.setHorizontalGroup(
            fenetreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fenetreLayout.createSequentialGroup()
                .addGroup(fenetreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                )
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
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(fenetre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 469, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(fenetre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
 
    }   
    
    /*
    *Methode pour le bouton REC. Active le record et s'autodesactive. Lance le timer
    */
    private void jButton1MouseClicked() {  
       this.recording = true;
       jButton1.setBackground(new java.awt.Color(255, 0, 0));
       jButton1.setEnabled(false);
       start = OffsetTime.now();
    }                                     

    /*
    *Methode pour le bouton STOP. Desactive le record et reactive REC.
    */
    
    private void jButton2MouseClicked() {  
       this.recording = false;
       jButton1.setBackground(new java.awt.Color(255, 255, 255));
       jButton1.setEnabled(true);
    }  
    
    /*
    *Bouton PLAY
    */
    
    private void jButton3MouseClicked() {  
        if (this.recording == false){
            
           jButton3.setBackground(new java.awt.Color(128, 128, 0));
           jButton3.setEnabled(false);
           System.out.println(this.partition.toString());
           
            try {
           
                int i;
                int j = 0;
        
                while(j<this.partition.getPartition().size()){
               
                    if(j+1>=this.partition.getPartition().size()){//fin de partition
                        
                        for (i = 0; i<this.partition.getPartition().get(j).getDuree();i++){
                   
                        if(this.partition.getPartition().get(j).getMorceau()[i]!=null){
                            this.partition.getPartition().get(j).getMorceau()[i].jouer();
                        }
                        
                        else{Thread.sleep(1000/(MAXTICK/5));}
                        }
                        
                    }
                    else{
                     for (i = 0; i<this.partition.getPartition().get(j).getMorceau().length;i++){
                   
                            if(this.partition.getPartition().get(j).getMorceau()[i]!=null){
                               this.partition.getPartition().get(j).getMorceau()[i].jouer();
                            }
                        
                          else{Thread.sleep(1000/(MAXTICK/5));}
                    }
                    }
                j++;
                }
            }
            catch (InterruptedException x) {jButton3.setBackground(new java.awt.Color(255, 255, 255));jButton3.setEnabled(true);}
            jButton3.setBackground(new java.awt.Color(255, 255, 255));jButton3.setEnabled(true);
        }
    }  
    
    /*
    *Methode pour le bouton RESET
    */    
    
    private void jButton14MouseClicked() {  
       if (this.recording == false){
           
           this.partition.reset();
           
       }
    } 
    
    /*
    *Methode pour le bouton RESET STYLE
    */   
    private void jButton15MouseClicked() {  
       if (this.recording == false){
           
           this.partition.resetstyle(this.NOTE_SELECTED);
           
       }
    }     

    /*
    *Methode pour la selection du type de Note
    *@param evt l'evenement
    */   
    
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        String selected = (String)jComboBox1.getSelectedItem();
        switch(selected){
            case "Jazz":
                NOTE_SELECTED = TypeNote.JAZZ;
                break;
            case "Piano":
                NOTE_SELECTED = TypeNote.PIANO;
                break;
            case "BIT":
                NOTE_SELECTED = TypeNote.BIT;
                break;                
            default:
                NOTE_SELECTED = TypeNote.SECRET;
                break;                
        }
    }   
 
    /*
    *Methode pour le bouton NOTE 1
    */   
    
    private void jButton4MouseClicked() {   
        
        //construction de la note sur le fil
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
        
        //lecture
        Media sound = new Media(new File(System.getProperty("user.dir") + "/src/piano/notes/"+note+"/"+1+".wav").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        
        
        if (this.recording == true){
            
            int diff;
            int i;
            OffsetTime now = OffsetTime.now();
            
            if (now.getMinute() - this.start.getMinute() > 30|now.getHour() > this.start.getHour()){
                jButton2MouseClicked();
            }
            else
            {
                if (now.getMinute() > this.start.getMinute()){
                    diff = (now.getMinute() - this.start.getMinute())*60 + (now.getSecond() - this.start.getSecond());
                }
                else{
                    diff = now.getSecond() - this.start.getSecond();
                }
                
                diff *= 4;
                diff = (int)(diff/(MAXTICK/5));
                i = 0;
                float nano = now.getNano() - this.start.getNano();
                
                if(nano<0){
                    nano = 100000000 + nano;
                }
                
                if(nano>750000000){
                    diff += 3;
                }
                if(nano<=750000000&nano>500000000){
                    diff += 2;
                }
                if(nano<=500000000&nano>250000000){
                    diff +=1;
                }                       
                
                while(diff >= MAXTICK){
                    
                    diff -= MAXTICK;
                    if (i+1>=this.partition.getPartition().size()){
                        this.partition.getPartition().addElement(new Morceau());
                    }
                    i++;
                }
         
                
                
                this.partition.getPartition().get(i).ajouterNote(new Note(this.NOTE_SELECTED, 1), diff);
  
            }
        }      
    } 
    
    /*
    *Method pour la note 2
    */
    private void jButton5MouseClicked() {   
        
        //construction de la note sur le fil
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
        
        //lecture
        Media sound = new Media(new File(System.getProperty("user.dir") + "/src/piano/notes/"+note+"/"+2+".wav").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        
        
        if (this.recording == true){
            
            int diff;
            int i;
            OffsetTime now = OffsetTime.now();
            
            if (now.getMinute() - this.start.getMinute() > 30|now.getHour() > this.start.getHour()){
                jButton2MouseClicked();
            }
            else
            {
                if (now.getMinute() > this.start.getMinute()){
                    diff = (now.getMinute() - this.start.getMinute())*60 + (now.getSecond() - this.start.getSecond());
                }
                else{
                    diff = now.getSecond() - this.start.getSecond();
                }
                diff *= 4;
                diff = (int)(diff/(MAXTICK/5));
                i = 0;
                 float nano = now.getNano() - this.start.getNano();
                
                if(nano<0){
                    nano = 100000000 + nano;
                }
                
                if(nano>750000000){
                    diff += 3;
                }
                if(nano<=750000000&nano>500000000){
                    diff += 2;
                }
                if(nano<=500000000&nano>250000000){
                    diff +=1;
                }               
                while(diff >= MAXTICK){
                    
                    diff -= MAXTICK;
                    if (i+1>=this.partition.getPartition().size()){
                        this.partition.getPartition().addElement(new Morceau());
                    }
                    i++;
                }
                

   
                this.partition.getPartition().get(i).ajouterNote(new Note(this.NOTE_SELECTED, 2), diff);
  
            }
        }
    }    

    /*
    *Method pour la note 3
    */
    private void jButton6MouseClicked() {   
        
        //construction de la note sur le fil
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
        
        //lecture
        Media sound = new Media(new File(System.getProperty("user.dir") + "/src/piano/notes/"+note+"/"+3+".wav").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        
        
        if (this.recording == true){
            
            int diff;
            int i;
            OffsetTime now = OffsetTime.now();
            
            if (now.getMinute() - this.start.getMinute() > 30|now.getHour() > this.start.getHour()){
                jButton2MouseClicked();
            }
            else
            {
                if (now.getMinute() > this.start.getMinute()){
                    diff = (now.getMinute() - this.start.getMinute())*60 + (now.getSecond() - this.start.getSecond());
                }
                else{
                    diff = now.getSecond() - this.start.getSecond();
                }
                diff *= 4;                
                diff = (int)(diff/(MAXTICK/5));
                i = 0;
                float nano = now.getNano() - this.start.getNano();
                
                if(nano<0){
                    nano = 100000000 + nano;
                }
                
                if(nano>750000000){
                    diff += 3;
                }
                if(nano<=750000000&nano>500000000){
                    diff += 2;
                }
                if(nano<=500000000&nano>250000000){
                    diff +=1;
                }                 
                while(diff >= MAXTICK){
                    
                    diff -= MAXTICK;
                    if (i+1>=this.partition.getPartition().size()){
                        this.partition.getPartition().addElement(new Morceau());
                    }
                    i++;
                }
              
                this.partition.getPartition().get(i).ajouterNote(new Note(this.NOTE_SELECTED, 3), diff);
  
            }
        }
    }    
    
    /*
    *Method pour la note 4
    */
    private void jButton7MouseClicked() {   
        
        //construction de la note sur le fil
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
        
        //lecture
        Media sound = new Media(new File(System.getProperty("user.dir") + "/src/piano/notes/"+note+"/"+4+".wav").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        
        
        if (this.recording == true){
            
            int diff;
            int i;
            OffsetTime now = OffsetTime.now();
            
            if (now.getMinute() - this.start.getMinute() > 30|now.getHour() > this.start.getHour()){
                jButton2MouseClicked();
            }
            else
            {
                if (now.getMinute() > this.start.getMinute()){
                    diff = (now.getMinute() - this.start.getMinute())*60 + (now.getSecond() - this.start.getSecond());
                }
                else{
                    diff = now.getSecond() - this.start.getSecond();
                }
                diff *= 4;                
                diff = (int)(diff/(MAXTICK/5));
                i = 0;
                float nano = now.getNano() - this.start.getNano();
                
                if(nano<0){
                    nano = 100000000 + nano;
                }
                
                if(nano>750000000){
                    diff += 3;
                }
                if(nano<=750000000&nano>500000000){
                    diff += 2;
                }
                if(nano<=500000000&nano>250000000){
                    diff +=1;
                }                    
                while(diff >=MAXTICK){
                    
                    diff -= MAXTICK;
                    if (i+1>=this.partition.getPartition().size()){
                        this.partition.getPartition().addElement(new Morceau());
                    }
                    i++;
                }
            
                this.partition.getPartition().get(i).ajouterNote(new Note(this.NOTE_SELECTED, 4), diff);
  
            }
        }
    }
    
    /*
    *Method pour la note 5
    */
    
    private void jButton8MouseClicked() {   
        
        //construction de la note sur le fil
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
        
        //lecture
        Media sound = new Media(new File(System.getProperty("user.dir") + "/src/piano/notes/"+note+"/"+5+".wav").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        
        
        if (this.recording == true){
            
            int diff;
            int i;
            OffsetTime now = OffsetTime.now();
            
            if (now.getMinute() - this.start.getMinute() > 30|now.getHour() > this.start.getHour()){
                jButton2MouseClicked();
            }
            else
            {
                if (now.getMinute() > this.start.getMinute()){
                    diff = (now.getMinute() - this.start.getMinute())*60 + (now.getSecond() - this.start.getSecond());
                }
                else{
                    diff = now.getSecond() - this.start.getSecond();
                }
                diff *= 4;                
                diff = (int)(diff/(MAXTICK/5));
                i = 0;
                float nano = now.getNano() - this.start.getNano();
                
                if(nano<0){
                    nano = 100000000 + nano;
                }
                
                if(nano>750000000){
                    diff += 3;
                }
                if(nano<=750000000&nano>500000000){
                    diff += 2;
                }
                if(nano<=500000000&nano>250000000){
                    diff +=1;
                }                  
                while(diff >= MAXTICK){
                    
                    diff -= MAXTICK;
                    if (i+1>=this.partition.getPartition().size()){
                        this.partition.getPartition().addElement(new Morceau());
                    }
                    i++;
                }
              
                this.partition.getPartition().get(i).ajouterNote(new Note(this.NOTE_SELECTED, 5), diff);
  
            }
        }
    }
    /*
    *Method pour note 6
    */

    private void jButton9MouseClicked() {   
        
        //construction de la note sur le fil
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
        
        //lecture
        Media sound = new Media(new File(System.getProperty("user.dir") + "/src/piano/notes/"+note+"/"+6+".wav").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        
        
        if (this.recording == true){
            
            int diff;
            int i;
            OffsetTime now = OffsetTime.now();
            
            if (now.getMinute() - this.start.getMinute() > 30|now.getHour() > this.start.getHour()){
                jButton2MouseClicked();
            }
            else
            {
                if (now.getMinute() > this.start.getMinute()){
                    diff = (now.getMinute() - this.start.getMinute())*60 + (now.getSecond() - this.start.getSecond());
                }
                else{
                    diff = now.getSecond() - this.start.getSecond();
                }
                diff *= 4;                
                diff = (int)(diff/(MAXTICK/5));
                i = 0;
                float nano = now.getNano() - this.start.getNano();
                
                if(nano<0){
                    nano = 100000000 + nano;
                }
                
                if(nano>750000000){
                    diff += 3;
                }
                if(nano<=750000000&nano>500000000){
                    diff += 2;
                }
                if(nano<=500000000&nano>250000000){
                    diff +=1;
                }                  
                while(diff >= MAXTICK){
                    
                    diff -= MAXTICK;
                    if (i+1>=this.partition.getPartition().size()){
                        this.partition.getPartition().addElement(new Morceau());
                    }
                    i++;
                }
              
                this.partition.getPartition().get(i).ajouterNote(new Note(this.NOTE_SELECTED, 6), diff);
  
            }
        } 
    }
    /*
    *Method pour la note 7
    */
    private void jButton10MouseClicked() {   
        
        //construction de la note sur le fil
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
        
        //lecture
        Media sound = new Media(new File(System.getProperty("user.dir") + "/src/piano/notes/"+note+"/"+7+".wav").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        
        
        if (this.recording == true){
            
            int diff;
            int i;
            OffsetTime now = OffsetTime.now();
            
            if (now.getMinute() - this.start.getMinute() > 30|now.getHour() > this.start.getHour()){
                jButton2MouseClicked();
            }
            else
            {
                if (now.getMinute() > this.start.getMinute()){
                    diff = (now.getMinute() - this.start.getMinute())*60 + (now.getSecond() - this.start.getSecond());
                }
                else{
                    diff = now.getSecond() - this.start.getSecond();
                }
                diff *= 4;                
                diff = (int)(diff/(MAXTICK/5));
                i = 0;
                float nano = now.getNano() - this.start.getNano();
                
                if(nano<0){
                    nano = 100000000 + nano;
                }
                
                if(nano>750000000){
                    diff += 3;
                }
                if(nano<=750000000&nano>500000000){
                    diff += 2;
                }
                if(nano<=500000000&nano>250000000){
                    diff +=1;
                }                 
                while(diff >= MAXTICK){
                    
                    diff -= MAXTICK;
                    if (i+1>=this.partition.getPartition().size()){
                        this.partition.getPartition().addElement(new Morceau());
                    }
                    i++;
                }
               
                this.partition.getPartition().get(i).ajouterNote(new Note(this.NOTE_SELECTED, 7), diff);
  
            }
        }     
    }
    
    /*
    *Method pour la note 8
    */
    
    private void jButton11MouseClicked() {   
        
        //construction de la note sur le fil
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
        
        //lecture
        Media sound = new Media(new File(System.getProperty("user.dir") + "/src/piano/notes/"+note+"/"+8+".wav").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        
        
        if (this.recording == true){
            
            int diff;
            int i;
            OffsetTime now = OffsetTime.now();
            
            if (now.getMinute() - this.start.getMinute() > 30|now.getHour() > this.start.getHour()){
                jButton2MouseClicked();
            }
            else
            {
                if (now.getMinute() > this.start.getMinute()){
                    diff = (now.getMinute() - this.start.getMinute())*60 + (now.getSecond() - this.start.getSecond());
                }
                else{
                    diff = now.getSecond() - this.start.getSecond();
                }
                diff *= 4;                
                diff = (int)(diff/(MAXTICK/5));
                i = 0;
                float nano = now.getNano() - this.start.getNano();
                
                if(nano<0){
                    nano = 100000000 + nano;
                }
                
                if(nano>750000000){
                    diff += 3;
                }
                if(nano<=750000000&nano>500000000){
                    diff += 2;
                }
                if(nano<=500000000&nano>250000000){
                    diff +=1;
                }                   
                while(diff >= MAXTICK){
                    
                    diff -= MAXTICK;
                    if (i+1>=this.partition.getPartition().size()){
                        this.partition.getPartition().addElement(new Morceau());
                    }
                    i++;
                }
             
                this.partition.getPartition().get(i).ajouterNote(new Note(this.NOTE_SELECTED, 8), diff);
  
            }
        }
    }

    /*
    *Method pour note 9
    */
    
    
    private void jButton12MouseClicked() {   
        
        //construction de la note sur le fil
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
        
        //lecture
        Media sound = new Media(new File(System.getProperty("user.dir") + "/src/piano/notes/"+note+"/"+9+".wav").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        
        
        if (this.recording == true){
            
            int diff;
            int i;
            OffsetTime now = OffsetTime.now();
            
            if (now.getMinute() - this.start.getMinute() > 30|now.getHour() > this.start.getHour()){
                jButton2MouseClicked();
            }
            else
            {
                if (now.getMinute() > this.start.getMinute()){
                    diff = (now.getMinute() - this.start.getMinute())*60 + (now.getSecond() - this.start.getSecond());
                }
                else{
                    diff = now.getSecond() - this.start.getSecond();
                }
                diff *= 4;                
                diff = (int)(diff/(MAXTICK/5));
                i = 0;
                float nano = now.getNano() - this.start.getNano();
                
                if(nano<0){
                    nano = 100000000 + nano;
                }
                
                if(nano>750000000){
                    diff += 3;
                }
                if(nano<=750000000&nano>500000000){
                    diff += 2;
                }
                if(nano<=500000000&nano>250000000){
                    diff +=1;
                }                   
                while(diff >= MAXTICK){
                    
                    diff -= MAXTICK;
                    if (i+1>=this.partition.getPartition().size()){
                        this.partition.getPartition().addElement(new Morceau());
                    }
                    i++;
                }
             
                this.partition.getPartition().get(i).ajouterNote(new Note(this.NOTE_SELECTED, 9), diff);
  
            }
        }
    }

    /*
    *Method pour la note 10
    */
    
    
    private void jButton13MouseClicked() {   
        
        //construction de la note sur le fil
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
        
        //lecture
        Media sound = new Media(new File(System.getProperty("user.dir") + "/src/piano/notes/"+note+"/"+10+".wav").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        
        
        if (this.recording == true){
            
            int diff;
            int i;
            OffsetTime now = OffsetTime.now();
            
            if (now.getMinute() - this.start.getMinute() > 30|now.getHour() > this.start.getHour()){
                jButton2MouseClicked();
            }
            else
            {
                if (now.getMinute() > this.start.getMinute()){
                    diff = (now.getMinute() - this.start.getMinute())*60 + (now.getSecond() - this.start.getSecond());
                }
                else{
                    diff = now.getSecond() - this.start.getSecond();
                }
                diff *= 4;                
                diff = (int)(diff/(MAXTICK/5));
                i = 0;
                float nano = now.getNano() - this.start.getNano();
                
                if(nano<0){
                    nano = 100000000 + nano;
                }
                
                if(nano>750000000){
                    diff += 3;
                }
                if(nano<=750000000&nano>500000000){
                    diff += 2;
                }
                if(nano<=500000000&nano>250000000){
                    diff +=1;
                }                 
                while(diff >= MAXTICK){
                    
                    diff -= MAXTICK;
                    if (i+1>=this.partition.getPartition().size()){
                        this.partition.getPartition().addElement(new Morceau());
                    }
                    i++;
                }
               
                this.partition.getPartition().get(i).ajouterNote(new Note(this.NOTE_SELECTED, 10), diff);
  
            }
        }
    }     

    /*
    *Sauvegarder la partition
    *@param f fichier de destination
    */
    public void saveGame(File f){partition.savePartition(f);}
    /*
    *Charger une partition
    *@param f fichier source
    */
    public void loadGame(File f){ partition.loadPartition(f);}
    /*
    *Commencer le jeu
    *Redirige vers REC
    */
    public  void startGame(){jButton1MouseClicked();}
    /*
    *Arreter le jeu
    *Redirige vers STOP
    */
    public  void stopGame(){jButton2MouseClicked();}
    public void pauseGame(){}//unused
    
    /*
    *Obtenir le nom du jeu
    *@return le nom du jeu
    */
    public String getName()
    {
        return super.getName();
    }
    
    //declarations
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
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



