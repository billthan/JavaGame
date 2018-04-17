
/*
 * ZHANG FEI and BILL THAN
 * 2/10/2017
 * WAR GAME
 * 
 * MakeDeck2 Class
 * Makes deck, stores user values and determines a winner.
 * 
 */

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MakeDeck2 {

	// runs game
	public int cont = 1;
	// frame, is static can be accessed by any other class
	JFrame f = main.f;
	// fonts for use
	Font font = new Font("Segoe", Font.BOLD, 25);
	Font font2 = new Font("Segoe", Font.PLAIN, 15);
	Font font3 = new Font("Segoe", Font.BOLD, 20);

	// initializes boundaries for GBL
	GridBagConstraints c = new GridBagConstraints();

	// JPanel
	static JPanel newPanel = new JPanel(new GridBagLayout());
	static JPanel bottomPanel = new JPanel();

	Scanner input = new Scanner(System.in);
	Random rand = new Random();

	// ArrayList Declaration
	ArrayList<Integer> player1 = new ArrayList<Integer>();
	ArrayList<Integer> player2 = new ArrayList<Integer>();

	String user;

	public void makeGameFrame() {

		makeDeck();
		newPanel = new JPanel(new GridBagLayout());

		JLabel welcomeTitle = new JLabel(
				"You have " + player1.size() + " cards. Computer has " + player2.size() + " cards.");
		welcomeTitle.setFont(font3);
		
		//button to start
	    JButton pick = new JButton("Pick card");
	    pick.addActionListener (
	                              new ActionListener() {
	      
	      public void actionPerformed(ActionEvent e) {
	    	  t.start();
	      }
	    });
		c.insets = new Insets(3, 3, 3, 3);
		c.gridy = 0;
		c.gridx = 0;
		newPanel.add(welcomeTitle, c);
		c.gridy = 1;
		newPanel.add(pick, c);

		c.gridy = 1;
		c.gridy = GridBagConstraints.RELATIVE;
		f.add(newPanel);
		f.getContentPane().revalidate();
	}
		
	public void lowerPanel(String text) {
		JLabel info = new JLabel(text);
		bottomPanel.add(info);
		f.add(bottomPanel, 1);
		f.getContentPane().revalidate();
	}
	
	public void newPanel(String text) {
    
		JLabel welcomeTitle = new JLabel(
				text);
		welcomeTitle.setFont(font3);
		c.insets = new Insets(3, 3, 3, 3);
		c.gridy = 0;
		c.gridx = 0;
		newPanel.add(welcomeTitle, c);

		c.gridy = 1;
		c.gridy = GridBagConstraints.RELATIVE;
		f.add(newPanel, 0);
		f.getContentPane().revalidate();
	}

	public void changePanel(String text) {
		newPanel = new JPanel(new GridBagLayout());

		JLabel welcomeTitle = new JLabel(
				text);
		welcomeTitle.setFont(font3);
		c.insets = new Insets(3, 3, 3, 3);
		c.gridy = 0;
		c.gridx = 0;
		newPanel.add(welcomeTitle, c);

		c.gridy = 1;
		c.gridy = GridBagConstraints.RELATIVE;
		f.add(newPanel);
		f.getContentPane().revalidate();
	
	}

	// method that creates the decks for the two players
	public void makeDeck() {
		// loop that creates 26 cards for player 1
		for (int counter1 = 0; counter1 < 2; counter1++) {
			for (int counter = 0; counter < 13; counter++) {
				player1.add(counter);
			}
		}
		// loop that creates 26 cards for player 2
		for (int counter1 = 0; counter1 < 2; counter1++) {
			for (int counter = 0; counter < 13; counter++) {
				player2.add(counter);
			}
		}

		// shuffles cards for both players
		Collections.shuffle(player1);
		Collections.shuffle(player2);
		
	}
	
	Thread t = new Thread(new Runnable() {

		@Override
		public void run() {

			    //try and catch for the whole game
			    try{
			      //runs game
			      int cont = 1;
			      //runs game as long as player enters continue and each player still has cards left
			      while (cont == 1 && player1.size() != 0 && player2.size() != 0)
			      {
			        lowerPanel("You have " + player1.size() + " cards. Computer has " + player2.size() + " cards.");
			        Collections.shuffle(player1);
			        Collections.shuffle(player2);
			        
			        //first card of the list array is parsed to an int
			        int play1 = (Integer) player1.get(0);
			        int play2 = (Integer) player2.get(0);
			        
			        //compares first cards of both players
			        //displays cards of both players and adds both cards to player 1
			        if (play1 > play2)
			        {
			          
			          changePanel("Player 1 picked " + (player1.get(0) + 1) + " and player 2 picked " + (player2.get(0)+1) + ", player 1 wins");
			          //adds cards to winner
			          player1.add(player1.get(0));
			          player1.add(player2.get(0));
			          //removes first cards of both players
			          player1.remove(0);
			          player2.remove(0);
			          
			        }
			        //displays cards of both players and adds both cards to player 2
			        else if (play1 < play2)
			        {
			          
			        	changePanel("Player 1 picked " + (player1.get(0)+ 1) + " and player 2 picked " + (player2.get(0)+ 1) + ", player 2 wins");
			          //adds cards to winner
			          player2.add(player1.get(0));
			          player2.add(player2.get(0));
			          //removes first cards of both players
			          player1.remove(0);
			          player2.remove(0);
			        }
			        
			        //runs if both players pull the same card
			        else if (play1 == play2)
			        {
			          //runs if any of the players has less than 3 cards left
			          if (player1.size() < 4)
			          {
			        	  changePanel("Tie! \n Since Player 1 has less than four cards, Player 2 wins this game of War");
			            cont = 2;
			          }
			          else if (player2.size() < 4)
			          {
			        	  changePanel ("Tie! \n Since Player 2 has less than four cards, Player 1 wins this game of War");
			            cont = 2;
			          }
			          else
			          {
			            //displays cards
			        	  changePanel("Player 1 picked " + (player1.get(0)+ 1) + " and player 2 picked " + (player2.get(0)+ 1));
			            
			        	  changePanel("Tie!");
			            
			            //2D array that stores the next three cards of each player
			            int [][]tieCards = new int [2][3];
			            
			            //double for loop that sotres next three cards of each player
			            for (int row = 0; row < 2; row++)
			            {
			              for (int col = 0; col < 3; col++)
			              {
			                if (row == 0)
			                {
			                  tieCards[row][col] = player1.get(col+1);
			                }
			                else if (row == 1)
			                {
			                  tieCards[row][col] = player2.get(col+1);
			                }
			              }
			            }
			            
			            //displays the 3 cards that each player picked
			            changePanel("Player 1 picked up another 3 cards: \n" + (player1.get(1)+ 1) + "\n" + (player1.get(2)+ 1) + "\n" + (player1.get(3)+ 1) );
			            changePanel("Player 2 picked up another 3 cards: \n" + (player2.get(1)+ 1) + "\n" + (player2.get(2)+ 1) + "\n" + (player2.get(3)+ 1) );
			            
			            //adds up the 3 cards that each player picked
			            play1 = tieCards[0][0] + tieCards[0][1] + tieCards[0][2];
			            play2 = tieCards[1][0] + tieCards[1][1] + tieCards[1][2];
			            
			            //runs if the total of player 1's three cards is more than player 2
			            if (play1 > play2)
			            {
			            	changePanel ("Player 1 wins");
			              //for loop that adds the 8 cards that player 1 won
			              for (int counter = 0; counter < 4; counter++)
			              {
			                player1.add(player1.get(counter));
			                player1.add(player2.get(counter));
			              }
			              //removes the first 4 cards of each player
			              for (int counter = 0; counter < 4; counter++)
			              {
			                player1.remove(0);
			                player2.remove(0);
			              }
			              
			            }
			            //runs if the total of player 2's three cards is more than player 1
			            else if (play1 < play2)
			            {
			            	changePanel("Player 2 wins");
			              //for loop that adds the 8 cards that player 1 won
			              for (int counter = 0; counter < 4; counter++)
			              {
			                player2.add(player1.get(counter));
			                player2.add(player2.get(counter));
			              }
			              //removes the first 4 cards of each player
			              for (int counter = 0; counter < 4; counter++)
			              {
			                player1.remove(0);
			                player2.remove(0);
			              }
			            }
			            // runs if the total of both players are equal
			            else if (play1 == play2)
			            {
			              
			            	changePanel("It's a tie still");
			            }
			          }
			        }
			        //checks if user wants to play, or end game
			          do {
			          System.out.println ("Enter 1 to continue. 2 to exit game.");
			          user = input.nextLine();
			          
			          
			          } while ((!user.equalsIgnoreCase("1")) && (!user.equalsIgnoreCase("2")));
			         
			          if (user.equalsIgnoreCase("1")) {
			          cont = 1;
			          }
			          else if (user.equalsIgnoreCase("2")) {
			            cont = 2;
			          }
			       //2 ends game, 1 continues
			 
			         
			      }
			      
			      //runs if the player 1 has no cards left
			      if (player1.size() == 0)
			      {
			        changePanel ("Player 2 wins this game of War");
			      }
			      //runs if player 2 has no cards left
			      else if (player2.size() == 0)
			      {
			        changePanel ("Player 1 wins this game of War");
			      }
			      // ends game
			      else if (cont == 2)
			      {
			        changePanel("Player chose to quit the game");
			      }
			    }
			    catch (IndexOutOfBoundsException e)
			    {}
			 
		} });
    	  

}