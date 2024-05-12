import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NumberSystemConverter extends JFrame implements ActionListener {
    private JTextField inputField, outputField;
    private JButton convertButton;
    private JComboBox<String> inputBase, outputBase;
    private JLabel inputLabel, outputLabel, inputBaseLabel, outputBaseLabel;

    public NumberSystemConverter() {
        setTitle("Number System Converter");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 10, 10));

        inputLabel = new JLabel("Input Number:");
        inputField = new JTextField();
        inputBaseLabel = new JLabel("Input Base:");
        String[] bases = {"Binary", "Decimal", "Hexadecimal"};
        inputBase = new JComboBox<>(bases);
        inputBase.setSelectedIndex(1);

        outputLabel = new JLabel("Output Number:");
        outputField = new JTextField();
        outputField.setEditable(false);
        outputBaseLabel = new JLabel("Output Base:");
        outputBase = new JComboBox<>(bases);
        outputBase.setSelectedIndex(0);

        convertButton = new JButton("Convert");
        convertButton.addActionListener(this);

        add(inputLabel);
        add(inputField);
        add(inputBaseLabel);
        add(inputBase);
        add(outputLabel);
        add(outputField);
        add(outputBaseLabel);
        add(outputBase);
        add(new JLabel());
        add(convertButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == convertButton) {
            String inputNumber = inputField.getText();
            int inputBaseIndex = inputBase.getSelectedIndex();
            int outputBaseIndex = outputBase.getSelectedIndex();

            try {
                switch (inputBaseIndex) {
                    case 0:
                        outputField.setText(convertBinary(inputNumber, outputBaseIndex));
                        break;
                    case 1:
                        outputField.setText(convertDecimal(inputNumber, outputBaseIndex));
                        break;
                    case 2:
                        outputField.setText(convertHexadecimal(inputNumber, outputBaseIndex));
                        break;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input number!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private String convertBinary(String inputNumber, int outputBaseIndex) {
        int decimal = Integer.parseInt(inputNumber, 2);
        switch (outputBaseIndex) {
            case 0:
                return inputNumber;
            case 1:
                return String.valueOf(decimal);
            case 2:
                return Integer.toHexString(decimal).toUpperCase();
            default:
                return "";
        }
    }

    private String convertDecimal(String inputNumber, int outputBaseIndex) {
        int decimal = Integer.parseInt(inputNumber);
        switch (outputBaseIndex) {
            case 0:
                return Integer.toBinaryString(decimal);
            case 1:
                return inputNumber;
            case 2:
                return Integer.toHexString(decimal).toUpperCase();
            default:
                return "";
        }
    }

    private String convertHexadecimal(String inputNumber, int outputBaseIndex) {
        int decimal = Integer.parseInt(inputNumber, 16);
        switch (outputBaseIndex) {
            case 0:
                return Integer.toBinaryString(decimal);
            case 1:
                return String.valueOf(decimal);
            case 2:
                return inputNumber;
            default:
                return "";
        }
    }

    public static void main(String[] args) {
        new NumberSystemConverter();
    }
}

