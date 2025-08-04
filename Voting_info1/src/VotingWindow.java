import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VotingWindow {
    JFrame votingFrame;

    public VotingWindow() {
        votingFrame = new JFrame("Voting Eligibility Checker");
        votingFrame.setSize(800, 600);
        votingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        votingFrame.setLayout(null);

        JLabel titleLabel = new JLabel("Voting Eligibility Checker");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));
        titleLabel.setBounds(200, 70, 400, 40);
        votingFrame.add(titleLabel);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        nameLabel.setBounds(120, 180, 100, 30);
        votingFrame.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setFont(new Font("Arial", Font.PLAIN, 22));
        nameField.setBounds(220, 180, 350, 30);
        votingFrame.add(nameField);

        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        ageLabel.setBounds(120, 250, 100, 30);
        votingFrame.add(ageLabel);

        JTextField ageField = new JTextField();
        ageField.setFont(new Font("Arial", Font.PLAIN, 22));
        ageField.setBounds(220, 250, 350, 30);
        votingFrame.add(ageField);

        JLabel resultLabel = new JLabel("");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 24));
        resultLabel.setBounds(100, 400, 600, 30);
        resultLabel.setForeground(Color.BLUE);
        votingFrame.add(resultLabel);

        JButton checkButton = new JButton("Check Eligibility");
        checkButton.setFont(new Font("Arial", Font.BOLD, 18));
        checkButton.setBounds(200, 320, 180, 40);
        votingFrame.add(checkButton);

        JButton resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Arial", Font.BOLD, 18));
        resetButton.setBounds(400, 320, 120, 40);
        votingFrame.add(resetButton);

        // Check button logic
        checkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                String ageText = ageField.getText().trim();

                if (!name.matches("[a-zA-Z\\s]+") || name.isEmpty()) {
                    resultLabel.setForeground(Color.RED);
                    resultLabel.setText("Invalid input! Name must contain letters only.");
                    return;
                }

                try {
                    int age = Integer.parseInt(ageText);

                    if (age < 0 || age > 120) {
                        resultLabel.setForeground(Color.RED);
                        resultLabel.setText("Invalid input! Age must be realistic.");
                        return;
                    }

                    if (age >= 18) {
                        resultLabel.setForeground(Color.BLUE);
                        resultLabel.setText(name + " is eligible to vote.");

                    } 
                    else if (age==17) {
                        new NIDRegistrationWindow(name, age);
                    }
                        
                        else {
                        resultLabel.setForeground(Color.BLUE);
                        resultLabel.setText(name + " is NOT eligible to vote.");
                    }

                } catch (NumberFormatException ex) {
                    resultLabel.setForeground(Color.RED);
                    resultLabel.setText("Invalid input! Age must be a number.");
                }
            }
        });

        // Reset button logic
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
  
