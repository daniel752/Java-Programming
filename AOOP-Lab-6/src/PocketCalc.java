import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * PocketCalc is a calculator with simple functionalities
 * the calculator works with strings(operand1,operand2,operator)
 * @author daniel arbiv
 * @version 1.0
 * @since 23/04/2021
 */

public class PocketCalc implements ActionListener
{
    private static JTextField inputField;
    private static JFrame calcFrame;
    private String s1,s2,s3;
    public static int[] numeric = {0,1,2,3,4,5,6,7,8,9};

    public PocketCalc()
    {
        s1=s2=s3="";
    }

    /**
     * in the main function we will set up the frame and all other visual aspects for the calculator
     * @param args
     */
    public static void main(String[] args)
    {
        PocketCalc calc = new PocketCalc();
        JFrame calcFrame = new JFrame("Java Swing Calculator");
        calcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inputField = new JTextField(10);
        inputField.setBackground(Color.white);
        inputField.setEditable(false);
        JToolBar toolBar = new JToolBar();
        toolBar.add(new JButton("File"));
        toolBar.add(new JButton("Help"));
        JPanel buttonPanel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        buttonPanel.setLayout(layout);
        ArrayList<JButton> numButtons = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            numButtons.add(new JButton(String.valueOf(i)));
        JButton backspaceButton = new JButton("Backspace");
        JButton clearAllButton = new JButton("CE");
        JButton clearButton = new JButton("C");
        JButton plusButton = new JButton("+");
        JButton minusButton = new JButton("-");
        JButton divideButton = new JButton("/");
        JButton multiplyButton = new JButton("*");
        JButton sqrtButton = new JButton("sqrt");
        JButton divideByNumButton = new JButton("1/x");
        JButton moduloButton = new JButton("%");
        JButton equalsButton = new JButton("=");
        JButton dotButton = new JButton(".");
        JButton negateButton = new JButton("+/-");

        //Setting action listeners for buttons
        for (int i = 0; i < 10; i++)
            numButtons.get(i).addActionListener(calc);
        backspaceButton.addActionListener(calc);
        clearAllButton.addActionListener(calc);
        clearButton.addActionListener(calc);
        plusButton.addActionListener(calc);
        minusButton.addActionListener(calc);
        divideButton.addActionListener(calc);
        multiplyButton.addActionListener(calc);
        sqrtButton.addActionListener(calc);
        divideByNumButton.addActionListener(calc);
        moduloButton.addActionListener(calc);
        equalsButton.addActionListener(calc);
        dotButton.addActionListener(calc);
        negateButton.addActionListener(calc);

        //Setting the grid bagLayout
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridwidth = 7;
        constraints.gridx = 0;constraints.gridy = 0;buttonPanel.add(inputField,constraints);
        constraints.gridwidth = 3;
        constraints.gridx = 0;constraints.gridy = 1;buttonPanel.add(backspaceButton,constraints);
        constraints.gridwidth = 1;
        constraints.gridx = 3;buttonPanel.add(clearAllButton,constraints);
        constraints.gridx = 4;buttonPanel.add(clearButton,constraints);
        constraints.gridx = 0;constraints.gridy = 2;buttonPanel.add(numButtons.get(7),constraints);
        constraints.gridx = 1;buttonPanel.add(numButtons.get(8),constraints);
        constraints.gridx = 2;buttonPanel.add(numButtons.get(9),constraints);
        constraints.gridx = 3;buttonPanel.add(divideButton,constraints);
        constraints.gridx = 4;buttonPanel.add(sqrtButton,constraints);
        constraints.gridx = 0;constraints.gridy = 3;buttonPanel.add(numButtons.get(4),constraints);
        constraints.gridx = 1;buttonPanel.add(numButtons.get(5),constraints);
        constraints.gridx = 2;buttonPanel.add(numButtons.get(6),constraints);
        constraints.gridx = 3;buttonPanel.add(multiplyButton,constraints);
        constraints.gridx = 4;buttonPanel.add(divideByNumButton,constraints);
        constraints.gridx = 0;constraints.gridy = 4;buttonPanel.add(numButtons.get(1),constraints);
        constraints.gridx = 1;buttonPanel.add(numButtons.get(2),constraints);
        constraints.gridx = 2;buttonPanel.add(numButtons.get(3),constraints);
        constraints.gridx = 3;buttonPanel.add(minusButton,constraints);
        constraints.gridx = 4;buttonPanel.add(moduloButton,constraints);
        constraints.gridx = 0;constraints.gridy = 5;buttonPanel.add(numButtons.get(0),constraints);
        constraints.gridx = 1;buttonPanel.add(negateButton,constraints);
        constraints.gridx = 2;buttonPanel.add(dotButton,constraints);
        constraints.gridx = 3;buttonPanel.add(plusButton,constraints);
        constraints.gridx = 4;buttonPanel.add(equalsButton,constraints);
        calcFrame.add(toolBar,BorderLayout.PAGE_START);
        calcFrame.getContentPane().add(buttonPanel,BorderLayout.CENTER);
        calcFrame.setSize(400,300);
        calcFrame.setLocationRelativeTo(null);
        calcFrame.setVisible(true);
    }

