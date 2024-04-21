/**
 * Prisha Sharma
 * 2148855326
 * CSCE 111
 * 4/21/2024
 */

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class PersonalityPlanetGame extends JFrame {
    // Initializes the scores and comboBoxes lists to manage the quiz data.
    public List<Integer> scores = new ArrayList<>(Arrays.asList(new Integer[9])); // Initialize scores for nine planets
    public List<JComboBox<String>> comboBoxes = new ArrayList<>();

    public PersonalityPlanetGame() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Ensures the program exits when the window is closed.
        setSize(800, 600); // Sets the size of the window.
        setTitle("Find Your Planet"); // Sets the title of the window.
        setLocationRelativeTo(null); // Centers the window on the screen.

        setLayout(new BorderLayout()); // Sets the layout manager for the JFrame.
        getContentPane().setBackground(new Color(240, 240, 255)); // Sets a light purple background for the frame.

        

        JPanel questionPanel = new JPanel();
        questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.Y_AXIS));
        questionPanel.setBackground(new Color(230, 230, 250)); // Sets a slightly darker purple background for the question panel.

        // Array of questions, options, and image paths
        String[] questions = {
            "Choose your ideal vacation: Adventure in unknown territories, relaxation by the sea, or a historical tour?",
            "At a party, are you the quiet observer, the life of the party, or the planner?",
            "Do you prefer the warmth of the sun, the cold of the snow, or the calm of the night?",
            "Do you lead, follow, or strike out alone?",
            "What's your favorite type of movie: Action, Mystery, Sci-Fi, Fantasy, or Documentary?"
        };
        String[][] options = {
            {"Adventure", "Relaxation", "Historical"},
            {"Observer", "Life of the party", "Planner"},
            {"Warmth", "Cold", "Calm"},
            {"Lead", "Follow", "Alone"},
            {"Action", "Mystery", "Sci-Fi", "Fantasy", "Documentary"}
        };
        String[] imagePaths = {
            "pic1.JPG",  // Path to the image for the first question
            "pic2.JPG",     // Path to the image for the second question
            "pic3.JPG", // Path to the image for the third question
            "pic4.JPG",// Path to the image for the fourth question
            "pic5.JPG"     // Path to the image for the fifth question
        };

        // Loops through each question to create UI elements - combobox and images.
        for (int i = 0; i < questions.length; i++) {
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout(FlowLayout.LEFT));
            panel.setBackground(new Color(220, 220, 250)); // Even darker purple for each question panel
            JLabel label = new JLabel("<html><div style='width:400px;'>" + questions[i] + "</div></html>");
            label.setForeground(new Color(50, 50, 80)); // Dark blue font color for labels
            JComboBox<String> comboBox = new JComboBox<>(options[i]);
            comboBoxes.add(comboBox);
            // Load image
            try {
                Image image = ImageIO.read(new File(imagePaths[i]));
                ImageIcon imageIcon = new ImageIcon(image);
                JLabel imageLabel = new JLabel(new ImageIcon(imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
                panel.add(imageLabel);

            } catch (IOException e) {
                // Handles potential errors during image loading.
                e.printStackTrace();
            }


            
            panel.add(label);
            panel.add(comboBox);
            questionPanel.add(panel);
        }
        // Submit button configuration.
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> confirmSubmission());
        submitButton.setBackground(new Color(100, 100, 255)); // Sets the button color.
        submitButton.setForeground(Color.BLACK); // Sets the button text color.
        submitButton.setFocusPainted(false);
        submitButton.setFont(new Font("Arial", Font.BOLD, 12));

        add(questionPanel, BorderLayout.CENTER);
        add(submitButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void confirmSubmission() {
        int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to submit your answers?", "Confirm Submission", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            processAnswers(); // Processes answers if the user confirms.
        }
    }

    private void processAnswers() {
        Collections.fill(scores, 0); // Resets scores before calculating.

        for (int i = 0; i < comboBoxes.size(); i++) {
            int selectedIndex = comboBoxes.get(i).getSelectedIndex();
            scores.set(selectedIndex, scores.get(selectedIndex) + 1);
        }

        // Determines the planet with the highest score and displays the result.
        int maxIndex = scores.indexOf(Collections.max(scores));
        String[] planets = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto"};
        String[] descriptions = {
            "Mercury: Dynamic and quick, ideal for those who love rapid changes and intellectual pursuits.",
            "Venus: Perfect for lovers of beauty, harmony, and peace.",
            "Earth: Ideal for those who seek balance and appreciate nature and humanity.",
            "Mars: Best for the adventurous, energetic, and pioneering spirits.",
            "Jupiter: Suited for those who love knowledge, travel, and philosophy.",
            "Saturn: Matches well with disciplined, patient, and meticulous individuals.",
            "Uranus: Fits innovators and those who defy conventions.",
            "Neptune: Ideal for dreamers, creatives, and spiritual souls.",
            "Pluto: Perfect for those who embrace transformation and challenge."
        };

        JOptionPane.showMessageDialog(this,
            "<html>Your planet: " + planets[maxIndex] + "<br>" + descriptions[maxIndex] + "</html>",
            "Your Result",
            JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new PersonalityPlanetGame(); // Starts the application.
    }
}
