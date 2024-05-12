import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CGPACalculator extends JFrame implements ActionListener
{
    private JTextField[] gradeFields;
    private JTextField[] creditHourFields;
    private JButton calculateButton;
    private JLabel resultLabel;

    public CGPACalculator()
    {
        setTitle("CGPA Calculator");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(0, 2));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        int numCourses = 8; // Change this to adjust the number of courses
        gradeFields = new JTextField[numCourses];
        creditHourFields = new JTextField[numCourses];

        for (int i = 0; i < numCourses; i++)
        {
            inputPanel.add(new JLabel("Grade for Course " + (i + 1)));
            gradeFields[i] = new JTextField(5);
            inputPanel.add(gradeFields[i]);

            inputPanel.add(new JLabel("Credit Hours for Course " + (i + 1)));
            creditHourFields[i] = new JTextField(5);
            inputPanel.add(creditHourFields[i]);
        }

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        calculateButton = new JButton("Calculate CGPA");
        calculateButton.addActionListener(this);
        buttonPanel.add(calculateButton);

        resultLabel = new JLabel("Your CGPA will appear here");
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(resultLabel, BorderLayout.NORTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == calculateButton)
        {
            calculateCGPA();
        }
    }

    private void calculateCGPA()
    {
        int totalCreditHours = 0;
        double totalGradePoints = 0;

        for (int i = 0; i < gradeFields.length; i++)
        {
            String gradeStr = gradeFields[i].getText().trim();
            String creditHourStr = creditHourFields[i].getText().trim();

            if (!gradeStr.isEmpty() && !creditHourStr.isEmpty())
            {
                try
                {
                    double grade = Double.parseDouble(gradeStr);
                    double creditHours = Double.parseDouble(creditHourStr);

                    if (grade < 0 || grade > 4.0 || creditHours <= 0)
                    {
                        JOptionPane.showMessageDialog(this, "Invalid input for Course " + (i + 1));
                        return;
                    }
                    totalGradePoints += grade * creditHours;
                    totalCreditHours += creditHours;
                }
                catch (NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(this, "Invalid input for Course " + (i + 1));
                    return;
                }
            }
        }
        if (totalCreditHours == 0)
        {
            JOptionPane.showMessageDialog(this, "No input provided");
            return;
        }
        double cgpa = totalGradePoints / totalCreditHours;
        resultLabel.setText("Your CGPA is: " + String.format("%.2f", cgpa));
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new CGPACalculator();
            }
        });
    }
}
