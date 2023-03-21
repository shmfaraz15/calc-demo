import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JButton[] buttons;
    private String[] buttonLabels = {
            "7", "8", "9", "x^2",  "4", "5", "6","sqrt", "1", "2", "3","x!","0", ".", "=", "ln",  "-", "*",  "+", "C"
    };
    private double firstOperand;
    private String operator;
    private boolean secondOperand;

    public Calculator() {
        setTitle("Scientific Calculator");
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        textField = new JTextField();
        textField.setEditable(false);
        panel.add(textField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4));
        buttons = new JButton[buttonLabels.length];
        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].addActionListener(this);
            buttonPanel.add(buttons[i]);
        }
        panel.add(buttonPanel, BorderLayout.CENTER);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String buttonText = ((JButton)e.getSource()).getText();
        switch (buttonText) {
            case "C":
                textField.setText("");
                firstOperand = 0;
                secondOperand = false;
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                operator = buttonText;
                firstOperand = Double.parseDouble(textField.getText());
                textField.setText("");
                secondOperand = true;
                break;
            case "=":
                if (secondOperand) {
                    double secondOperandValue = Double.parseDouble(textField.getText());
                    double result = 0;
                    switch (operator) {
                        case "+":
                            result = firstOperand + secondOperandValue;
                            break;
                        case "-":
                            result = firstOperand - secondOperandValue;
                            break;
                        case "*":
                            result = firstOperand * secondOperandValue;
                            break;
                        case "/":
                            result = firstOperand / secondOperandValue;
                            break;
                    }
                    textField.setText(Double.toString(result));
                    secondOperand = false;
                }
                break;
            case "x^2":
                double operandValue = Double.parseDouble(textField.getText());
                double squaredValue = operandValue * operandValue;
                textField.setText(Double.toString(squaredValue));
                break;
            case "sqrt":
                double sqrtValue = Math.sqrt(Double.parseDouble(textField.getText()));
                textField.setText(Double.toString(sqrtValue));
                break;
            case "ln":
                double lnValue = Math.log(Double.parseDouble(textField.getText()));
                textField.setText(Double.toString(lnValue));
                break;
            case "x!":
                int factorialValue = Integer.parseInt(textField.getText());
                int result = 1;
                for (int i = factorialValue; i > 0; i--) {
                    result *= i;
                }
                textField.setText(Integer.toString(result));
                break;
            default:
                textField.setText(textField.getText() + buttonText);
                break;
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
