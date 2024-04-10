import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Cason extends JFrame {
    private String[] wordBank = {"mercury", "venus", "earth", "mars", "jupiter", "saturn", "uranus", "neptune"};
    private String selected_word;
    private StringBuilder current_guess;
    private int incorrect_guess;
    private JLabel wordLabel;
    private JLabel hangmanImageLabel;
    private JTextField letterInputField;
    private JButton guessButton;

    private static final int NUMBER_OF_INCORRECT_GUESSES = 6;

    /* HIGH LEVEL FUNC */
    /*************************************************************/
    /*************************************************************/
    public Cason()
    {
        setTitle("Hangman");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 600);
        initializeGame();
        wordLabel = new JLabel(getCurrentWordState());
        hangmanImageLabel = new JLabel();
        updateHangmanIMG();

        letterInputField = new JTextField(1);
        guessButton = new JButton("Guess");
        guessButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                processUserGuess();
            }
        });
        /* NEW LAYOUT */
        setLayout(new GridLayout(2, 1));
        add(wordLabel);
        add(hangmanImageLabel);

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter a letter: "));
        inputPanel.add(letterInputField);
        inputPanel.add(guessButton);
        add(inputPanel);

        /* SET VISIBLE */
        setVisible(true);
    }

    /* INITIALIZE GAME */
    private void initializeGame()
    {
        Random random = new Random();
        selected_word = wordBank[random.nextInt(wordBank.length)];
        current_guess = new StringBuilder("_".repeat(selected_word.length()));
        incorrect_guess = 0;
    }

    /* HELPER FUNCTION */
    private String getCurrentWordState()
    {
        return current_guess.toString();
    }

    /* CHANGE IMAGE */
    private void updateHangmanIMG()
    {
        try {
            Image image = ImageIO.read(new File(getHangmanIMGPath(incorrect_guess)));

            // Set the size of the JLabel to match the size of the image
            hangmanImageLabel.setIcon(new ImageIcon(image));
            hangmanImageLabel.setSize(new Dimension(image.getWidth(null), image.getHeight(null)));
            hangmanImageLabel.setPreferredSize(new Dimension(image.getWidth(null), image.getHeight(null)));

            // Repaint the JLabel to reflect the changes
            hangmanImageLabel.revalidate();
            hangmanImageLabel.repaint();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*************************************************************/
    /*************************************************************/



    /* PATH FOR IMAGES */
    private String getHangmanIMGPath(int incorrect_guess)
    {
        switch (incorrect_guess)
        {
            case 0:
                return "C:/Users/cason/OneDrive/Documents/GitHub/csce708finalproject/hangman6.jpg";
            case 1:
                return "C:/Users/cason/OneDrive/Documents/GitHub/csce708finalproject/hangman0.jpg";
            case 2:
                return "C:/Users/cason/OneDrive/Documents/GitHub/csce708finalproject/hangman0.jpg";
            case 3:
                return "C:/Users/cason/OneDrive/Documents/GitHub/csce708finalproject/hangman0.jpg";
            case 4:
                return "C:/Users/cason/OneDrive/Documents/GitHub/csce708finalproject/hangman0.jpg";
            case 5:
                return "C:/Users/cason/OneDrive/Documents/GitHub/csce708finalproject/hangman0.jpg";
            case 6:
                return "C:/Users/cason/OneDrive/Documents/GitHub/csce708finalproject/hangman0.jpg";
            default:
                return "C:/Users/cason/OneDrive/Documents/GitHub/csce708finalproject/hangman6.jpg";
        }
    }
    /*************************************************************/
    /*************************************************************/



    /* FUNCTION LOGIC FOR GUESS */
    /*************************************************************/
    /*************************************************************/
    private void processUserGuess()
    {
        String input = letterInputField.getText().toLowerCase();

        if (input.length() != 1 || !Character.isLetter(input.charAt(0)))
        {
            JOptionPane.showMessageDialog(this, "Please enter a valid single letter.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }

        char guessedLetter = input.charAt(0);

        if (selected_word.contains(String.valueOf(guessedLetter))) {
            updateCurrentGuess(guessedLetter);
        } else {
            incorrect_guess++;
            updateHangmanIMG();
        }

        if (current_guess.toString().equals(selected_word) || incorrect_guess >= NUMBER_OF_INCORRECT_GUESSES) {
            endGame();
        }

        wordLabel.setText(getCurrentWordState());
        letterInputField.setText("");
    }

    private void updateCurrentGuess(char guessedLetter) {
        for (int i = 0; i < selected_word.length(); i++) {
            if (selected_word.charAt(i) == guessedLetter) {
                current_guess.setCharAt(i, guessedLetter);
            }
        }
    }
    /*************************************************************/
    /*************************************************************/



    /* END THE GAME */
    /*************************************************************/
    /*************************************************************/
    private void endGame()
    {
        if (current_guess.toString().equals(selected_word))
        {
            JOptionPane.showMessageDialog(this, "Congratulations! You guessed the word: " + selected_word, "Game Over", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Sorry, you ran out of attempts. The word was: " + selected_word, "Game Over", JOptionPane.INFORMATION_MESSAGE);
        }

        initializeGame();
        wordLabel.setText(getCurrentWordState());
        letterInputField.setText("");
        incorrect_guess = 0;
        updateHangmanIMG();
    }
    /*************************************************************/
    /*************************************************************/



    /* MAIN FUNCTION TO RUN MY GAME */
    /*************************************************************/
    /*************************************************************/
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable(){@Override public void run(){ new Cason();}});
    }
}