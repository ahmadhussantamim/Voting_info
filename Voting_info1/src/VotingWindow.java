import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VotingWindow {
    JFrame votingFrame;

    public VotingWindow() {
        votingFrame = new JFrame("Voting Eligibility Checker");
        votingFrame.setSize(700, 600);
        votingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon backgroundIcon = new ImageIcon("images/voting.png");
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setBounds(0, 0, 700, 600);
        votingFrame.setContentPane(backgroundLabel);
        backgroundLabel.setLayout(null);

        JLabel titleLabel = new JLabel("Voting Eligibility Checker");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));
        titleLabel.setBounds(180, 50, 400, 40);
        titleLabel.setForeground(Color.BLACK);
        backgroundLabel.add(titleLabel);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        nameLabel.setBounds(80, 140, 100, 30);
        nameLabel.setForeground(Color.BLACK);
        backgroundLabel.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setFont(new Font("Arial", Font.PLAIN, 20));
        nameField.setBounds(180, 140, 330, 30);
        backgroundLabel.add(nameField);

        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setFont(new Font("Arial", Font.BOLD, 20));
        ageLabel.setBounds(80, 210, 100, 30);
        ageLabel.setForeground(Color.BLACK);
        backgroundLabel.add(ageLabel);

        JTextField ageField = new JTextField();
        ageField.setFont(new Font("Arial", Font.PLAIN, 20));
        ageField.setBounds(180, 210, 330, 30);
        backgroundLabel.add(ageField);

        JLabel resultLabel = new JLabel("");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 24));
        resultLabel.setBounds(50, 430, 600, 30);
        resultLabel.setForeground(Color.BLUE);
        backgroundLabel.add(resultLabel);

        JButton checkButton = new JButton("Check Eligibility");
        checkButton.setFont(new Font("Arial", Font.BOLD, 18));
        checkButton.setBounds(180, 320, 180, 40);
        checkButton.setBackground(new Color(178, 34, 34)); // dark red
        checkButton.setForeground(Color.WHITE);
        checkButton.setFocusPainted(false);
        backgroundLabel.add(checkButton);

        JButton resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Arial", Font.BOLD, 18));
        resetButton.setBounds(400, 320, 120, 40);
        resetButton.setBackground(new Color(128, 128, 128)); // gray
        resetButton.setForeground(Color.WHITE);
        resetButton.setFocusPainted(false);
        backgroundLabel.add(resetButton);

        checkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                String ageText = ageField.getText().trim();

                if (!name.matches("[a-zA-Z\\s]+") || name.isEmpty()) {
                    resultLabel.setForeground(Color.RED);
                    resultLabel.setText("Invalid input: Name must contain letters only.");
                    return;
                }

                try {
                    int age = Integer.parseInt(ageText);

                    if (age <= 0 || age > 150) {
                        resultLabel.setForeground(Color.RED);
                        resultLabel.setText("Invalid input: Age must be realistic.");
                        return;
                    }

                    if (age >= 18) {
                        resultLabel.setForeground(Color.BLUE);
                        resultLabel.setText(name + ", you're eligible to vote.");
                    } else if (age == 17) {
                        new optionwindow(name);  
                        votingFrame.dispose();
                    } else {
                        resultLabel.setForeground(Color.BLUE);
                        resultLabel.setText(name + ", you're NOT eligible to vote.");
                    }

                } catch (NumberFormatException ex) {
                    resultLabel.setForeground(Color.RED);
                    resultLabel.setText("Invalid input: Age must be a number.");
                }
            }
        });

        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nameField.setText("");
                ageField.setText("");
                resultLabel.setText("");
                resultLabel.setForeground(Color.BLUE);
            }
        });

        votingFrame.setLocationRelativeTo(null);
        votingFrame.setVisible(true);
    }
}
