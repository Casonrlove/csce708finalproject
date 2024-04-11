import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Point;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.Color;

public class DanielClass extends JPanel implements ActionListener, MouseListener{
 
    public static void main(String args[]){

        JFrame appFrame = new JFrame();  // Create a Frame object
        
        DanielClass hc1 = new DanielClass(); // Instantiate your Panel

        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set default close operation
        appFrame.setLocationRelativeTo(null); // Set default location to center of screen
        appFrame.setTitle("Outpost Builder"); // Updated title
        appFrame.setSize(700, 600); // frame size

        appFrame.add(hc1); // Add the histogram component to the frame    
        //appFrame.getContentPane().setBackground(Color.DARK_GRAY); // Set background color of the content pane

    

        //DanielOutpostCanvas outpostCavas = new DanielOutpostCanvas();
        //appFrame.add(outpostCavas);

        appFrame.setVisible(true); // Make the frame visible


    }

    DanielOutpostCanvas outpostCanvas;
    JButton clearOutpost;
    JButton togglePenColor;

    public DanielClass () {
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        //this.setBackground(Color.DARK_GRAY);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx = 1;
        constraints.gridx=0; // Input 1 Label Constraints
        constraints.gridy=0;
        JLabel label = new JLabel(" You discovered a new planet and must now create an outpost on your new planet.\n Draw on the canvas below to create your outpost.");
        this.add(label,constraints);

        constraints.gridx=0; // Input 1 Label Constraints
        constraints.gridy=1;
        this.togglePenColor = new JButton("Toggle Pen Color");
        this.togglePenColor.addActionListener(this);

        this.add(togglePenColor,constraints);

        constraints.gridx=1; // Input 1 Label Constraints
        constraints.gridy=1;
        this.clearOutpost = new JButton("Clear");
        this.clearOutpost.addActionListener(this);
        this.add(clearOutpost,constraints);


        constraints.gridx=0; // Input 1 Label Constraints
        constraints.gridy=2;
        this.outpostCanvas = new DanielOutpostCanvas();

        //outpostCavas.setBounds(50,50,200,200);
        this.add(this.outpostCanvas,constraints);

        this.outpostCanvas.addMouseListener(this);
        
        Point mousePos = this.outpostCanvas.getMousePosition();
        if (mousePos != null) {
            final int mouseX = mousePos.x;
            final int mouseY = mousePos.y;
            
            System.out.println(mouseX);
            System.out.println(mouseY);
        } 
    }

    public void actionPerformed (ActionEvent e){
        if(e.getSource() == this.clearOutpost){
            System.out.println("Clear");
            this.outpostCanvas.clearBlocksColor();
            this.repaint();

        } else if(e.getSource() == this.togglePenColor){
            System.out.println("Toggle");
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //System.out.println("Canvas Clicked");
    }

    public void mouseExited(MouseEvent e) {
        //System.out.println("Canvas Exited");
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        System.out.println("MousePressed");

        Point mousePos = this.outpostCanvas.getMousePosition();
        if (mousePos != null) {
            final int mouseX = mousePos.x;
            final int mouseY = mousePos.y;
            
            int blockX = mouseX/this.outpostCanvas.BLOCK_WIDTH ;
            int blockY = mouseY/this.outpostCanvas.BLOCK_WIDTH;
            Color blockColor = this.outpostCanvas.FILL_BLOCK_COLOR;

            this.outpostCanvas.updateBlockColor(blockX, blockY, blockColor);

            this.repaint();

            System.out.println(mouseX + " " + mouseY);
            System.out.println(mouseX/this.outpostCanvas.BLOCK_WIDTH + " " + mouseY/this.outpostCanvas.BLOCK_WIDTH);
  
        } else {
            System.out.println("Mouse Null");
        }
    }

    
}
