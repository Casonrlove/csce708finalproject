/**
 * Daniel Beltran
 * 827004197
 * CSCE 708 - 600
 * 4/11/2024
 */

// Layout Imports
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

// Event Listeners
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Point;

// Text Styling
import java.awt.Font;

// Gui JComponents 
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;

// This class handles Button Clicks (For Buttons) events and Mouse Events(For Canvas)
public class DanielClass extends JPanel implements ActionListener, MouseListener{
 
    // Class Variables
    DanielOutpostCanvas outpostCanvas;
    JButton clearOutpost;
    JButton togglePenColor;
    Color canvasPenColor;

    // Main Function
    public static void main(String args[]){

        JFrame appFrame = new JFrame();  // Create a Frame object
        
        DanielClass outpostBuilder = new DanielClass(); // Instantiate your Panel

        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set default close operation
        appFrame.setLocationRelativeTo(null); // Set default location to center of screen
        appFrame.setTitle("Outpost Builder"); // Updated title
        appFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Frame Full Screen


        appFrame.add(outpostBuilder); // outpostBuilderPanel to Frame  
        appFrame.setVisible(true); // Make the frame visible

    } // End of Main

    // Constructor
    public DanielClass () {

        // Create Layout
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        this.setBackground(Color.GRAY);
    
        GridBagConstraints constraints = new GridBagConstraints();

        // Title Label
        constraints.weightx = 1;
        constraints.gridx=0; // Input 1 Label Constraints
        constraints.gridy=0;
        constraints.gridwidth =2;
        JLabel titleLabel = new JLabel("Outpost Builder");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        this.add(titleLabel,constraints);

        // Info Label
        constraints.weightx = 1;
        constraints.gridx=0; // Input 1 Label Constraints
        constraints.gridy=1;
        constraints.gridwidth =2;
        JLabel infoLabel = new JLabel("You discovered a new planet and must now build an outpost on your new planet. Draw on the canvas by clicking below to create your outpost.");
        infoLabel.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(infoLabel,constraints);

        // Toggle Canvas Pen Color Button
        constraints.gridx=0; 
        constraints.gridy=2;
        constraints.gridwidth =1;
        constraints.anchor = GridBagConstraints.EAST;
        constraints.insets = new Insets(10,10,10,10);
        this.togglePenColor = new JButton("Toggle Pen Color:Black");
        this.togglePenColor.addActionListener(this);    // Add Button Click Event
        this.add(togglePenColor,constraints);

        // Clear Canvas Button
        constraints.gridx=1; 
        constraints.gridy=2;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10,10,10,10);
        this.clearOutpost = new JButton("Clear");
        this.clearOutpost.addActionListener(this);      // Add Button Click Event
        this.add(clearOutpost,constraints);

        // Canvas 
        constraints.gridx=0; 
        constraints.gridy=3;
        constraints.gridwidth =2;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(0,0,0,0);
        this.outpostCanvas = new DanielOutpostCanvas();
        this.add(this.outpostCanvas,constraints);

        this.outpostCanvas.addMouseListener(this); // Add Mouse Click Listener on Canvas

        this.canvasPenColor = this.outpostCanvas.FILL_BLOCK_COLOR; // Default Pen Color
        
    }

    // Button Click Event
    public void actionPerformed (ActionEvent e){

        // Determine which button is clicked
        if(e.getSource() == this.clearOutpost){
         
            this.outpostCanvas.clearBlocksColor();
            this.repaint();

        } else if(e.getSource() == this.togglePenColor){
            
            // Toggle Pen Color
            if(this.canvasPenColor == this.outpostCanvas.EMPTY_BLOCK_COLOR){
                this.canvasPenColor = this.outpostCanvas.FILL_BLOCK_COLOR;
                this.togglePenColor.setText("Toggle Pen Color:Black");
            }else {
                this.canvasPenColor = this.outpostCanvas.EMPTY_BLOCK_COLOR;
                this.togglePenColor.setText("Toggle Pen Color:White");
            }
        }
    } // End of Button Click Event


    /******************************** Mouse Events Overrides Below ***************************************/
    
    
    /**
     * MousePressed Override retreives Current Mouse Position in canvas, 
     * determines which block mouse is on,
     * then updates the color of that block
     */
    public void mousePressed(MouseEvent e) {
        
        // Retreive Mouse Position
        Point mousePos = this.outpostCanvas.getMousePosition();
        if (mousePos != null) {
            
            // Determine which block mouse is on 
            final int mouseX = mousePos.x;
            final int mouseY = mousePos.y;
            
            int blockX = mouseX/this.outpostCanvas.BLOCK_WIDTH ;
            int blockY = mouseY/this.outpostCanvas.BLOCK_WIDTH;

            Color blockColor = this.outpostCanvas.FILL_BLOCK_COLOR;

            // Update Color of Box
            this.outpostCanvas.updateBlockColor(blockX, blockY, this.canvasPenColor);

            // Remake the canvas with the updated block color
            this.repaint();

        } else {
            

        }
    } // End of mousePressed
    
    // Had to override below due to issues if I didnt.
    @Override
    public void mouseClicked(MouseEvent e) {
        //System.out.println("Canvas Clicked");
    }

    public void mouseExited(MouseEvent e) {
        //System.out.println("Canvas Exited");
    }

    public void mouseEntered(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}
    
} // End of DanielClass
