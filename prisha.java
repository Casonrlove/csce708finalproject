import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class prisha extends JFrame {
    private List<Integer> scores = new ArrayList<>(Arrays.asList(new Integer[9])); // Initialize scores for nine planets
    private List<JComboBox<String>> comboBoxes = new ArrayList<>();

    public PersonalityPlanetGame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setTitle("Find Your Planet");
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(240, 240, 255)); // Light purple background for the frame

        JPanel questionPanel = new JPanel();
        questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.Y_AXIS));
        questionPanel.setBackground(new Color(230, 230, 250)); // Slightly darker purple background for the question panel

        // Array of questions and options
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

        // Create a combobox for each question
        for (int i = 0; i < questions.length; i++) {
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout(FlowLayout.LEFT));
            panel.setBackground(new Color(220, 220, 250)); // Even darker purple for each question panel
            JLabel label = new JLabel("<html><div style='width:400px;'>" + questions[i] + "</div></html>");
            label.setForeground(new Color(50, 50, 80)); // Dark blue font color for labels
            JComboBox<String> comboBox = new JComboBox<>(options[i]);
            comboBoxes.add(comboBox);
            panel.add(label);
            panel.add(comboBox);
            questionPanel.add(panel);
        }

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> confirmSubmission());
        submitButton.setBackground(new Color(100, 100, 255)); // Blue color for the button
        submitButton.setForeground(Color.WHITE); // White text color
        submitButton.setFocusPainted(false);
        submitButton.setFont(new Font("Arial", Font.BOLD, 12));
        submitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                submitButton.setBackground(new Color(130, 130, 255)); // Lighter blue when hovered
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                submitButton.setBackground(new Color(100, 100, 255)); // Original blue when not hovered
            }
        });

        add(questionPanel, BorderLayout.CENTER);
        add(submitButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void confirmSubmission() {
        int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to submit your answers?", "Confirm Submission", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            processAnswers();
        }
    }

    private void processAnswers() {
        // Ensure scores are reset before calculating new scores
        Collections.fill(scores, 0); // Reset scores to zero correctly

        for (int i = 0; i < comboBoxes.size(); i++) {
            int selectedIndex = comboBoxes.get(i).getSelectedIndex();
            scores.set(selectedIndex, scores.get(selectedIndex) + 1);
        }

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

        // Display the result in a popup
        JOptionPane.showMessageDialog(this,
            "<html>Your planet: " + planets[maxIndex] + "<br>" + descriptions[maxIndex] + "</html>",
            "Your Result",
            JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new PersonalityPlanetGame();
    }
}