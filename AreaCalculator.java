import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AreaCalculator extends JFrame implements ActionListener {

    private JLabel sideLabel, widthLabel, areaLabel, shapeLabel;
    private JTextField sideField, widthField, areaField;
    private JButton calculateButton, clearButton;
    private JComboBox<String> shapeComboBox;

    public AreaCalculator() {
        setTitle("Area Calculator");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 250);
        setLocationRelativeTo(null);

        sideLabel = new JLabel("Side:");
        widthLabel = new JLabel("Width:");
        areaLabel = new JLabel("Area:");
        shapeLabel = new JLabel("Select Shape:");

        sideField = new JTextField(10);
        widthField = new JTextField(10);
        areaField = new JTextField(10);
        areaField.setEditable(false);

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);
        calculateButton.setBackground(Color.GREEN); // Button color

        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        clearButton.setBackground(Color.RED); // Button color

        shapeComboBox = new JComboBox<>();
        shapeComboBox.addItem("Rectangle");
        shapeComboBox.addItem("Square");
        shapeComboBox.addItem("Triangle");
        shapeComboBox.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        panel.setBackground(Color.WHITE); // Panel background color
        panel.add(shapeLabel);
        panel.add(shapeComboBox);
        panel.add(sideLabel);
        panel.add(sideField);
        panel.add(widthLabel);
        panel.add(widthField);
        panel.add(areaLabel);
        panel.add(areaField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE); // Panel background color
        buttonPanel.add(calculateButton);
        buttonPanel.add(clearButton);

        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        getContentPane().setBackground(Color.LIGHT_GRAY); // JFrame background color

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            try {
                double side = Double.parseDouble(sideField.getText());
                double width = Double.parseDouble(widthField.getText());
                double area = 0;
                if (shapeComboBox.getSelectedItem().equals("Rectangle")) {
                    area = side * width;
                } else if (shapeComboBox.getSelectedItem().equals("Square")) {
                    area = side * side;
                } else if (shapeComboBox.getSelectedItem().equals("Triangle")) {
                    area = 0.5 * side * width;
                }
                areaField.setText(String.valueOf(area));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numbers for side and width.");
            }
        } else if (e.getSource() == clearButton) {
            sideField.setText("");
            widthField.setText("");
            areaField.setText("");
        } else if (e.getSource() == shapeComboBox) {
            if (shapeComboBox.getSelectedItem().equals("Square")) {
                widthLabel.setText("");
                sideLabel.setText("Side:");
                widthField.setText("");
            } else if (shapeComboBox.getSelectedItem().equals("Triangle")) {
                sideLabel.setText("Height:");
                widthLabel.setText("Base:");
            } else {
                sideLabel.setText("Side:");
                widthLabel.setText("Width:");
            }
        }
    }

    public static void main(String[] args) {
        new AreaCalculator();
    }
}
