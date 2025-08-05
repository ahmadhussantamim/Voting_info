import javax.swing.*;
import java.awt.*;

public class optionwindow {
    public optionwindow(String personName) {
        JFrame frame = new JFrame("NID Registration Option");
        frame.setSize(500, 300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel messageLabel = new JLabel(personName + ", you're NOT eligible to vote yet.");
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        messageLabel.setBounds(40, 30, 450, 30);
        frame.add(messageLabel);

        JLabel questionLabel = new JLabel("Do you want to apply for NID registration?");
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        questionLabel.setBounds(40, 80, 420, 30);
        frame.add(questionLabel);

        JButton yesButton = new JButton("Yes");
        yesButton.setFont(new Font("Arial", Font.BOLD, 16));
        yesButton.setBounds(120, 150, 100, 40);
        frame.add(yesButton);

        JButton noButton = new JButton("No");
        noButton.setFont(new Font("Arial", Font.BOLD, 16));
        noButton.setBounds(260, 150, 100, 40);
        frame.add(noButton);

        // Yes button action
        yesButton.addActionListener(e -> {
            new NIDRegistrationWindow(personName, 17);
            frame.dispose();
        });

        // No button action
        noButton.addActionListener(e -> frame.dispose());
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}