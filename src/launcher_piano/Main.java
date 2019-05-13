/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package launcher_piano;

import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import piano.*;

/**
 *
 * @author Antoine
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
      
        //Parent root = (Parent)loader.load();
        StackPane root = new StackPane();
        
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("Launcher.fxml"));
        
        Scene scene = new Scene(root, 700, 400);
        
        //LauncherController controller = (LauncherController)loader.getController();
       // controller.setStage(primaryStage);
        
        javax.swing.JPanel panel = new javax.swing.JPanel();
        SwingNode swingNode = new SwingNode();

        swingNode.setContent(panel);
        
        Game myGame = new Piano(panel);
        
        root.getChildren().add(swingNode);
        
        primaryStage.setTitle("The Piano Launcher");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