    /**
     * this method gets every button press as action and translates that action to string "command"
     * then evaluates the command and adds the command to the rest of "inputField" or returning the result
     * @param e This is a button press action
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        String newText = "";
        if(command.equals("C"))
            inputField.setText("");
        /*
          if statements to implement action of "CE" and "Backspace"
         */
        else if(command.equals("CE") || command.equals("Backspace"))
        {
            int position = inputField.getDocument().getEndPosition().getOffset();
                newText = inputField.getText();
                newText = newText.substring(0,newText.length()-1);
            inputField.setText(newText);
        }
        else if(command.equals("sqrt"))//square root
            inputField.setText(String.valueOf(Math.sqrt(Double.parseDouble(inputField.getText()))));
        else if(command.equals("+/-"))//negate
            inputField.setText(String.valueOf(-Double.parseDouble(inputField.getText())));
        else if(command.equals("1/x"))//1 divided by x (number)
            inputField.setText(String.valueOf(1/Double.parseDouble(inputField.getText())));
        else if(command.equals("="))//equals
            inputField.setText(evaluate(inputField.getText()));
        /*
          if no operator actions have been entered than we will just add the command to the rest of "inputField"
         */
        else
            inputField.setText(inputField.getText()+command);
    }

    /**
     * this method is in charge of the evaluation of every "exp" (expression)
     * it runs in a loop over the "exp",every number is entered to "operand1" or "operand2"
     * and every operator(symbol - '+','-',...) to "operator"
     * @param exp Expression to be evaluated
     */
    public static String evaluate(String exp)
    {
        char[] expArr = exp.toCharArray();
        String operand1 = "";
        String operand2 = "";
        String operator = "";
        double result = 0;

        for(int i=0;i<expArr.length;i++)
        {
            /*
              this if statement check the "expArr[i]" by ascii
              numbers - (0,1,2,...,9) are from 48 - 57
              46 in ascii is '.' (dot)
             */
            if ((int)expArr[i] >= 48 && (int)expArr[i] <= 57 || (int)expArr[i] == 46)
            {
                if (operator.isEmpty())
                    operand1 += expArr[i];
                else
                    operand2 += expArr[i];
            }
            /*
              this if statement evaluates result by char comparison
             */
            if (expArr[i] == '+' || expArr[i] == '-' || expArr[i] == '/' || expArr[i] == '*' || expArr[i] == '%')
                operator += expArr[i];
            if(i+2 <= expArr.length)
            {
                if (expArr[i] == '+' && expArr[i + 1] == '/' && expArr[i + 2] == '-')
                    for (int j = i; j < 3; j++)
                        operator += expArr[j];
                else if (expArr[i] == '1' && expArr[i + 1] == '/' && expArr[i + 2] == 'x')
                    for (int j = i; j < 3; j++)
                        operator += expArr[j];
                else if (expArr[i] == 's')
                    for (int j = i; j < 4; j++)
                        operator += expArr[j];
            }
        }
        /*
          if statements to for the final result (after the '=' (equals) button is pressed)
         */
        if(operator.equals("+"))
            result = Double.parseDouble(operand1)+Double.parseDouble(operand2);
        else if(operator.equals("-"))
            result = Double.parseDouble(operand1)-Double.parseDouble(operand2);
        else if(operator.equals("*"))
            result = Double.parseDouble(operand1)*Double.parseDouble(operand2);
        else if(operator.equals("/"))
            result = Double.parseDouble(operand1)/Double.parseDouble(operand2);
        else if(operator.equals("%"))
            result = Double.parseDouble(operand1)%Double.parseDouble(operand2);

        return operand1 + operator + operand2 + "=" + result;
    }
}
