/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author antoine
 */


import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class testSon {
    
    public static void main(String[] arg){
        
        String bip = "test.wav";
        Media hit = new Media(new File(bip).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();

    }
}