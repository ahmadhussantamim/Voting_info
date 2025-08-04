import javax.swing.*;
import java.awt.*;

public class NIDRegistrationWindow {
    public NIDRegistrationWindow(String name, int providedAge) {
        JFrame frame = new JFrame("NID Registration");
        frame.setSize(600, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(70, 40, 150, 30);
        frame.add(nameLabel);

        JTextField nameField = new JTextField(name);
        nameField.setBounds(240, 40, 250, 30);
        nameField.setEditable(false);
        frame.add(nameField);

        JLabel dobLabel = new JLabel("Date of Birth (dd-mm-yyyy):");
        dobLabel.setBounds(70, 90, 200, 30);
        frame.add(dobLabel);

        JTextField dobField = new JTextField();
        dobField.setBounds(240, 90, 190, 30);
        frame.add(dobField);

        JLabel mobileLabel = new JLabel("Mobile Number:");
        mobileLabel.setBounds(70, 140, 200, 30);
        frame.add(mobileLabel);

        JTextField mobileField = new JTextField();
        mobileField.setBounds(240, 140, 250, 30);
        frame.add(mobileField);

        JLabel resultLabel = new JLabel("");
        resultLabel.setBounds(70, 250, 450, 30);
        resultLabel.setForeground(Color.BLUE);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 14));
        frame.add(resultLabel);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(240, 200, 120, 35);
        frame.add(submitButton);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}