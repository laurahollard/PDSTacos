/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.*;
import java.awt.event.*;
import static javafx.scene.paint.Color.TRANSPARENT;
import javax.swing.*;
import javax.swing.border.TitledBorder;


/**
 *
 * @author Laura
 */
public class Authentification extends JFrame {

    
    public Authentification(){
        
        JPanel pannel = new JPanel(new GridLayout(6,1));
        
        // Color of JPanel
        pannel.setBackground(Color.WHITE);
    
        // Size of JPanel
        pannel.setPreferredSize(new Dimension(400,200));
        add(pannel);
        
        // Title of Border
        pannel.setBorder(new TitledBorder("Authentifiez vous")); 
        
        // Enter id
        JLabel id = new JLabel();
        id.setText("Identifiant :");
        JTextField enterID = new JTextField(10);
        pannel.add(id);
        pannel.add(enterID);
        
        // Enter password
        JLabel mdp = new JLabel();
        mdp.setText("Mot de passe :");
        JTextField enterPWD = new JTextField(10);
        pannel.add(mdp);
        pannel.add(enterPWD);
        
        // Add button for connect
        JButton connect = new JButton("Connexion");
        pannel.add(connect);
      
        this.pack();  // Clean up unnecessary spaces on IHM
        this.setContentPane(pannel);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setVisible(true);
     
    }

}
        
   
        
        
    
    
 
    
    
    
  
    

