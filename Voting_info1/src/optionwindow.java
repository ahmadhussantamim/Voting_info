import javax.swing.*;
import java.awt.*;

public class optionwindow {
    public optionwindow(String personName) {
        JFrame frame = new JFrame("NID Registration Option");
        frame.setSize(500, 300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        ImageIcon bIcon = new ImageIcon("images/option.jpg");
        Image sc = bIcon.getImage().getScaledInstance(500, 300, Image.SCALE_SMOOTH);
        ImageIcon backgroundIcon2 = new ImageIcon(sc);
        
        JLabel bLabel = new JLabel(backgroundIcon2);
        bLabel.setBounds(0, 0, 500, 300);
        frame.setContentPane(bLabel);
        bLabel.setLayout(null);

        JLabel messageLabel = new JLabel(personName + ", you're NOT eligible to vote yet.");
        messageLabel.setFont(new Font("Arial", Font.BOLD, 20));
        messageLabel.setForeground(Color.BLACK);
        messageLabel.setBounds(40, 30, 450, 30);
        frame.add(messageLabel);

        JLabel questionLabel = new JLabel("Do you want to apply for NID registration?");
        questionLabel.setFont(new Font("Arial", Font.BOLD, 20));
        questionLabel.setForeground(Color.BLACK);
        questionLabel.setBounds(40, 70, 420, 30);
        frame.add(questionLabel);

        JButton yesButton = new JButton("Yes");
        yesButton.setFont(new Font("Arial", Font.BOLD, 22));
        yesButton.setBounds(120, 150, 100, 40);
        yesButton.setBackground(Color.GREEN);
        yesButton.setForeground(Color.BLACK);
        yesButton.setFocusPainted(false);
        frame.add(yesButton);

        JButton noButton = new JButton("No");
        noButton.setFont(new Font("Arial", Font.BOLD, 22));
        noButton.setBounds(260, 150, 100, 40);
        noButton.setBackground(Color.RED);
        noButton.setForeground(Color.WHITE);
        noButton.setFocusPainted(false);
        frame.add(noButton);

        yesButton.addActionListener(e -> {
            new NIDRegistrationWindow(personName, 17);
            frame.dispose();
        });

        noButton.addActionListener(e -> frame.dispose());
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
