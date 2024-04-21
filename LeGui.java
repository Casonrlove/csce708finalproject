/**
 * Emmanuel Tobias Ramirez
 * CSCE 111 Final Project
 * GUI Constructor and Game
 */

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class LeGui extends JFrame implements ActionListener{

    ImageIcon image1;
    JLabel label1image;
    static JTextArea textArea2;
    JButton shootButton;
    JButton passButton;
    JButton layupButton;
    JButton blockButton;
    JButton stealButton;
    JButton swatButton;
    JScrollPane scrollpane;
    static JTextArea scoreboard;
    JTextField TextField5;
    int y;
    int x;
    int count = 0;
    Le user;
    Le opp;
    
    ImageIcon image4;
    JLabel image4label;
    ImageIcon image5;
    JLabel image5label;
    GridBagConstraints positionConst = null;

    LeGui(){

    // Constructor for the GUI Frame
    setTitle("Emmanuel Tobias");

    image1 = new ImageIcon(getClass().getResource("space.png"));
    label1image = new JLabel(image1);


    textArea2 = new JTextArea(30, 50);
    textArea2.setLineWrap(true);
    textArea2.setWrapStyleWord(true);
    textArea2.setEditable(false);

    scrollpane = new JScrollPane(textArea2);
    scrollpane.setPreferredSize(new Dimension(500, 500));

    shootButton = new JButton("Shoot");
    shootButton.addActionListener(this);
    passButton = new JButton("Pass");
    passButton.addActionListener(this);
    layupButton = new JButton("Layup");
    layupButton.addActionListener(this);
    blockButton = new JButton("Block");
    blockButton.addActionListener(this);
    stealButton = new JButton("Steal");
    stealButton.addActionListener(this);
    swatButton = new JButton("Swat");
    swatButton.addActionListener(this);

    scoreboard = new JTextArea(2, 1);
    scoreboard.setText("Home: 0\nAway: 0");
    scoreboard.setFont(new Font("Comic Sans",Font.PLAIN, 60));

    TextField5 = new JTextField();

    image4 = new ImageIcon(getClass().getResource("lebron.gif"));
    image4label = new JLabel(image4);

    image5 = new ImageIcon(getClass().getResource("michael.gif"));
    image5label = new JLabel(image5);

    // Use a GridBagLayout
    setLayout(new GridBagLayout());
    positionConst = new GridBagConstraints();
    
    positionConst.gridx = 1;
    positionConst.gridy = 0;
    add(label1image, positionConst);

    positionConst.gridx = 0;
    positionConst.gridy = 1;
    positionConst.insets = new Insets(10, 10, 10, 10);
    add(scrollpane, positionConst);

    positionConst.gridx = 0;
    positionConst.gridy = 3;
    positionConst.insets = new Insets(10, 10, 10, 10);
    add(shootButton, positionConst);
    positionConst.gridx = 0;
    positionConst.gridy = 4;
    positionConst.insets = new Insets(10, 10, 10, 10);
    add(passButton, positionConst);
    positionConst.gridx = 0;
    positionConst.gridy = 5;
    positionConst.insets = new Insets(10, 10, 10, 10);
    add(layupButton, positionConst);
    positionConst.gridx = 1;
    positionConst.gridy = 3;
    positionConst.insets = new Insets(10, 10, 10, 10);
    add(blockButton, positionConst);
    positionConst.gridx = 1;
    positionConst.gridy = 4;
    positionConst.insets = new Insets(10, 10, 10, 10);
    add(stealButton, positionConst);
    positionConst.gridx = 1;
    positionConst.gridy = 5;
    positionConst.insets = new Insets(10, 10, 10, 10);
    add(swatButton, positionConst);

    positionConst.gridx = 1;
    positionConst.gridy = 1;
    positionConst.insets = new Insets(10, 10, 10, 10);
    add(scoreboard, positionConst);

    positionConst.gridx = 0;
    positionConst.gridy = 0;
    add(image4label, positionConst);

    positionConst.gridx = 2;
    positionConst.gridy = 0;
    add(image5label,positionConst);
    }


    public static void main(String[] args) {
        LeGui LeGui = new LeGui();
        LeGui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        LeGui.pack();
        LeGui.setVisible(true);

        textArea2.append("Welcome to LeSpaceJam!!!");
        textArea2.append("\nPick Michael J. Jordan (Shoot) or LeGoat (Pass) or my Roommate (Layup): ");
        int y = 0;
        int x;
        int count = 0;
    }

    // THIS IS THE MAIN THIS IS WHAT HAPPENS WHEN A BUTTON IS PRESSED
    @Override
    public void actionPerformed(ActionEvent e) {

        String[] offenseOptions = new String[]{"Shoot","Pass", "Layup"};
        String offenseMenu = "1. Shoot\n2. Pass\n3. Layup";
        String[] defenseOptions = new String[]{"Block","Steal","Swat"};
        String defenseMenu = "1. Block\n2. Steal\n3. Swat";
        Random rand = new Random();

        if (count == 0) {
            if (e.getSource() == shootButton) {
                y = 1;
            }
            else if (e.getSource() == passButton) {
                y = 2;
            }
            else if (e.getSource() == layupButton) {
                y = 3;
            }
            count++;
            // initializes userPlayer
            String userPlayer = "";
            String oppPlayer = "";
            switch (y) {
                case 1:
                userPlayer = "Michael Jordan";
                oppPlayer = "LeBron James";
                    break;
                case 2:
                userPlayer = "LeBron James";
                oppPlayer = "Michael Jordan";
                    break;
                case 3:
                userPlayer = "Cristian";
                oppPlayer = "Goonster";
                    break;
            }
            // make Le constructors, offense/defense menus, and rules text
            user = new Le(userPlayer, 0);
            opp = new Le(oppPlayer, 0);
            // Create Menu
            // rules of LeGame
            textArea2.append("\nHowdy " + userPlayer + "!\n");
            String rulesText = 
            """
            Rules of the Game!
            First to 21 Points Wins!
            Offense can: Shoot, Pass or Layup
            Defense can: Block, Steal, or Swat
            Block beats Shoot
            Steal beats Pass
            Swat beats Layup
            Outplay your opponent! Good Luck and Have Fun!!!
            """;
            textArea2.append(rulesText);
            textArea2.append("\n" + user.getName() + ", it's your turn on offense! Pick a move:\n" + offenseMenu);

        }
        else if (count != 0) {
            if (count % 2 != 0) { // on offense
                textArea2.append("\nYou chose to " + offenseOptions[x]);
                int rX = rand.nextInt(1,4) - 1;
                textArea2.append("\n" + opp.getName() + " chose to " + defenseOptions[rX]);
                // check if defense beat offense
                if (x == rX) {
                    textArea2.append("\nOof!! The defense used " + defenseOptions[x] + " to mess up your " + offenseOptions[x] + "\nTheir ball now...");
                    count++;
                    textArea2.append("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    textArea2.append("\n" + user.getName() + ", you're on defense! Pick a move:\n" + defenseMenu);
                } else {
                    switch (x) {
                        case 0: // shoot
                            textArea2.append("\nNice! You shoot for 3 and made it!");
                            textArea2.append("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                            textArea2.append("\n" + user.getName() + ", you're on defense! Pick a move:\n" + defenseMenu);
                            user.addThree();
                            count += 1;    
                            break;
                        case 1: // pass
                        textArea2.append("\nYou passed the ball to your teammate.");
                            break;                   
                        case 2: // layup
                            textArea2.append("\nNice! You went for a layup and got 2 points!");
                            textArea2.append("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                            textArea2.append("\n" + user.getName() + ", you're on defense! Pick a move:\n" + defenseMenu);
                            user.addTwo();
                            count += 1;    
                            break;
                    }
                }


                
            } else if (count % 2 == 0) { // on defense
                textArea2.append("\nYou chose to " + defenseOptions[x]);
                int rX = rand.nextInt(1,4) - 1;
                textArea2.append("\n" + opp.getName() + " chose to " + offenseOptions[rX]);
                // check if your defense beat their offense
                if (x == rX) {
                    textArea2.append("\nNice!! You used " + defenseOptions[x] + " to mess up their " + offenseOptions[x] + "\nYour ball now!");
                    textArea2.append("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    textArea2.append("\n" + user.getName() + ", it's your turn on offense! Pick a move:\n" + offenseMenu);  
                    count++;             
                } else {
                    switch (rX) {
                        case 0: // shoot
                            textArea2.append("\nTough! You left them open for a 3 and they made it...");
                            textArea2.append("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                            textArea2.append("\n" +user.getName() + ", it's your turn on offense! Pick a move:\n" + offenseMenu); 
                            opp.addThree();
                            count += 1;    
                            break;
                        case 1: // pass
                        textArea2.append("\nThey passed the ball to their teammate...");                   
                        case 2: // layup
                            textArea2.append("\nYikes! They got a layup and 2 points from it...");
                            textArea2.append("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                            textArea2.append("\n" + user.getName() + ", it's your turn on offense! Pick a move:\n" + offenseMenu); 
                            opp.addTwo();
                            count += 1;   
                            break;
                    }
                }
            }
            if (user.winner() == true || opp.winner() == true) {
                textArea2.append("\nHoly moly someone won!");
            }
            }
        scoreboard.setText("Home: " + user.getPoints() + "\nAway: " + opp.getPoints());                     
}





} // while loop gameplay ends here
        // TODO: do the thing that happens when the game is won

