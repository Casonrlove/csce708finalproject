/*
 * CSCE 708 Final Project
*/
import javax.swing.JFrame;
import java.awt.Color; // Import statement for Color

public class Viewer {
    public static void main(String[] args) {
        JFrame appFrame = new JFrame();  // Create a Frame object
        
        HistogramComponent hc1 = new HistogramComponent(); // Instantiate your HistogramComponent

        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set default close operation
        appFrame.setLocationRelativeTo(null); // Set default location to center of screen
        appFrame.setTitle("Space Theme"); // Updated title
        appFrame.setSize(700, 600); // frame size

        
        appFrame.getContentPane().setBackground(Color.DARK_GRAY); // Set background color of the content pane

        appFrame.add(hc1); // Add the histogram component to the frame

        appFrame.setVisible(true); // Make the frame visible
    }
}
