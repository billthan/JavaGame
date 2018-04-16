/*
 * ZHANG FEI and BILL THAN
 * 2/10/2017
 * WAR GAME
 * 
 * main Class
 * Stores the main menu, and provides the user with GUI
 * 
 */

import java.awt.GridLayout;
import javax.swing.border.BevelBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class main
{
  //frame, is static can be accessed by any other class
  static JFrame f; 
  //fonts for use
  Font font = new Font("Segoe", Font.BOLD, 25);
  Font font2 = new Font("Segoe", Font.PLAIN, 15);
  Font font3 = new Font("Segoe", Font.BOLD, 20);

  //initializes boundaries for GBL
  GridBagConstraints c = new GridBagConstraints();
  
  //JPanel
  static JPanel panel = new JPanel(new GridBagLayout());
  
  //setting up frame
  public main()
  { 
    
    MenuBar menu = new MenuBar();
    //setting up frame
    f = new JFrame("War Game!");
    f.setSize(600, 800);
    f.setLocationRelativeTo(null);
    f.setResizable(false);
    f.setLayout(new BorderLayout());
    
    
    //making menubar
    menu.makeMenu();
    menu.settingAction();
    
    //title
    JLabel mainTitle = new JLabel("<html><center>Welcome to War!<br></center></html>");
    mainTitle.setFont(font);
    
    //text
    JLabel title = new JLabel("<html><center>Please select one of the following options!<br></center></html>");
    title.setFont(font2);
    
    //button + actionlistner > to MakeDeck2 class
    JButton btnGet = new JButton("Play");
    btnGet.addActionListener (
                              new ActionListener() {
      
      public void actionPerformed(ActionEvent e) {
        //closes frame
        f.dispose();
        //calls makeDeck class1
        MakeDeck2 deck = new MakeDeck2();
        deck.makeDeck();

      }
    });
    //instructions button
    JButton btnGet2 = new JButton("Instructions");
    btnGet2.addActionListener (
                               new ActionListener() {
      
      public void actionPerformed(ActionEvent e) {
        //removes panel
        panel.removeAll();
        panel.revalidate();
        panel.repaint(); 
        
        //title
        JLabel title = new JLabel("<html><center>How to play War<br></center></html>");
        title.setFont(font);
        
        //text that shows instructions
        String html = 
          "<html><body width='400px'><p align='justify'>" +
          "The deck is divided evenly, with each player receiving 26 cards, dealt one at a time, face down. Each player turns up a card at the same time and the player with the higher card takes both cards and puts them, face down, on the bottom of his stack. If the cards are the same rank, it is War. Each player turns up one card face down and one card face up. The player with the higher cards takes both piles. The game ends when one player has won all the cards." +
          "</body></html>";
        JLabel label = new JLabel(html);
        //Continue button
        JButton continueButton = new JButton("Continue");
        continueButton.setFont(font2); 
        
         JButton btnGet2 = new JButton("Instructions");
   continueButton.addActionListener (
                              new ActionListener() {
      
      public void actionPerformed(ActionEvent e) {
        
        MakeDeck2 deck = new MakeDeck2();
                
        f.dispose();
        new main();
      }
    });
   
        //Sets position in GridBagLayout                         
        c.gridy = 0;
        panel.add(title, c);
        
        c.gridy = 1;
        panel.add(label, c);
        
        c.gridy = 3;
        panel.add(continueButton, c);
         
        f.add(panel);    
        panel.revalidate();   
        
      }
    });
    
    //bottom text
    JLabel text = new JLabel("have fun!");
    title.setFont(font2);
    
    //insets creates boundaries
    c.insets = new Insets(3, 3, 3, 3);
    c.gridx = 0;
    c.gridy = 0;
    
    panel.add(mainTitle, c);
    //adds components
    c.gridy = 1;
    panel.add(title, c);
    
    c.gridy = 2;
    panel.add(btnGet, c);
    
    c.gridy = 3;
    panel.add(btnGet2, c);
    
    
    c.gridy = 4;
    panel.add(text, c);
    
    //add panel to frame
    f.add(panel);
    f.setVisible(true);   
  }
  
  public static void main(String [] args)
  {
    //main, runs code starting at culminatingMain class
    new main(); 
    
  }
}