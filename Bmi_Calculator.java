import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Bmi_Calculator implements ActionListener {

    JFrame frame;
    JLabel title, weight, height, resultLabel;
    JTextField weightText, heightText;
    JButton calculateButton, clearButton, scaleButton, closeButton;

    Bmi_Calculator() {
        frame = new JFrame("BMI Calculator");
        frame.setLayout(null);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.BLACK);

        title = new JLabel("BMI Calculator");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(Color.WHITE);
        title.setBounds(100, 10, 200, 30);
        frame.add(title);

        weight = new JLabel("Weight (in kg):");
        weight.setFont(new Font("Arial", Font.BOLD, 16));
        weight.setForeground(Color.WHITE);
        weight.setBounds(50, 60, 150, 20);
        frame.add(weight);

        weightText = new JTextField();
        weightText.setFont(new Font("Arial", Font.PLAIN, 14));
        weightText.setBounds(200, 60, 150, 25);
        frame.add(weightText);

        height = new JLabel("Height (in meters):");
        height.setFont(new Font("Arial", Font.BOLD, 16));
        height.setForeground(Color.WHITE);
        height.setBounds(50, 100, 150, 20);
        frame.add(height);

        heightText = new JTextField();
        heightText.setFont(new Font("Arial", Font.PLAIN, 14));
        heightText.setBounds(200, 100, 150, 25);
        frame.add(heightText);

        calculateButton = new JButton("Calculate");
        calculateButton.setFont(new Font("Arial", Font.BOLD, 16));
        calculateButton.setBounds(50, 150, 120, 30);
        frame.add(calculateButton);
        calculateButton.addActionListener(this);

        clearButton = new JButton("Clear");
        clearButton.setFont(new Font("Arial", Font.BOLD, 16));
        clearButton.setBounds(200, 150, 120, 30);
        frame.add(clearButton);
        clearButton.addActionListener(this);

        scaleButton = new JButton("BMI Scale");
        scaleButton.setFont(new Font("Arial", Font.BOLD, 16));
        scaleButton.setBounds(50, 200, 120, 30);
        frame.add(scaleButton);
        scaleButton.addActionListener(this);

        closeButton = new JButton("Close");
        closeButton.setFont(new Font("Arial", Font.BOLD, 16));
        closeButton.setBounds(200, 200, 120, 30);
        frame.add(closeButton);
        closeButton.addActionListener(this);

        resultLabel = new JLabel("");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
        resultLabel.setForeground(Color.WHITE);
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setBounds(50, 250, 270, 30);
        frame.add(resultLabel);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            try {
                double weight = Double.parseDouble(weightText.getText());
                double height = Double.parseDouble(heightText.getText());
                double bmi = weight / (height * height);
                String bmiResult = String.format("Your BMI: %.2f", bmi);
                resultLabel.setText(bmiResult);
                showBmiCategory(bmi);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter valid weight and height.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == clearButton) {
            weightText.setText("");
            heightText.setText("");
            resultLabel.setText("");
        } else if (e.getSource() == scaleButton) {
            JOptionPane.showMessageDialog(frame,
                    "BMI Categories:\n\n" +
                            "Underweight: less than 18.5\n" +
                            "Normal weight: 18.5–24.9\n" +
                            "Overweight: 25–29.9\n" +
                            "Obesity: 30 or more\n",
                    "BMI Scale",
                    JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == closeButton) {
            frame.dispose();
        }
    }

    private void showBmiCategory(double bmi) {
        String category = "";
        Color color = Color.WHITE;
        if (bmi < 18.5) {
            category = "Underweight";
            color = Color.BLUE;
        } else if (bmi >= 18.5 && bmi < 25) {
            category = "Normal weight";
            color = Color.GREEN;
        } else if (bmi >= 25 && bmi < 30) {
            category = "Overweight";
            color = Color.YELLOW;
        } else {
            category = "Obesity";
            color = Color.RED;
        }
        resultLabel.setForeground(color);
        resultLabel.setText(resultLabel.getText() + " (" + category + ")");
    }

    public static void main(String[] args) {
        new Bmi_Calculator();
    }
}
