import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NumberGuessingGameGUI extends JFrame {
    private int secretNumber;
    private int attempts;
    private JTextField inputField;
    private JLabel messageLabel;

    public NumberGuessingGameGUI() {
        setTitle("Number Guessing Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        secretNumber = new Random().nextInt(100) + 1;
        attempts = 0;

        JLabel promptLabel = new JLabel("Guess the number between 1 and 100:");
        inputField = new JTextField(10);
        JButton guessButton = new JButton("Guess");
        messageLabel = new JLabel("");

        guessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });

        add(promptLabel);
        add(inputField);
        add(guessButton);
        add(messageLabel);
    }

    private void checkGuess() {
        String input = inputField.getText();
        try {
            int userGuess = Integer.parseInt(input);
            attempts++;

            if (userGuess < secretNumber) {
                messageLabel.setText("Too low! Try again.");
            } else if (userGuess > secretNumber) {
                messageLabel.setText("Too high! Try again.");
            } else {
                messageLabel.setText("Congratulations! You guessed the number " + secretNumber + " in " + attempts + " attempts.");
                inputField.setEditable(false);
            }
        } catch (NumberFormatException ex) {
            messageLabel.setText("Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new NumberGuessingGameGUI().setVisible(true);
            }
        });
    }
}
