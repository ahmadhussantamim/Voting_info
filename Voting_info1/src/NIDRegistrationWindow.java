import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

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

        // DOB Label
        JLabel dobLabel = new JLabel("Date of Birth:");
        dobLabel.setBounds(70, 90, 200, 30);
        frame.add(dobLabel);

        Calendar today = Calendar.getInstance();
        int currentDay = today.get(Calendar.DAY_OF_MONTH);
        int currentMonth = today.get(Calendar.MONTH) + 1; // MONTH is 0-based
        int currentYear = today.get(Calendar.YEAR);

        // Day Spinner
        SpinnerNumberModel dayModel = new SpinnerNumberModel(currentDay, 1, 31, 1);
        JSpinner daySpinner = new JSpinner(dayModel);
        daySpinner.setBounds(240, 90, 60, 30);
        frame.add(daySpinner);

        // Month Spinner
        SpinnerNumberModel monthModel = new SpinnerNumberModel(currentMonth, 1, 12, 1);
        JSpinner monthSpinner = new JSpinner(monthModel);
        monthSpinner.setBounds(310, 90, 60, 30);
        frame.add(monthSpinner);

        // Year Spinner
        SpinnerNumberModel yearModel = new SpinnerNumberModel(currentYear, 1900, currentYear, 1);
        JSpinner yearSpinner = new JSpinner(yearModel);
        yearSpinner.setBounds(380, 90, 80, 30);
        frame.add(yearSpinner);

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

        submitButton.addActionListener(e -> {
            int day = (Integer) daySpinner.getValue();
            int month = (Integer) monthSpinner.getValue();
            int year = (Integer) yearSpinner.getValue();
            String dob = String.format("%02d-%02d-%04d", day, month, year);
            String mobile = mobileField.getText().trim();

            if (mobile.isEmpty()|| !mobile.matches("\\d{11}") ) {
                resultLabel.setForeground(Color.RED);
                resultLabel.setText("11 Digit Mobile Number is Required*");
                return;
            }

            // Calculate age
            int calculatedAge = currentYear - year;
            if (month > (today.get(Calendar.MONTH) + 1) ||
                (month == (today.get(Calendar.MONTH) + 1) && day > today.get(Calendar.DAY_OF_MONTH))) {
                calculatedAge--;
            }

            if (calculatedAge != providedAge) {
                resultLabel.setForeground(Color.RED);
                resultLabel.setText("Invalid age! you're not 17 based on your DOB*");
                return;
            }

            // Save to file
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

                try (FileWriter writer = new FileWriter(file, true)) {
                    writer.write(entry + "\n");
                    resultLabel.setForeground(Color.GREEN);
                    resultLabel.setText("Registration successful! you'll get an SMS for the Biometric.");
                }

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
