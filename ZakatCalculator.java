import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ZakatCalculator extends JFrame implements ActionListener {
    private JTextField cashField, silverField, goldField, investmentField, savingField, expenseField, outstandingField, totalAssetsField, zakatValueField;
    private JButton calculateButton, resetButton;

    public ZakatCalculator() {
        setTitle("Zakat Calculator");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel cashLabel = new JLabel("Cash at Home/Accounts:");
        cashField = new JTextField(10);

        JLabel silverLabel = new JLabel("Value of Silver (in grams):");
        silverField = new JTextField(10);

        JLabel goldLabel = new JLabel("Value of Gold (in grams):");
        goldField = new JTextField(10);

        JLabel investmentLabel = new JLabel("Investments/Share Business:");
        investmentField = new JTextField(10);

        JLabel savingLabel = new JLabel("Saving/Stock Amount:");
        savingField = new JTextField(10);

        JLabel expenseLabel = new JLabel("Your Expenses:");
        expenseField = new JTextField(10);

        JLabel outstandingLabel = new JLabel("Any Outstanding Amount on you:");
        outstandingField = new JTextField(10);

        JLabel totalAssetsLabel = new JLabel("Your Total Assets are:");
        totalAssetsField = new JTextField(10);
        totalAssetsField.setEditable(false);

        JLabel zakatValueLabel = new JLabel("Zakat Value:");
        zakatValueField = new JTextField(10);
        zakatValueField.setEditable(false);

        calculateButton = new JButton("Calculate Zakat");
        resetButton = new JButton("Reset");

        calculateButton.addActionListener(this);
        resetButton.addActionListener(this);

        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 5));
        panel.setBackground(new Color(255, 255, 204)); // Light Yellow

        panel.add(cashLabel);
        panel.add(cashField);
        panel.add(silverLabel);
        panel.add(silverField);
        panel.add(goldLabel);
        panel.add(goldField);
        panel.add(investmentLabel);
        panel.add(investmentField);
        panel.add(savingLabel);
        panel.add(savingField);
        panel.add(expenseLabel);
        panel.add(expenseField);
        panel.add(outstandingLabel);
        panel.add(outstandingField);
        panel.add(totalAssetsLabel);
        panel.add(totalAssetsField);
        panel.add(zakatValueLabel);
        panel.add(zakatValueField);
        panel.add(calculateButton);
        panel.add(resetButton);

        add(panel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            calculateZakat();
        } else if (e.getSource() == resetButton) {
            resetFields();
        }
    }

    private void calculateZakat() {
        try {
            double cash = Double.parseDouble(cashField.getText());
            double silver = Double.parseDouble(silverField.getText());
            double gold = Double.parseDouble(goldField.getText());
            double investment = Double.parseDouble(investmentField.getText());
            double saving = Double.parseDouble(savingField.getText());
            double expense = Double.parseDouble(expenseField.getText());
            double outstanding = Double.parseDouble(outstandingField.getText());

            double totalAssets = cash + silver + gold + investment + saving - expense - outstanding;
            totalAssetsField.setText(String.valueOf(totalAssets));

            double zakatValue = totalAssets * 0.025; // Zakat is 2.5% of total assets
            zakatValueField.setText(String.valueOf(zakatValue));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void resetFields() {
        cashField.setText("");
        silverField.setText("");
        goldField.setText("");
        investmentField.setText("");
        savingField.setText("");
        expenseField.setText("");
        outstandingField.setText("");
        totalAssetsField.setText("");
        zakatValueField.setText("");
    }

    public static void main(String[] args) {
        new ZakatCalculator();
    }
}
