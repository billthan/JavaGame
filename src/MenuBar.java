package src;
/*
 * ZHANG FEI and BILL THAN
 * 2/10/2017
 * WAR GAME
 * 
 * MenuBar Class
 * Stores actions of menu bar
 * 
 */

import javax.swing.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.Scanner;

public class MenuBar { 
  JMenuBar mb;
  JMenu file;
  JMenuItem exit, about, feedback;
  ImageIcon img;
  
  String str;
  
  public void makeMenu()
  { 
    JFrame f = main.f;
    //main frame
    
    
    //menubar 
    mb = new JMenuBar(); 
    //file tab
    file = new JMenu("file");
    
    feedback = new JMenuItem("feedback");
    exit = new JMenuItem("exit");
    about = new JMenuItem("about");
    
    file.add(feedback);
    file.add(about);
    file.add(exit);
    //adds menubar to file
    mb.add(file);
    //adds menubar to frame
    f.setJMenuBar(mb);
  }
  
  //menu bar actions
  public void settingAction()
  {
    exit.addActionListener(new menuAction());
    about.addActionListener(new menuAction());
    feedback.addActionListener(new menuAction());
  }
  //executes action done
  private class menuAction implements ActionListener
  {
    JFrame f = main.f;
    public void actionPerformed(ActionEvent e)
    {
      if (e.getSource() == exit)//if the user clicks on the exit
      {
        System.exit(0); 
      }
      
      else if (e.getSource() == about)
      {
        //about info
        ImageIcon img = new ImageIcon("src/YEET.png");
        
        try {
   
          Scanner keyboard = new Scanner(System.in);
          
          //reads version from file txt
          File file = new File("src/version info.txt");
          Scanner inputFile = new Scanner(file);
          str = inputFile.nextLine();

        }
        catch (FileNotFoundException a) {
          //in case file not found
          System.out.println("No file has been found. Please verify that there is a version.txt in the src folder.");
          
        }
        String label = "War Game! Created by Zhang and Bill " + str;
        //displays about info
        JOptionPane.showMessageDialog(null, label, "WARGAME", JOptionPane.PLAIN_MESSAGE, img);
      }
      else if (e.getSource() == feedback)
      {
        //asks for user fedback
        String result = JOptionPane.showInputDialog(null, "Please enter any feedback you have for this program! Thanks!");
        //thanks dialog
        JOptionPane.showMessageDialog(null, "Thanks for the feedback, have a nice day!", "THANKS DAWG", JOptionPane.PLAIN_MESSAGE);
         try {
          //prints feedback to file
          PrintWriter outputFile = new PrintWriter("src/feedback.txt");
          outputFile.println(result);
          outputFile.close(); 
        }
        catch (FileNotFoundException a) {
          //in case file not found
          System.out.println("No file has been found. Please verify that there is a feedback.txt in the src folder.");
          
        }
      }
    }
  }
}

