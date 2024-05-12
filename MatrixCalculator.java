import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class MatrixCalculator extends JFrame implements ActionListener {
    private JTextField[][] matrixFieldsA, matrixFieldsB, resultMatrixFields;
    private JButton addButton, subtractButton, multiplyButton, clearButton;
    private int rows, cols;

    public MatrixCalculator(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;

        setTitle("Matrix Calculator");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        matrixFieldsA = new JTextField[rows][cols];
        matrixFieldsB = new JTextField[rows][cols];
        resultMatrixFields = new JTextField[rows][cols];

        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("Matrix Calculator", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titlePanel.add(titleLabel);

        JPanel inputMatrixPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        inputMatrixPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Input Matrices"));
        inputMatrixPanel.setBackground(Color.LIGHT_GRAY);

        JPanel matrixPanelA = new JPanel(new GridLayout(rows, cols, 5, 5));
        JPanel matrixPanelB = new JPanel(new GridLayout(rows, cols, 5, 5));

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrixFieldsA[i][j] = new JTextField(5);
                matrixPanelA.add(matrixFieldsA[i][j]);
                matrixFieldsB[i][j] = new JTextField(5);
                matrixPanelB.add(matrixFieldsB[i][j]);
            }
        }

        inputMatrixPanel.add(matrixPanelA);
        inputMatrixPanel.add(matrixPanelB);

        JPanel resultMatrixPanel = new JPanel(new GridLayout(1, 1));
        resultMatrixPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Result Matrix"));
        resultMatrixPanel.setBackground(Color.LIGHT_GRAY);

        JPanel resultPanel = new JPanel(new GridLayout(rows, cols, 5, 5));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resultMatrixFields[i][j] = new JTextField(5);
                resultMatrixFields[i][j].setEditable(false);
                resultPanel.add(resultMatrixFields[i][j]);
            }
        }
        resultMatrixPanel.add(resultPanel);

        addButton = new JButton("Add");
        addButton.setBackground(Color.GREEN);
        subtractButton = new JButton("Subtract");
        subtractButton.setBackground(Color.ORANGE);
        multiplyButton = new JButton("Multiply");
        multiplyButton.setBackground(Color.BLUE);
        clearButton = new JButton("Clear");
        clearButton.setBackground(Color.RED);

        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        clearButton.addActionListener(this);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 5, 5));
        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(clearButton);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(inputMatrixPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.add(resultMatrixPanel, BorderLayout.EAST);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setBackground(Color.WHITE);

        setContentPane(mainPanel);
        setJMenuBar(createMenuBar());
        setVisible(true);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu matrixMenu = new JMenu("Menu");
        matrixMenu.setMnemonic(KeyEvent.VK_M);

        JMenuItem changeSizeItem = new JMenuItem("Change Size");
        changeSizeItem.addActionListener(this);
        matrixMenu.add(changeSizeItem);

        JMenuItem resetItem = new JMenuItem("Reset");
        resetItem.addActionListener(this);
        matrixMenu.add(resetItem);

        menuBar.add(matrixMenu);
        return menuBar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Change Size")) {
            String input = JOptionPane.showInputDialog(this, "Enter the new size (rows and columns):", rows + "x" + cols);
            if (input != null) {
                try {
                    String[] size = input.split("x");
                    int newRows = Integer.parseInt(size[0]);
                    int newCols = Integer.parseInt(size[1]);
                    if (newRows <= 0 || newCols <= 0) {
                        JOptionPane.showMessageDialog(this, "Rows and columns must be positive integers!", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        dispose();
                        new MatrixCalculator(newRows, newCols);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid input! Please enter integers.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if (e.getActionCommand().equals("Reset")) {
            clearFields();
        } else {
            performOperation(e);
        }
    }

    private void performOperation(ActionEvent e) {
        double[][] matrixA = new double[rows][cols];
        double[][] matrixB = new double[rows][cols];
        double[][] resultMatrix = new double[rows][cols];

        try {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrixA[i][j] = Double.parseDouble(matrixFieldsA[i][j].getText());
                    matrixB[i][j] = Double.parseDouble(matrixFieldsB[i][j].getText());
                }
            }

            if (e.getSource() == addButton) {
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        resultMatrix[i][j] = matrixA[i][j] + matrixB[i][j];
                        resultMatrixFields[i][j].setText(String.valueOf(resultMatrix[i][j]));
                    }
                }
            } else if (e.getSource() == subtractButton) {
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        resultMatrix[i][j] = matrixA[i][j] - matrixB[i][j];
                        resultMatrixFields[i][j].setText(String.valueOf(resultMatrix[i][j]));
                    }
                }
            } else if (e.getSource() == multiplyButton) {
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        for (int k = 0; k < cols; k++) {
                            resultMatrix[i][j] += matrixA[i][k] * matrixB[k][j];
                        }
                        resultMatrixFields[i][j].setText(String.valueOf(resultMatrix[i][j]));
                    }
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrixFieldsA[i][j].setText("");
                matrixFieldsB[i][j].setText("");
                resultMatrixFields[i][j].setText("");
            }
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            new MatrixCalculator(2, 2);
        });
    }
}
