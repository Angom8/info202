/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piano;
import java.applet.Applet;

import java.applet.AudioClip;

import java.net.URL;

import java.io.File;
        
/**
 *
 * @author antoine
 */
public class Piano {

    public static void main(String[] arg){
        
        try {

           URL url = new URL("https://www.mediaforma.com/encours/son.wav");

           AudioClip ac = Applet.newAudioClip(url);

            ac.play();

        } 
        
        catch (Exception e) {

            System.out.println(e);

        }

    }
    
}
