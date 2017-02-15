/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;


import java.awt.*;
import javax.swing.*;



/**
 *
 * @author Laura
 */
public class InterfaceGraphique extends JFrame {
    
       
    public InterfaceGraphique(){
           design();   
            
            
            }
    
    public void design(){
            JFrame f = new JFrame();
            setTitle("Interface");
            setSize(800, 400);
            Toolkit tk = Toolkit.getDefaultToolkit();
            Dimension dimEcran = tk.getScreenSize(); 
            setSize(dimEcran.width, dimEcran.height);
            setLocationRelativeTo(null); 
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
            Authentification a = new Authentification();
            this.getContentPane().add(a, BorderLayout.CENTER);
           // Accueil aa = new Accueil();
            // this.getContentPane().add(aa);
            setVisible(true);
    }
    
  
      public static void main(String[] args) {
       	
	
       // InterfaceGraphique ihm = new InterfaceGraphique();
        // ihm.setVisible(true);
      // InterfaceGraphique i = new InterfaceGraphique();
     //   i.setVisible(true);
     HomeManager m = new HomeManager();
     m.setVisible(true);
	
    }
}
