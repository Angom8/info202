/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package launcher_piano;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import piano.*;

/**
 * FXML Controller class
 *
 * @author JC
 */
public class LauncherController implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
        private Game currentGame;
    
    private Stage primaryStage;
    
   @FXML
   private Pane gamePanel;
   
   @FXML
   private Label gameNameLabel;
  
 
   public void setStage(Stage primaryStage)
   {
       this.primaryStage=primaryStage;
   }
   
    @FXML
    private void saveGame()
    {
        if(currentGame != null)
        {
            System.out.println("ACTION = Save");
            java.io.File file = new DirectoryChooser().showDialog(primaryStage);
                       
            if(file != null)
            {
                int value = 1;
                while(new java.io.File(file,"Save_"+value+".sav").exists())
                {
                    value++;
                }
               currentGame.saveGame(new java.io.File(file,"Save_"+value+".sav"));
            }
        }
    }
    
    @FXML
    private void loadGame()
    {
        if(currentGame != null)
        {
           System.out.println("ACTION = Load");
           
             java.io.File file = new FileChooser().showOpenDialog(primaryStage);
            
            if(file != null)
            {
               currentGame.loadGame(file);
            }
        }
    }
    
    @FXML
    private void startGame()
    {
        if(currentGame != null)
        {
            System.out.println("ACTION = Start");
            currentGame.startGame();
        }
    }
    
    @FXML
    private void stopGame()
    {
        if(currentGame != null)
        {
            System.out.println("ACTION = Stop");
            currentGame.stopGame();
        }
    }
    
    @FXML
    private void pauseGame()
    {
        if(currentGame != null)
        {
            System.out.println("ACTION = Pause");
            currentGame.pauseGame();
        }
    }
    
    @FXML
    private void changeGame()
    {
        System.out.println("ACTION = Change");
        javax.swing.JPanel panel = new javax.swing.JPanel();
        SwingNode swingNode = new SwingNode();
        currentGame = new Piano(panel);
        gameNameLabel.setText(currentGame.getName());
        swingNode.setContent(panel);
        gamePanel.getChildren().add(swingNode);
    }
    
}
