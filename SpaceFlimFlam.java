/* 
 * Jay Park
 * CSCE 111
 * UIN: 134002949
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpaceFlimFlam extends JFrame {
    private JLabel questionLabel; // label for the questions
    private JButton[] optionButtons; // will trigger each option to see if it's right or wrong

    //creates different arrays to store questions, the options for each question, and the answers to each question
    private String[] questionListArray = {
        "How close is the Sun to the Earth?", 
        "How long to evaporate a black hole?", 
        "What is one moon that orbits Uranus?", 
        "How many moons does Venus have?", 
        "Best candy in the universe?",
        "How old is the milky way?"
    };
    
    private String[][] questionOptionsArray = {
        {"93 million miles", "About six big football fields", "13 billion miles", "287 kilometers"}, 
        {"Before the water starts to boil", "800 santillion years", "10^67 years", "Never"}, 
        {"Demetrius", "Rebaron", "Quantasia", "Miranda"}, 
        {"27 moons", "0 moons", "-1 moons", "2 moons"}, 
        {"Twix", "Milky way(haha get it)", "Jolly ranchers", "Kitkat"},
        {"Older than me, probably", "Like 16 years old or something idk", "12 billion years old", "375 million years old"}
    };

    private String[] answerArray = {"93 million miles", "10^67 years", "Miranda", "0 moons", "Twix", "Older than me, probably"};
    private int currentQuestionIndex = 0; //used to keep track of the current question
    private int score = 0; //used to track the score to print at the end of the game

    public SpaceFlimFlam() {
        GridBagConstraints gridPosition = null; // specify the component layout for GUI

        //title of the game
        setTitle("Space Flimflam"); 

        //Using GridBagLayout
        setLayout(new GridBagLayout());
        gridPosition = new GridBagConstraints();

        //Grid location is specified
        gridPosition.gridx = 0;
        gridPosition.gridy = 0;

        //Pads 10 pixels around the components
        gridPosition.insets = new Insets(10, 10, 10, 10);

        //creates new JLabel to add question to JFrame
        questionLabel = new JLabel(questionListArray[currentQuestionIndex]);
        add(questionLabel, gridPosition);

        //creates new JLabel to add answer options to JFrame
        JPanel optionsPanel = new JPanel(new GridBagLayout());
        gridPosition.gridy = 1;
        add(optionsPanel, gridPosition);

        //optionButtons is initialized with length of the answer options for a specific question
        optionButtons = new JButton[questionOptionsArray[currentQuestionIndex].length];
        //goes through all the answer choices for the current question
        for (int i = 0; i < questionOptionsArray[currentQuestionIndex].length; i++) {

            //makes sure that each option to select is not overlapping onto one another, and pushes all the options to the left/west
            gridPosition.gridx = 0;
            gridPosition.gridy = i;
            gridPosition.anchor = GridBagConstraints.WEST;

            //A new JButton is created with the current answer option as the text and assigned into the optionbuttons array.
            optionButtons[i] = new JButton(questionOptionsArray[currentQuestionIndex][i]); 
            //ActionListener which calls the method checkAnswer when a user clicks on an answer option.
            optionButtons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent blah) {
                    checkAnswer(((JButton) blah.getSource()).getText());
                }
            });
            optionsPanel.add(optionButtons[i], gridPosition);
        }

        setVisible(true);
    }

    private void checkAnswer(String selectedOption) {

        //if the answer choice is equal to the actual answer inside the answer array, then the score is incremented by 1
        if (selectedOption.equals(answerArray[currentQuestionIndex])) {
            score++;
            JOptionPane.showMessageDialog(null, "Correct!", "SpaceFlimFlam", 1); //prints out that the answer choice chosen was correct
        } 
        
        //if the answer choice the user chooses is incorrect, then the score is not incremented
        else {
            JOptionPane.showMessageDialog(null, "Incorrect!", "SpaceFlimFlam", 0); //prints out that the answer choic chosen was incorrect.
        }

        currentQuestionIndex++; //increments question index so game will move onto the next question

        //if the current question index is less than the number of questions, game continues. If not, then the quiz ends, and the ending message is shown.
        if (currentQuestionIndex < questionListArray.length) { 
            questionLabel.setText(questionListArray[currentQuestionIndex]);
            for (int i = 0; i < questionOptionsArray[currentQuestionIndex].length; i++) {
                optionButtons[i].setText(questionOptionsArray[currentQuestionIndex][i]);
            }
        }
        
        else {
            JOptionPane.showMessageDialog(null, "You have finished the SpaceFlimFlam!\nYour score: " + score + " out of " + questionListArray.length, "SpaceFlimFlam", 1); //prints the score for the quiz
            System.exit(0); //exits game since quiz has ended.
        }

    }

    public static void main(String[] args) {
        // Creates SpaceFlimFlam as well as the components needed for it.
        SpaceFlimFlam spaceFlimFlam = new SpaceFlimFlam();

        spaceFlimFlam.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        spaceFlimFlam.setLocationRelativeTo(null);
        spaceFlimFlam.pack();
        spaceFlimFlam.setVisible(true);
    }
}
