import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.JButton;
import javax.swing.JComponent;

public class HistogramComponent extends JComponent {
    private JButton button_cason;
    private JButton button_daniel;
    private JButton button_emmanuel;
    private JButton button_jay;
    private JButton button_prisha;
    private JButton extra_button;
    private Font textFont = new Font("Arial", Font.BOLD, 20);
    private String text = "Space Frame ";

    public HistogramComponent() {
        button_cason = new JButton("cason");

        button_cason.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Start the cason game
                String[] args = {};
                Cason.main(args);
            }
        });
        button_daniel = new JButton("daniel");
        button_daniel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Start the daniel game
            }
        });
        button_emmanuel = new JButton("emmanuel");
        button_emmanuel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Start the emmanuel game
            }
        });
        button_jay = new JButton("jay");
        button_jay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Start the jay game
            }
        });
        button_prisha = new JButton("Prisha");
        button_prisha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Start the prisha game
            }
        });
        // Add buttons to component
        add(button_cason);
        add(button_daniel);
        add(button_emmanuel);
        add(button_jay);
        add(button_prisha);
        extra_button = new JButton("Space Website");
        extra_button.addActionListener(e -> openWebpage());
        add(extra_button);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D graphicsObj = (Graphics2D) g;

        // Fill the central area with sky blue color
        int width = (int) (this.getWidth() * 0.85);
        int height = (int) (this.getHeight() * 0.85);
        int x = (this.getWidth() - width) / 2;
        int y = (this.getHeight() - height) / 2;
        // Color skyBlue = new Color(135, 206, 235);
        graphicsObj.setColor(Color.GRAY);
        graphicsObj.fillRect(x, y, width, height);

        // Draw the centered text
        graphicsObj.setColor(Color.BLACK);
        graphicsObj.setFont(textFont);
        int textWidth = graphicsObj.getFontMetrics().stringWidth(text);
        int textX = (this.getWidth() - textWidth) / 2;
        int textY = y + 40;
        graphicsObj.drawString(text, textX, textY);

        // Position the buttons centered and under the text
        int buttonWidth = 125;
        int buttonHeight = 30;
        int spaceBetweenButtons = 10;
        int totalButtonWidth = 4 * buttonWidth + 3 * spaceBetweenButtons;
        int firstButtonX = (this.getWidth() - totalButtonWidth) / 2;

        button_cason.setBounds(firstButtonX, textY + 20, buttonWidth, buttonHeight);
        button_daniel.setBounds(firstButtonX + buttonWidth + spaceBetweenButtons, textY + 20, buttonWidth, buttonHeight);
        button_emmanuel.setBounds(firstButtonX + 2 * (buttonWidth + spaceBetweenButtons), textY + 20, buttonWidth,
                buttonHeight);
        button_jay.setBounds(firstButtonX + 3 * (buttonWidth + spaceBetweenButtons), textY + 20, buttonWidth,
                buttonHeight);
        button_prisha.setBounds((this.getWidth() - buttonWidth) / 2, textY + 60, buttonWidth,
        buttonHeight);
        int extra_buttonY = button_cason.getBounds().y + buttonHeight + 100;
        int extra_buttonX = (this.getWidth() - buttonWidth) / 2;
        extra_button.setBounds(extra_buttonX, extra_buttonY, buttonWidth, buttonHeight);
    }

    private void openWebpage() {
        try {
            URI uri = new URI("https://www.formula1.com/en/results.html/2024/drivers.html");
            Desktop.getDesktop().browse(uri);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
