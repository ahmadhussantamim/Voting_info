import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class NIDRegistrationWindow {
    public NIDRegistrationWindow(String name, int providedAge) {
        JFrame frame = new JFrame("NID Registration");
        frame.setSize(700, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        ImageIcon backgroundIcon = new ImageIcon("images/registration.jpg");
        Image sc = backgroundIcon.getImage().getScaledInstance(700, 400, Image.SCALE_SMOOTH);
        ImageIcon backgroundIcon2 = new ImageIcon(sc);
        
        JLabel backgroundLabel = new JLabel(backgroundIcon2);
        backgroundLabel.setBounds(0, 0, 600, 400);
        frame.setContentPane(backgroundLabel);
        backgroundLabel.setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        nameLabel.setBounds(70, 40, 150, 30);
        nameLabel.setForeground(Color.BLACK);
        backgroundLabel.add(nameLabel);

        JTextField nameField = new JTextField(name);
        nameField.setFont(new Font("Arial", Font.BOLD, 20));
        nameField.setBounds(240, 40, 280, 30);
        nameField.setEditable(false);
        backgroundLabel.add(nameField);

        JLabel dobLabel = new JLabel("Date of Birth:");
        dobLabel.setFont(new Font("Arial", Font.BOLD, 20));
        dobLabel.setBounds(70, 90, 200, 30);
        dobLabel.setForeground(Color.BLACK);
        backgroundLabel.add(dobLabel);

        Calendar today = Calendar.getInstance();
        int currentDay = today.get(Calendar.DAY_OF_MONTH);
        int currentMonth = today.get(Calendar.MONTH) + 1;
        int currentYear = today.get(Calendar.YEAR);

        JSpinner daySpinner = new JSpinner(new SpinnerNumberModel(currentDay, 1, 31, 1));
        daySpinner.setBounds(240, 90, 80, 30);
        backgroundLabel.add(daySpinner);

        JSpinner monthSpinner = new JSpinner(new SpinnerNumberModel(currentMonth, 1, 12, 1));
        monthSpinner.setBounds(330, 90, 80, 30);
        backgroundLabel.add(monthSpinner);

        JSpinner yearSpinner = new JSpinner(new SpinnerNumberModel(currentYear, 1900, currentYear, 1));
        yearSpinner.setBounds(420, 90, 100, 30);
        backgroundLabel.add(yearSpinner);

        JLabel mobileLabel = new JLabel("Mobile Number:");
        mobileLabel.setFont(new Font("Arial", Font.BOLD, 20));
        mobileLabel.setBounds(70, 140, 200, 30);
        mobileLabel.setForeground(Color.BLACK);
        backgroundLabel.add(mobileLabel);

        JTextField mobileField = new JTextField();
        mobileLabel.setFont(new Font("Arial", Font.BOLD, 20));
        mobileField.setBounds(240, 140, 280, 30);
        backgroundLabel.add(mobileField);

        JLabel resultLabel = new JLabel("");
        resultLabel.setBounds(50, 250, 650, 40);
        resultLabel.setForeground(Color.DARK_GRAY);  
        resultLabel.setFont(new Font("Arial", Font.BOLD, 18));
        backgroundLabel.add(resultLabel);

        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 24));
        submitButton.setBounds(280, 200, 120, 35);
        submitButton.setBackground(Color.BLUE);
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);
        backgroundLabel.add(submitButton);

        submitButton.addActionListener(e -> {
            int day = (Integer) daySpinner.getValue();
            int month = (Integer) monthSpinner.getValue();
            int year = (Integer) yearSpinner.getValue();
            String dob = String.format("%02d-%02d-%04d", day, month, year);
            String mobile = mobileField.getText().trim();

            if (mobile.isEmpty() || !mobile.matches("\\d{11}")) {
                resultLabel.setForeground(Color.RED);
                resultLabel.setText("11 Digit Mobile Number is Required*");
                return;
            }

            int calculatedAge = currentYear - year;
            if (month > currentMonth || (month == currentMonth && day > currentDay)) {
                calculatedAge--;
            }

            if (calculatedAge != providedAge) {
                resultLabel.setForeground(Color.RED);
                resultLabel.setText("Invalid age! you're not 17 based on your DOB*");
                return;
            }

            String entry = name + "," + dob + "," + mobile;
            File file = new File("nid_registry.txt");

            try {
                if (file.exists()) {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        if (scanner.nextLine().trim().equals(entry)) {
                            resultLabel.setForeground(Color.RED);
                            resultLabel.setText("Already registered!");
                            scanner.close();
                            return;
                        }
                    }
                    scanner.close();
                }

                FileWriter writer = new FileWriter(file, true);
                writer.write(entry + "\n");
                writer.close();
                resultLabel.setForeground(Color.BLACK);
                resultLabel.setText("Registration successful! you'll get an SMS for the Biometric.");

            } catch (IOException ex) {
                resultLabel.setForeground(Color.RED);
                resultLabel.setText("Error saving data.");
                ex.printStackTrace();
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
