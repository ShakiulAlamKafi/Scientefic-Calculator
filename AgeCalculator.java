import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class AgeCalculator extends JFrame implements ActionListener
{

    private JTextField dobField, ageField, nextBirthdayField, dayOfWeekField;
    private JButton calculateButton;

    public AgeCalculator()
    {
        setTitle("Age Calculator");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        JLabel dobLabel = new JLabel("Date of Birth (YYYY-MM-DD): ");
        dobField = new JTextField();
        JLabel ageLabel = new JLabel("Age: ");
        ageField = new JTextField();
        ageField.setEditable(false);
        JLabel nextBirthdayLabel = new JLabel("Next Birthday: ");
        nextBirthdayField = new JTextField();
        nextBirthdayField.setEditable(false);
        JLabel dayOfWeekLabel = new JLabel("Day of the week you were born: ");
        dayOfWeekField = new JTextField();
        dayOfWeekField.setEditable(false);

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);
        calculateButton.setPreferredSize(new Dimension(150, 30));

        add(dobLabel);
        add(dobField);
        add(ageLabel);
        add(ageField);
        add(nextBirthdayLabel);
        add(nextBirthdayField);
        add(dayOfWeekLabel);
        add(dayOfWeekField);
        add(new JLabel());
        add(calculateButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == calculateButton) 
        {
            String dobText = dobField.getText();
            if (isValidDate(dobText)) 
            {
                LocalDate dob = LocalDate.parse(dobText);
                LocalDate now = LocalDate.now();
                Period period = Period.between(dob, now);
                int years = period.getYears();
                int months = period.getMonths();
                int days = period.getDays();
                ageField.setText(years + " years, " + months + " months, " + days + " days");

                LocalDate nextBirthday = dob.withYear(now.getYear());
                if (nextBirthday.isBefore(now) || nextBirthday.isEqual(now))
                {
                    nextBirthday = nextBirthday.plusYears(1);
                }
                Period nextBirthdayPeriod = Period.between(now, nextBirthday);
                nextBirthdayField.setText(nextBirthday.format(DateTimeFormatter.ofPattern("MMM dd, YYYY")) + " (in "
                        + nextBirthdayPeriod.getMonths() + " months, " + nextBirthdayPeriod.getDays() + " days)");

                dayOfWeekField.setText(dob.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault()));
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Please enter a valid date in YYYY-MM-DD format.");
            }
        }
    }

    private boolean isValidDate(String date)
    {
        try
        {
            LocalDate.parse(date);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public static void main(String[] args)
    {
        new AgeCalculator();
    }
}
