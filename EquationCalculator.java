import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EquationCalculator extends JFrame implements ActionListener {

    private JLabel equationLabel, resultLabel;
    private JTextField aField, bField, cField, resultField;
    private JButton calculateButton, clearButton;
    private JComboBox<String> equationTypeComboBox;

    public EquationCalculator() {
        setTitle("Equation Solver");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(350, 300);
        setLocationRelativeTo(null);

        equationLabel = new JLabel("Equation:");
        equationLabel.setForeground(Color.BLUE); // Equation label color

        resultLabel = new JLabel("Result:");
        resultLabel.setForeground(Color.BLUE); // Result label color

        aField = new JTextField(5);
        bField = new JTextField(5);
        cField = new JTextField(5);
        resultField = new JTextField(10);
        resultField.setEditable(false);

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);
        calculateButton.setBackground(Color.GREEN); // Calculate button color
        calculateButton.setForeground(Color.WHITE); // Calculate button text color

        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        clearButton.setBackground(Color.RED); // Clear button color
        clearButton.setForeground(Color.WHITE); // Clear button text color

        equationTypeComboBox = new JComboBox<>();
        equationTypeComboBox.addItem("Linear (ax + b = c)");
        equationTypeComboBox.addItem("Quadratic (ax^2 + bx + c = 0)");
        equationTypeComboBox.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));
        panel.setBackground(Color.WHITE); // Panel background color
        panel.add(equationLabel);
        panel.add(equationTypeComboBox);
        panel.add(new JLabel("a:"));
        panel.add(aField);
        panel.add(new JLabel("b:"));
        panel.add(bField);
        panel.add(new JLabel("c:"));
        panel.add(cField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE); // Panel background color
        buttonPanel.add(calculateButton);
        buttonPanel.add(clearButton);

        JPanel resultPanel = new JPanel();
        resultPanel.setBackground(Color.WHITE); // Panel background color
        resultPanel.add(resultLabel);
        resultPanel.add(resultField);

        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        getContentPane().add(resultPanel, BorderLayout.NORTH);

        getContentPane().setBackground(Color.LIGHT_GRAY); // JFrame background color

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == equationTypeComboBox) {
            if (equationTypeComboBox.getSelectedItem().equals("Linear (ax + b = c)")) {
                equationLabel.setText("Equation: ax + b = c");
                aField.setEnabled(true);
                bField.setEnabled(true);
                cField.setEnabled(true);
            } else if (equationTypeComboBox.getSelectedItem().equals("Quadratic (ax^2 + bx + c = 0)")) {
                equationLabel.setText("Equation: ax^2 + bx + c = 0");
                aField.setEnabled(true);
                bField.setEnabled(true);
                cField.setEnabled(true);
            }
        } else if (e.getSource() == calculateButton) {
            try {
                double a = Double.parseDouble(aField.getText());
                double b = Double.parseDouble(bField.getText());
                double c = Double.parseDouble(cField.getText());
                double result;
                if (equationTypeComboBox.getSelectedItem().equals("Linear (ax + b = c)")) {
                    result = (c - b) / a;
                    resultField.setText(String.valueOf(result));
                } else if (equationTypeComboBox.getSelectedItem().equals("Quadratic (ax^2 + bx + c = 0)")) {
                    double discriminant = b * b - 4 * a * c;
                    if (discriminant > 0) {
                        double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                        double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                        resultField.setText("Roots: " + root1 + ", " + root2);
                    } else if (discriminant == 0) {
                        double root = -b / (2 * a);
                        resultField.setText("Root: " + root);
                    } else {
                        resultField.setText("No real roots");
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numbers for a, b, and c.");
            } catch (ArithmeticException ex) {
                JOptionPane.showMessageDialog(this, "a cannot be zero.");
            }
        } else if (e.getSource() == clearButton) {
            aField.setText("");
            bField.setText("");
            cField.setText("");
            resultField.setText("");
        }
    }
    

    public static void main(String[] args) {
        new EquationCalculator();
    }
}
