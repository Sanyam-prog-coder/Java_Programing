import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;

/////////////////////////////////////////////////////////////////////////////////////////////////
//
// Function     : Calculator
// Description  : To create a simple Calculator with GUI & using the Button
// Auther       : Sanyam BhupendraKumar Ravne
// Date         : 05/11/2025
//
/////////////////////////////////////////////////////////////////////////////////////////////////

class Calculator implements ActionListener
{
    // Characteristics

    JFrame fobj;
    JTextField Numtxt1, Numtxt2;
    JLabel Numberlabel1, Numberlabel2, Resultlabel;
    JButton addbtn, subbtn, multbtn, divbtn;

    public Calculator(String title, int width, int height)
    {
        fobj = new JFrame(title);

        Numberlabel1 = new JLabel("Number 1");
        Numberlabel1.setBounds(50,50,100,30);

        Numtxt1 = new JTextField();
        Numtxt1.setBounds(150,50,150,30);

        Numberlabel2 = new JLabel("Number 2");
        Numberlabel2.setBounds(50,100,100,30);

        Numtxt2 = new JTextField();
        Numtxt2.setBounds(150,100,150,30);

        addbtn = new JButton("+");
        addbtn.setBounds(50,160,50,30);

        subbtn = new JButton("-");
        subbtn.setBounds(110,160,50,30);

        multbtn = new JButton("*");
        multbtn.setBounds(170,160,50,30);

        divbtn = new JButton("/");
        divbtn.setBounds(230,160,50,30);

        Resultlabel = new JLabel("Result : ");
        Resultlabel.setBounds(50,210,250,30);

        fobj.getContentPane().setBackground(Color.ORANGE);

        fobj.add(Numberlabel1);
        fobj.add(Numtxt1);
        fobj.add(Numberlabel2);
        fobj.add(Numtxt2);
        fobj.add(addbtn);
        fobj.add(subbtn);
        fobj.add(multbtn);
        fobj.add(divbtn);
        fobj.add(Resultlabel);

        addbtn.addActionListener(this);
        subbtn.addActionListener(this);
        multbtn.addActionListener(this);
        divbtn.addActionListener(this);

        fobj.setLayout(null);

        fobj.setSize(width,height);

        fobj.setVisible(true);

        fobj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent aobj)
    {
        try
        {
            // Used to Convert the text entered by user in textfield into primitive data type

            double num1 = Double.parseDouble(Numtxt1.getText());
            double num2 = Double.parseDouble(Numtxt2.getText());
            double result = 0;

            // Using Loop to Calculate the Input
            
            if(aobj.getSource() == addbtn)
            {
                result = num1 + num2;
            }
            else if(aobj.getSource() == subbtn)
            {
                result = num1 - num2;
            }
            else if(aobj.getSource() == multbtn)
            {
                result = num1 * num2;
            }
            else if(aobj.getSource() == divbtn)
            {
                result = num1 / num2;
            }
            Resultlabel.setText("Result : " + result);
        }
        catch(NumberFormatException ne)
        {
            Resultlabel.setText("Error : Enter Valid Number...");
        }
    }
}

class CalculatorFrame
{
    public static void main(String A[])
    {
       Calculator cobj = new Calculator("Calculator",400,300);
    }
}
/////////////////////////////////////////////////////////////////////////////////////////////////
//
// Input : 12   Input : 4   Output : 16 if press Buttuon Addition'+'
// Input : 12   Input : 4   Output : 8  if press Buttuon Substraction'-'
// Input : 12   Input : 4   Output : 48 if press Buttuon Multiplication'*'
// Input : 12   Input : 4   Output : 3  if press Buttuon Division'/'
//
/////////////////////////////////////////////////////////////////////////////////////////////////
