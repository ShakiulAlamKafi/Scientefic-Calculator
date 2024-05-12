import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ScienteficCalculator implements ActionListener
{
    double num1=0,num2=0,result=0;
    int calculation;
    double memory = 0,a;

    JFrame frame=new JFrame("Calculator");
    JLabel label=new JLabel();
    JTextField textField=new JTextField();

    JRadioButton onRadioButton=new JRadioButton("on");
    JRadioButton offRadioButton=new JRadioButton("off");

    JButton buttonZero=new JButton("0");
    JButton buttonOne=new JButton("1");
    JButton buttonTwo=new JButton("2");
    JButton buttonThree=new JButton("3");
    JButton buttonFour=new JButton("4");
    JButton buttonFive=new JButton("5");
    JButton buttonSix=new JButton("6");
    JButton buttonSeven=new JButton("7");
    JButton buttonEight=new JButton("8");
    JButton buttonNine=new JButton("9");
    JButton buttonDot=new JButton(".");
    JButton buttonClear=new JButton("AC");
    JButton buttonDelete=new JButton("DEL");
    JButton buttonEqual=new JButton("=");
    JButton buttonMul=new JButton("X");
    JButton buttonDiv=new JButton("/");
    JButton buttonPlus=new JButton("+");
    JButton buttonMinus=new JButton("-");
    JButton buttonSquare=new JButton("x\u00B2");
    JButton buttonCube=new JButton("x^3");
    JButton buttonReciprocal=new JButton("1/x");
    JButton buttonSqrt=new JButton("\u221A");
    JButton mr = new JButton("MR");
    JButton mc = new JButton("MC");
    JButton mp = new JButton("M+");
    JButton mm = new JButton("M-");
    JButton addSub = new JButton("+/-");
    JButton log = new JButton("log");
    JButton sin = new JButton("sin");
    JButton cos = new JButton("cos");
    JButton tan = new JButton("tan");
    JButton exp = new JButton("exp");
    JButton fac = new JButton("n!");
    JButton btnTemperatureConverter = new JButton("Temperature");
    JButton btnCGPA=new JButton("CGPA");
    JButton age=new JButton("Age");
    JButton numbersystem=new JButton("Number system");
    JButton matrix=new JButton("Matrix");
    JButton bmi=new JButton("BMI");
    JButton area=new JButton("Area");
    JButton equation=new JButton("Equation");
    JButton zakat=new JButton("Zakat");

    public ScienteficCalculator()
    {
        prepareGui();
        addcomponents();
        addActionEvent();
    }
    public void prepareGui()
    {
        frame.setSize(440,650);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.black);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addcomponents()
    {
        label.setBounds(250,0,50,50);
        label.setForeground(Color.white);
        frame.add(label);

        textField.setBounds(10,40,400,40);
        textField.setFont(new Font("Arial",Font.BOLD,20));
        textField.setEditable(false);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.add(textField);

        onRadioButton.setBounds(10,95,60,40);
        onRadioButton.setSelected(true);
        textField.setFont(new Font("Arial",Font.BOLD,14));
        onRadioButton.setBackground(Color.black);
        onRadioButton.setForeground(Color.white);
        onRadioButton.setFocusable(false);
        frame.add(onRadioButton);

        offRadioButton.setBounds(10,120,60,40);
        onRadioButton.setSelected(false);
        textField.setFont(new Font("Arial",Font.BOLD,14));
        offRadioButton.setBackground(Color.black);
        offRadioButton.setForeground(Color.white);
        offRadioButton.setFocusable(false);
        frame.add(offRadioButton);

        ButtonGroup buttonGroup=new ButtonGroup();
        buttonGroup.add(onRadioButton);
        buttonGroup.add(offRadioButton);

        buttonSeven.setBounds(10,230,60,40);
        buttonSeven.setFont(new Font("Arial",Font.BOLD,20));
        buttonSeven.setFocusable(false);
        frame.add(buttonSeven);

        buttonEight.setBounds(80,230,60,40);
        buttonEight.setFont(new Font("Arial",Font.BOLD,20));
        buttonEight.setFocusable(false);
        frame.add(buttonEight);

        buttonNine.setBounds(150,230,60,40);
        buttonNine.setFont(new Font("Arial",Font.BOLD,20));
        buttonNine.setFocusable(false);
        frame.add(buttonNine);

        buttonFour.setBounds(10,290,60,40);
        buttonFour.setFont(new Font("Arial",Font.BOLD,20));
        buttonFour.setFocusable(false);
        frame.add(buttonFour);

        buttonFive.setBounds(80,290,60,40);
        buttonFive.setFont(new Font("Arial",Font.BOLD,20));
        buttonFive.setFocusable(false);
        frame.add(buttonFive);

        buttonSix.setBounds(150,290,60,40);
        buttonSix.setFont(new Font("Arial",Font.BOLD,20));
        buttonSix.setFocusable(false);
        frame.add(buttonSix);

        buttonOne.setBounds(10,350,60,40);
        buttonOne.setFont(new Font("Arial",Font.BOLD,20));
        buttonOne.setFocusable(false);
        frame.add(buttonOne);

        buttonTwo.setBounds(80,350,60,40);
        buttonTwo.setFont(new Font("Arial",Font.BOLD,20));
        buttonTwo.setFocusable(false);
        frame.add(buttonTwo);

        buttonThree.setBounds(150,350,60,40);
        buttonThree.setFont(new Font("Arial",Font.BOLD,20));
        buttonThree.setFocusable(false);
        frame.add(buttonThree);

        buttonDot.setBounds(150,410,60,40);
        buttonDot.setFont(new Font("Arial",Font.BOLD,20));
        buttonDot.setFocusable(false);
        frame.add(buttonDot);

        buttonZero.setBounds(10,410,130,40);
        buttonZero.setFont(new Font("Arial",Font.BOLD,20));
        buttonZero.setFocusable(false);
        frame.add(buttonZero);

        buttonEqual.setBounds(220,350,60,100);
        buttonEqual.setFont(new Font("Arial",Font.BOLD,20));
        buttonEqual.setBackground(new Color(239,188,2));
        buttonEqual.setFocusable(false);
        frame.add(buttonEqual);

        buttonDiv.setBounds(220,110,60,40);
        buttonDiv.setFont(new Font("Arial",Font.BOLD,20));
        buttonDiv.setBackground(new Color(239,188,2));
        buttonDiv.setFocusable(false);
        frame.add(buttonDiv);

        buttonSqrt.setBounds(10,170,60,40);
        buttonSqrt.setFont(new Font("Arial",Font.BOLD,18));
        buttonSqrt.setBackground(Color.MAGENTA);
        buttonSqrt.setFocusable(false);
        frame.add(buttonSqrt);

        buttonMul.setBounds(220,230,60,40);
        buttonMul.setFont(new Font("Arial",Font.BOLD,20));
        buttonMul.setBackground(new Color(239,188,2));
        buttonMul.setFocusable(false);
        frame.add(buttonMul);

        buttonMinus.setBounds(220,170,60,40);
        buttonMinus.setFont(new Font("Arial",Font.BOLD,20));
        buttonMinus.setBackground(new Color(239,188,2));
        buttonMinus.setFocusable(false);
        frame.add(buttonMinus);

        buttonPlus.setBounds(220,290,60,40);
        buttonPlus.setFont(new Font("Arial",Font.BOLD,20));
        buttonPlus.setBackground(new Color(239,188,2));
        buttonPlus.setFocusable(false);
        frame.add(buttonPlus);

        log.setBounds(290, 110, 60, 40);
        log.setFont(new Font("Arial", Font.BOLD, 15));
        log.setBackground(Color.green);
        log.setFocusable(false);
        frame.add(log);

        cos.setBounds(290, 170, 60, 40);
        cos.setFont(new Font("Arial", Font.BOLD, 14));
        cos.setBackground(Color.green);
        cos.setFocusable(false);
        frame.getContentPane().add(cos);

        sin.setBounds(290, 230, 60, 40);
        sin.setFont(new Font("Arial", Font.BOLD, 15));
        sin.setBackground(Color.green);
        sin.setFocusable(false);
        frame.getContentPane().add(sin);

        tan.setBounds(290, 290, 60, 40);
        tan.setFont(new Font("Arial", Font.BOLD, 15));
        tan.setBackground(Color.green);
        tan.setFocusable(false);
        frame.getContentPane().add(tan);

        exp.setBounds(290, 350, 60, 40);
        exp.setFont(new Font("Arial", Font.BOLD, 14));
        exp.setBackground(Color.green);
        exp.setFocusable(false);
        frame.getContentPane().add(exp);

        fac.setBounds(290, 410, 60, 40);
        fac.setFont(new Font("Arial", Font.BOLD, 15));
        fac.setBackground(Color.green);
        fac.setFocusable(false);
        frame.add(fac);

        mr.setBounds(360, 410, 60, 40);
        mr.setFont(new Font("Arial", Font.BOLD, 15));
        mr.setBackground(Color.blue);
        mr.setFocusable(false);
        frame.add(mr);

        mc.setBounds(360, 350, 60, 40);
        mc.setFont(new Font("Arial", Font.BOLD, 15));
        mc.setBackground(Color.blue);
        mc.setFocusable(false);
        frame.add(mc);

        mp.setBounds(360, 290, 60, 40);
        mp.setFont(new Font("Arial", Font.BOLD, 15));
        mp.setBackground(Color.blue);
        mp.setFocusable(false);
        frame.add(mp);

        mm.setBounds(360, 230, 60, 40);
        mm.setFont(new Font("Arial", Font.BOLD, 15));
        mm.setBackground(Color.blue);
        mm.setFocusable(false);
        frame.add(mm);

        addSub.setBounds(360, 170, 60, 40);
        addSub.setFont(new Font("Arial", Font.BOLD, 15));
        addSub.setBackground(Color.blue);
        addSub.setFocusable(false);
        frame.add(addSub);

        buttonCube.setBounds(360, 110, 60, 40);
        buttonCube.setFont(new Font("Arial", Font.BOLD, 15));
        buttonCube.setBackground(Color.blue);
        buttonCube.setFocusable(false);
        frame.add(buttonCube);

        buttonSquare.setBounds(80,170,60,40);
        buttonSquare.setFont(new Font("Arial",Font.BOLD,20));
        buttonSquare.setBackground(Color.MAGENTA);
        buttonSquare.setFocusable(false);
        frame.add(buttonSquare);

        buttonReciprocal.setBounds(150,170,60,40);
        buttonReciprocal.setFont(new Font("Arial",Font.BOLD,15));
        buttonReciprocal.setBackground(Color.MAGENTA);
        buttonReciprocal.setFocusable(false);
        frame.add(buttonReciprocal);

        buttonDelete.setBounds(150,110,60,40);
        buttonDelete.setFont(new Font("Arial",Font.BOLD,12));
        buttonDelete.setBackground(Color.red);
        buttonDelete.setForeground(Color.white);
        buttonDelete.setFocusable(false);
        frame.add(buttonDelete);

        buttonClear.setBounds(80,110,60,40);
        buttonClear.setFont(new Font("Arial",Font.BOLD,12));
        buttonClear.setBackground(Color.red);
        buttonClear.setForeground(Color.white);
        buttonClear.setFocusable(false);
        frame.add(buttonClear);

        btnTemperatureConverter.setBounds(10, 460, 180, 40);
        btnTemperatureConverter.setFont(new Font("Arial",Font.BOLD,20));
        btnTemperatureConverter.setBackground(Color.DARK_GRAY);
        btnTemperatureConverter.setForeground(Color.white);
        btnTemperatureConverter.setFocusable(false);
        frame.add(btnTemperatureConverter);

        age.setBounds(200, 460, 90, 40);
        age.setFont(new Font("Arial",Font.BOLD,20));
        age.setBackground(Color.DARK_GRAY);
        age.setForeground(Color.white);
        age.setFocusable(false);
        frame.add(age);

        numbersystem.setBounds(10, 510, 200, 40);
        numbersystem.setFont(new Font("Arial",Font.BOLD,20));
        numbersystem.setBackground(Color.DARK_GRAY);
        numbersystem.setForeground(Color.white);
        age.setFocusable(false);
        frame.add(numbersystem);

        matrix.setBounds(220, 510, 100, 40);
        matrix.setFont(new Font("Arial",Font.BOLD,20));
        matrix.setBackground(Color.DARK_GRAY);
        matrix.setForeground(Color.white);
        matrix.setFocusable(false);
        frame.add(matrix);

        bmi.setBounds(330, 510, 80, 40);
        bmi.setFont(new Font("Arial",Font.BOLD,20));
        bmi.setBackground(Color.DARK_GRAY);
        bmi.setForeground(Color.white);
        bmi.setFocusable(false);
        frame.add(bmi);

        zakat.setBounds(310, 560, 100, 40);
        zakat.setFont(new Font("Arial",Font.BOLD,20));
        zakat.setBackground(Color.DARK_GRAY);
        zakat.setForeground(Color.white);
        zakat.setFocusable(false);
        frame.add(zakat);

        btnTemperatureConverter.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new TemperatureConverter();
            }
        });
        btnCGPA.setBounds(300, 460, 120, 40);
        btnCGPA.setFont(new Font("Arial", Font.BOLD, 20));
        btnCGPA.setBackground(Color.DARK_GRAY);
        btnCGPA.setForeground(Color.white);
        btnCGPA.setFocusable(false);
        frame.add(btnCGPA);

        area.setBounds(10, 560, 100, 40);
        area.setFont(new Font("Arial",Font.BOLD,20));
        area.setBackground(Color.DARK_GRAY);
        area.setForeground(Color.white);
        area.setFocusable(false);
        frame.add(area);

        equation.setBounds(120, 560, 180, 40);
        equation.setFont(new Font("Arial",Font.BOLD,20));
        equation.setBackground(Color.DARK_GRAY);
        equation.setForeground(Color.white);
        equation.setFocusable(false);
        frame.add(equation);
        btnCGPA.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new CGPACalculator();
            }
        });
        age.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new AgeCalculator();
            }
        });
        numbersystem.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new NumberSystemConverter();
            }
        });
        matrix.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new MatrixCalculator(2,2);
            }
        });
        bmi.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new Bmi_Calculator();
            }
        });
        area.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new AreaCalculator();
            }
        });
        equation.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new EquationCalculator();
            }
        });
        zakat.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new ZakatCalculator();
            }
        });
    }
    public void addActionEvent()
    {
        onRadioButton.addActionListener(this);
        offRadioButton.addActionListener(this);
        buttonDelete.addActionListener(this);
        buttonClear.addActionListener(this);
        buttonDiv.addActionListener(this);
        buttonSqrt.addActionListener(this);
        buttonSquare.addActionListener(this);
        buttonReciprocal.addActionListener(this);
        buttonMinus.addActionListener(this);
        buttonSeven.addActionListener(this);
        buttonEight.addActionListener(this);
        buttonNine.addActionListener(this);
        buttonMul.addActionListener(this);
        buttonFour.addActionListener(this);
        buttonFive.addActionListener(this);
        buttonSix.addActionListener(this);
        buttonPlus.addActionListener(this);
        buttonOne.addActionListener(this);
        buttonTwo.addActionListener(this);
        buttonThree.addActionListener(this);
        buttonEqual.addActionListener(this);
        buttonZero.addActionListener(this);
        buttonDot.addActionListener(this);
        mr.addActionListener(this);
        mc.addActionListener(this);
        mp.addActionListener(this);
        mm.addActionListener(this);
        addSub.addActionListener(this);
        log.addActionListener(this);
        sin.addActionListener(this);
        cos.addActionListener(this);
        tan.addActionListener(this);
        exp.addActionListener(this);
        fac.addActionListener(this);
        buttonCube.addActionListener(this);
        btnTemperatureConverter.addActionListener(this);
        btnCGPA.addActionListener(this);
        age.addActionListener(this);
        numbersystem.addActionListener(this);
        matrix.addActionListener(this);
        bmi.addActionListener(this);
        area.addActionListener(this);
        equation.addActionListener(this);
        zakat.addActionListener(this);
    }

    public static void main(String[] args)
    {
        ScienteficCalculator calculator=new ScienteficCalculator();
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source=e.getSource();
        if(source==onRadioButton)
        {
            enable();
        }
        else if(source==offRadioButton)
        {
            disable();
        }
        else if(source==buttonClear)
        {
            label.setText("");
            textField.setText("");
        }
        else if(source==buttonDelete)
        {
        int length=textField.getText().length();
        int number=length-1;
        if(length>0)
        {
            StringBuilder back=new StringBuilder(textField.getText());
            back.deleteCharAt(number);
            textField.setText(back.toString());
        }
        if(textField.getText().endsWith(""))
        {
            label.setText("");
        }
        }
        else if(source==buttonZero)
        {
        if(textField.getText().equals("0"))
        {
            return;
        }
        else
        {
            textField.setText(textField.getText()+"0");
        }
        }
        else if(source==buttonOne)
        {
            textField.setText(textField.getText()+"1");
        }
        else if(source==buttonTwo)
        {
            textField.setText(textField.getText()+"2");
        }
        else if(source==buttonThree)
        {
            textField.setText(textField.getText()+"3");
        }
        else if(source==buttonFour)
        {
            textField.setText(textField.getText()+"4");
        }
        else if(source==buttonFive)
        {
            textField.setText(textField.getText()+"5");
        }
        else if(source==buttonSix)
        {
            textField.setText(textField.getText()+"6");
        }
        else if(source==buttonSeven)
        {
            textField.setText(textField.getText()+"7");
        }
        else if(source==buttonEight)
        {
            textField.setText(textField.getText()+"8");
        }
        else if(source==buttonNine)
        {
            textField.setText(textField.getText()+"9");
        }
        else if(source==buttonDot)
        {
            if(textField.getText().contains("."))
            {
                return;
            }
            else
            {
                textField.setText(textField.getText()+".");
            }
        }
        else if(source==buttonPlus)
        {
            String str=textField.getText();
            num1=Double.parseDouble(textField.getText());
            calculation=1;
            textField.setText("");
            label.setText(str +"+");
        }
        else if(source==buttonMinus)
        {
            String str=textField.getText();
            num1=Double.parseDouble(textField.getText());
            calculation=2;
            textField.setText("");
            label.setText(str +"-");
        }
        else if(source==buttonMul)
        {
            String str=textField.getText();
            num1=Double.parseDouble(textField.getText());
            calculation=3;
            textField.setText("");
            label.setText(str +"X");
        }
        else if(source==buttonDiv)
        {
            String str=textField.getText();
            num1=Double.parseDouble(textField.getText());
            calculation=4;
            textField.setText("");
            label.setText(str +"/");
        }
        else if(source==buttonSquare)
        {
            num1=Double.parseDouble(textField.getText());
            double square=Math.pow(num1,2);
            String string=Double.toString(square);
            if(string.endsWith(".0"))
            {
                textField.setText(string.replace(".0", ""));
            }
            else
            {
                textField.setText(string);
            }
        }
        else if(source==buttonSqrt)
        {
            num1=Double.parseDouble(textField.getText());
            double sqrt=Math.sqrt(num1);
            textField.setText(Double.toString(sqrt));
        }
        else if(source==buttonReciprocal)
        {
            num1=Double.parseDouble(textField.getText());
            double reciprocal=1/num1;
            String string=Double.toString(reciprocal);
            if(string.endsWith(".0"))
            {
                textField.setText(string.replace(".0", ""));
            }
            else
            {
                textField.setText(string);
            }
        }
        else if(source==buttonEqual)
        {
            num2=Double.parseDouble(textField.getText());
            switch (calculation)
            {
                case 1:
                    result=num1+num2;
                    break;
                case 2:
                    result=num1-num2;
                    break;
                case 3:
                    result=num1*num2;
                    break;
                case 4:
                    result=num1/num2;
                    break;
            }
            if(Double.toString(result).endsWith(".0"))
            {
                textField.setText(Double.toString(result).replace(".0",""));
            }
            else
            {
                textField.setText(Double.toString(result));
            }
            label.setText("");
            num1=result;
        }
        if (source == mr)
        {
            textField.setText(Double.toString(memory));
        }
        else if (source == mc)
        {
            memory = 0;
        }
        else if (source == mp)
        {
            memory += Double.parseDouble(textField.getText());
        }
        else if (source == mm)
        {
            memory -= Double.parseDouble(textField.getText());
        }
        else if (source == addSub)
        {
            double num = Double.parseDouble(textField.getText());
            textField.setText(Double.toString(-num));
        }
        else if (source == log)
        {
            double num = Double.parseDouble(textField.getText());
            if (num > 0)
            {
                textField.setText(Double.toString(Math.log10(num)));
            }
            else
            {
                textField.setText("Error");
            }
        }
        else if (source == sin)
        {
            double num = Double.parseDouble(textField.getText());
            textField.setText(Double.toString(Math.sin(Math.toRadians(num))));
        }
        else if (source == cos)
        {
            double num = Double.parseDouble(textField.getText());
            textField.setText(Double.toString(Math.cos(Math.toRadians(num))));
        }
        else if (source == tan)
        {
            double num = Double.parseDouble(textField.getText());
            double tangent = Math.tan(Math.toRadians(num));
            textField.setText(Double.toString(tangent));
        }
        else if (source == exp)
        {
            double num = Double.parseDouble(textField.getText());
            textField.setText(Double.toString(Math.exp(num)));
        }
        else if (source == fac)
        {
            int num = Integer.parseInt(textField.getText());
            if (num >= 0)
            {
                textField.setText(Integer.toString(factorial(num)));
            }
            else
            {
                textField.setText("Error");
            }
        }
        else if (source == buttonCube)
        {
        double num = Double.parseDouble(textField.getText());
        double cube = Math.pow(num, 3);
        textField.setText(textField.getText() + "^3");
        if (Double.toString(cube).endsWith(".0"))
        {
            textField.setText(textField.getText() + " = " + Double.toString(cube).replace(".0", ""));
        }
        else
        {
            textField.setText(textField.getText() + " = " + Double.toString(cube));
        }
    }
}
    public int factorial(int n)
    {
        if (n == 0) return 1;
        int result = 1;
        for (int i = 1; i <= n; i++)
        {
            result *= i;
        }
        return result;
    }
    public void enable()
    {
        onRadioButton.setEnabled(false);
        offRadioButton.setEnabled(true);
        textField.setEnabled(true);
        label.setEnabled(true);
        buttonClear.setEnabled(true);
        buttonDelete.setEnabled(true);
        buttonDiv.setEnabled(true);
        buttonSqrt.setEnabled(true);
        buttonSquare.setEnabled(true);
        buttonReciprocal.setEnabled(true);
        buttonMinus.setEnabled(true);
        buttonSeven.setEnabled(true);
        buttonEight.setEnabled(true);
        buttonNine.setEnabled(true);
        buttonMul.setEnabled(true);
        buttonFour.setEnabled(true);
        buttonFive.setEnabled(true);
        buttonSix.setEnabled(true);
        buttonPlus.setEnabled(true);
        buttonOne.setEnabled(true);
        buttonTwo.setEnabled(true);
        buttonThree.setEnabled(true);
        buttonEqual.setEnabled(true);
        buttonZero.setEnabled(true);
        buttonDot.setEnabled(true);
        mr.setEnabled(true);
        mc.setEnabled(true);
        mp.setEnabled(true);
        mm.setEnabled(true);
        addSub.setEnabled(true);
        log.setEnabled(true);
        sin.setEnabled(true);
        cos.setEnabled(true);
        tan.setEnabled(true);
        exp.setEnabled(true);
        fac.setEnabled(true);
        buttonCube.setEnabled(true);
        btnTemperatureConverter.setEnabled(true);
        btnCGPA.setEnabled(true);
        age.setEnabled(true);
        numbersystem.setEnabled(true);
        matrix.setEnabled(true);
        bmi.setEnabled(true);
        area.setEnabled(true);
        equation.setEnabled(true);
        zakat.setEnabled(true);
    }
    public void disable()
    {
        onRadioButton.setEnabled(true);
        offRadioButton.setEnabled(false);
        textField.setEnabled(false);
        label.setEnabled(false);
        label.setText("");
        textField.setText("");
        buttonClear.setEnabled(false);
        buttonDelete.setEnabled(false);
        buttonDiv.setEnabled(false);
        buttonSqrt.setEnabled(false);
        buttonSquare.setEnabled(false);
        buttonReciprocal.setEnabled(false);
        buttonMinus.setEnabled(false);
        buttonSeven.setEnabled(false);
        buttonEight.setEnabled(false);
        buttonNine.setEnabled(false);
        buttonMul.setEnabled(false);
        buttonFour.setEnabled(false);
        buttonFive.setEnabled(false);
        buttonSix.setEnabled(false);
        buttonPlus.setEnabled(false);
        buttonOne.setEnabled(false);
        buttonTwo.setEnabled(false);
        buttonThree.setEnabled(false);
        buttonEqual.setEnabled(false);
        buttonZero.setEnabled(false);
        buttonDot.setEnabled(false);
        mr.setEnabled(false);
        mc.setEnabled(false);
        mp.setEnabled(false);
        mm.setEnabled(false);
        addSub.setEnabled(false);
        log.setEnabled(false);
        sin.setEnabled(false);
        cos.setEnabled(false);
        tan.setEnabled(false);
        exp.setEnabled(false);
        fac.setEnabled(false);
        buttonCube.setEnabled(false);
        btnTemperatureConverter.setEnabled(false);
        btnCGPA.setEnabled(false);
        age.setEnabled(false);
        numbersystem.setEnabled(false);
        matrix.setEnabled(false);
        bmi.setEnabled(false);
        area.setEnabled(false);
        equation.setEnabled(false);
        zakat.setEnabled(false);
    }
}